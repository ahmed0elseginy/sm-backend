package zag.sm.post.service;

import lombok.AllArgsConstructor;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import zag.library.common.model.data.ListResultSet;
import zag.library.error.exception.BusinessException;
import zag.library.filter.PaginationInfo;
import zag.library.filter.SortingInfo;
import zag.library.session.api.service.RequestContext;
import zag.sm.post.mapper.PostMapper;
import zag.sm.post.model.enums.PostDomains;
import zag.sm.post.model.enums.PostEvents;
import zag.sm.post.model.filter.PostSearchFilter;
import zag.sm.post.repository.entity.Post;
import zag.sm.post.repository.jpa.PostFiltersRepository;
import zag.sm.post.repository.jpa.PostJPARepository;
import zag.sm.post.model.generated.*;
import zag.sm.report.model.enums.ReportEvents;
import zag.sm.user.model.enums.UserRoles;

import java.util.Date;
import java.util.List;

import static zag.library.common.enums.AppHeaders.EVENT_NAME;
import static zag.library.session.core.model.enums.CommonRequestContextKeys.ROLES_IDS;
import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_ID;
import static zag.sm.post.model.enums.PostErrors.NOT_PERMITTED;
import static zag.sm.post.model.enums.PostErrors.POST_NOT_FOUND;
import static zag.sm.post.model.enums.PostEvents.CREATE_POST;
import static zag.sm.post.model.enums.PostEvents.DELETE_POST;
import static zag.sm.user.model.enums.UserRoles.ADMIN_ROLE;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostJPARepository postJPARepository;
    private final PostFiltersRepository filtersRepository;
    private final PostMapper postMapper;
    private final RequestContext context;
    private final UserService userService;
    private final JmsTemplate jmsTemplate;

    @Override
    public Long createPost(PostDTO postDTO) {
        Long currentUserId = context.get(USER_ID, Long.class);
        Post post = postMapper.PostDTOToPost(postDTO, currentUserId);
        Post savedPost = postJPARepository.save(post);

        jmsTemplate.convertAndSend(
                PostDomains.POST.destination(),
                postMapper.toPostEventData(post),
                message -> {
                    message.setStringProperty(EVENT_NAME.mqHeader(), CREATE_POST.name());
                    return message;
                });

        return savedPost.getId();

    }

    @Override
    public void deletePost(Long postId) {
        Post post = this.getPostById(postId);
        Long currentUserId = context.get(USER_ID, Long.class);
        // add check IsAdmin and delete the post
        if (!currentUserId.equals(post.getCreatedById())) {
            throw new BusinessException(NOT_PERMITTED);
        }
        Date currentDate = new Date();
        post.setIsDeleted(true);
        post.setLastModifiedOn(currentDate);
        postJPARepository.save(post);

        jmsTemplate.convertAndSend(
                PostDomains.POST.destination(),
                postMapper.toPostEventData(post),
                message -> {
                    message.setStringProperty(EVENT_NAME.mqHeader(), DELETE_POST.name());
                    return message;
                });

    }

    @Override
    public Post getPostById(Long postId) {

        Post post = postJPARepository.findById(postId)
                .orElseThrow(() -> new BusinessException(POST_NOT_FOUND));
/*
        List<Integer> userRoles=context.get(ROLES_IDS,List.class);  //return null

        if(userRoles.contains(UserRoles.ADMIN.getId())){
            return post;
        }else {
            if(post.getIsDeleted()){
                throw new BusinessException(POST_NOT_FOUND);
            }else{
                return post;
            }
*/
        if(post.getIsDeleted()){
            throw new BusinessException(POST_NOT_FOUND);
        }else{
            return post;
        }

    }

    @Override
    public PostVTO getLightPostById(Long postID) {
        PostVTO postVTO = new PostVTO();
        Post post = this.getPostById(postID);
        System.out.println(userService.getUsersByIds(List.of(post.getCreatedById())));
        LightUserVTO lightUser =
                userService.getUsersByIds(List.of(post.getCreatedById()))
                        .getData().get(0);
        return postMapper.toPostVTO(post, lightUser, postVTO);
    }

    @Override
    public PostVTO getSpecficPostById(Long postId) {
        PostVTO postVTO = new PostVTO();
        Post post = postJPARepository.findById(postId).orElseThrow(
                ()->new BusinessException(POST_NOT_FOUND)
        );
        LightUserVTO lightUser =
                userService.getUsersByIds(List.of(post.getCreatedById()))
                        .getData().get(0);
        return postMapper.toPostVTO(post, lightUser, postVTO);
    }

    @Override
    public PostResultSet getAllPostsByFilters(
            String title, Long createdById, Date createdOnFrom, Date createdOnTo,
            GetAllPostsOrderByAttributes orderBy, OrderDirections orderDir, Integer pageOffset, Integer pageSize) {

        PostSearchFilter filter = PostSearchFilter.builder().title(title).createdById(createdById).createdOnFrom(createdOnFrom).createdOnTo(createdOnTo)
                .pagination(PaginationInfo.builder().pageOffset(pageOffset).pageSize(pageSize).build())
                .sorting(SortingInfo.builder().orderBy(orderBy !=null ? orderBy.getValue() :null  ).orderDir(orderDir !=null ? orderDir.getValue() :null).build())
                .build();
        System.out.println(filter);
        ListResultSet<Post> postsFiltration = filtersRepository.findAllByFilters2(filter);
        System.out.println(postsFiltration);
        List<PostListItem> postListItems = postsFiltration.getData().stream().map(
                post -> {
                    PostListItem postListItem = new PostListItem();
                    LightUserVTO lightUser =
                            userService.getUsersByIds(List.of(post.getCreatedById()))
                                    .getData().get(0);
                    return postMapper.toPostListItem(post, lightUser, postListItem);
                }).toList();
        PostResultSet resultSet = new PostResultSet();
        resultSet.setData(postListItems);
        resultSet.setTotal(postsFiltration.getTotal());
        return resultSet;
    }
}