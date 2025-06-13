package zag.sm.post.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zag.library.error.exception.BusinessException;
import zag.library.session.api.service.RequestContext;
import zag.sm.post.model.generated.PostRateDTO;
import zag.sm.post.repository.entity.Post;
import zag.sm.post.repository.entity.Rate;
import zag.sm.post.repository.jpa.RateJPARepository;

import java.util.Date;

import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_ID;
import static zag.sm.post.model.enums.PostErrors.POST_NOT_FOUND;


@AllArgsConstructor
@Service
public class RatingServiceImpl implements RatingService{


    private final RateJPARepository ratingRepo;
    private final RequestContext context;
    private final PostService postService;

    @Override
    public void submitPostRating(Long postId, PostRateDTO rateDTO) {
        Rate savedRating = null;
        Long currentUserId = context.get(USER_ID, Long.class);
        Rate existingRating = ratingRepo.findByPostIdAndCreatedById(postId, currentUserId);
        Date currentDate = new Date();
        Post currentPost = postService.getPostById(postId);

        if(!currentPost.getIsDeleted()){
            if (existingRating != null){
                existingRating.setPostRate(rateDTO.getValue());
                existingRating.setLastModifiedOn(currentDate);
                ratingRepo.save(existingRating);
            }
            else{
                Rate rating = Rate.builder()
                        .post(currentPost)
                        .createdById(currentUserId)
                        .postRate(rateDTO.getValue())
                        .build();
                ratingRepo.save(rating);
            }
        }
        else{
            throw(new BusinessException(POST_NOT_FOUND));
        }

    }

    @Override
    public Float getRatesAvg(Long postId) {
        Post currentPost = postService.getPostById(postId);
        if(!currentPost.getIsDeleted()) {
            return ratingRepo.getPostRatesAvg(postId);
        }
        else{
            throw(new BusinessException(POST_NOT_FOUND));
        }
    }
}
