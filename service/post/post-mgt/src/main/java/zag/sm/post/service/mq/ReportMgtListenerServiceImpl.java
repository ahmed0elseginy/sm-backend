package zag.sm.post.service.mq;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zag.sm.post.repository.entity.Post;
import zag.sm.post.repository.jpa.PostJPARepository;
import zag.sm.post.service.PostService;

import java.util.Date;

@Service
@AllArgsConstructor
public class ReportMgtListenerServiceImpl implements ReportMgtListenerService{

    private final PostService postService;
    private final PostJPARepository postJPARepository;

    @Override
    public void deletePost(Long postId) {
        Post post = postService.getPostById(postId);

        Date currentDate = new Date();
        post.setIsDeleted(true);
        post.setLastModifiedOn(currentDate);
        postJPARepository.save(post);
    }
}
