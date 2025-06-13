package zag.sm.post.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;
import zag.sm.post.controller.generated.PostController;
import zag.sm.post.service.PostService;
import zag.sm.post.model.generated.*;

import java.util.Date;

import static zag.sm.user.model.enums.UserRoles.ADMIN_ROLE;
import static zag.sm.user.model.enums.UserRoles.MEMBER_ROLE;


@RestController
public class PostControllerImpl implements PostController {

    private final PostService postService;

    public PostControllerImpl(PostService postService) {
        this.postService = postService;
    }

    @Override
    @Secured({MEMBER_ROLE, ADMIN_ROLE})
    public ResponseEntity<Long> _createPost(PostDTO postDTO) {
        return ResponseEntity.ok(postService.createPost(postDTO));
    }

    @Override
    @Secured({MEMBER_ROLE, ADMIN_ROLE})
    public ResponseEntity<Void> _deletePost(Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @Secured({MEMBER_ROLE, ADMIN_ROLE})
    public ResponseEntity<PostResultSet> _getAllPostsByFilters(
            String title, Long createdById, Date createdOnFrom, Date createdOnTo,
            GetAllPostsOrderByAttributes orderBy, OrderDirections orderDir, Integer pageOffset, Integer pageSize) {
        return ResponseEntity.ok(postService.getAllPostsByFilters(title, createdById,
                createdOnFrom, createdOnTo, orderBy, orderDir, pageOffset, pageSize));
    }

    @Override
    @Secured({MEMBER_ROLE, ADMIN_ROLE})
    public ResponseEntity<PostVTO> _getPostById(Long id) {
        return ResponseEntity.ok(postService.getLightPostById(id));
    }

    @Override
    public ResponseEntity<PostVTO> _getSpecificPost(Long id) {
        return ResponseEntity.ok(postService.getSpecficPostById(id));
    }


}
