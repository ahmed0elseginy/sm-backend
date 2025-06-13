package zag.sm.post.service;

import org.springframework.stereotype.Service;
import zag.sm.post.model.generated.PostRateDTO;


@Service
public interface RatingService {

    void submitPostRating(Long postId, PostRateDTO rateDTO);

    Float getRatesAvg(Long postId);
}
