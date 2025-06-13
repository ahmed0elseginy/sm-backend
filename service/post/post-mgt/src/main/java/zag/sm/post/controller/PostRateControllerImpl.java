package zag.sm.post.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;
import zag.sm.post.controller.generated.PostRateController;
import zag.sm.post.model.generated.PostRateDTO;
import zag.sm.post.service.RatingService;

import static zag.sm.user.model.enums.UserRoles.ADMIN_ROLE;
import static zag.sm.user.model.enums.UserRoles.MEMBER_ROLE;


@RestController
@AllArgsConstructor
public class PostRateControllerImpl implements PostRateController {

    private final RatingService ratingService;

    @Override
    @Secured({MEMBER_ROLE, ADMIN_ROLE})
    public ResponseEntity<Float> _getPostAverageRating(Long postId) {
        Float averageRating = ratingService.getRatesAvg(postId);
        return ResponseEntity.status(HttpStatus.OK).body(averageRating);
    }

    @Override
    @Secured({MEMBER_ROLE, ADMIN_ROLE})
    public ResponseEntity<Void> _ratePost(Long postId, PostRateDTO postRateDTO) {
        ratingService.submitPostRating(postId, postRateDTO);
        return ResponseEntity.noContent().build();
    }
}
