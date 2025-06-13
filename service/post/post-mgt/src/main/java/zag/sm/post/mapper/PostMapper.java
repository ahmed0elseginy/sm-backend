package zag.sm.post.mapper;

import org.mapstruct.*;
import zag.sm.post.model.CommentEventData;
import zag.sm.post.model.CommentReactionEventData;
import zag.sm.post.model.PostEventData;
import org.springframework.beans.factory.annotation.Autowired;
import zag.library.session.api.service.RequestContext;
import zag.library.session.core.model.enums.CommonRequestContextKeys;
import zag.sm.post.repository.entity.Comment;
import zag.sm.post.repository.entity.CommentReaction;
import zag.sm.post.repository.entity.Post;
import zag.sm.post.model.generated.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@MapperConfig(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public abstract class PostMapper {

    @Autowired
    private RequestContext context;

    public Long getCurrentUserId() {
        return context.get(CommonRequestContextKeys.USER_ID, Long.class);
    }

    public abstract CommentResultSet toCommentResultSet(Comment comment, Long numOfLikes, Long numOfdisLikes);

    @Mapping(target = "id", ignore = true)   //ignore the id of the comment
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "createdById", expression = "java(getCurrentUserId())")
    @Mapping(target = "post", source = "post")
    @Mapping(target = "content", source = "dto.content")
    public abstract Comment toComment(CommentDTO dto, Post post);

    public abstract PostResultSet toPostResultSet(Post post);

    public abstract Post PostDTOToPost(PostDTO postDTO, Long createdById);

    @Mapping(source = "post.id", target = "id")
    @Mapping(source = "post.title", target = "title")
    @Mapping(source = "post.content", target = "content")
    @Mapping(source = "post.createdOn", target = "createdOn")
    @Mapping(source = "lightUser", target = "createdBy")
    public abstract PostVTO toPostVTO(Post post, LightUserVTO lightUser, @MappingTarget PostVTO postVTO);


    @Mapping(source = "post.id", target = "id")
    @Mapping(source = "post.title", target = "title")
    @Mapping(source = "post.content", target = "content")
    @Mapping(source = "post.createdOn", target = "createdOn")
    @Mapping(source = "lightUser", target = "createdBy")
    public abstract PostListItem toPostListItem(Post post, LightUserVTO lightUser, @MappingTarget PostListItem postListItem);

    @Mapping(source = "reaction.comment", target = "comment")
    public abstract CommentReactionEventData toReactionEventData(CommentReaction reaction);

    public abstract PostEventData toPostEventData(Post post);

    @Mapping(source = "comment.post", target = "post")
    @Mapping(source = "comment.createdById", target = "createdById")
    @Mapping(source = "comment.content", target = "content")
    @Mapping(source = "comment.createdOn", target = "createdOn")
    @Mapping(source = "comment.id", target = "id")
    public abstract CommentEventData toCommentEventData(Comment comment);


}
