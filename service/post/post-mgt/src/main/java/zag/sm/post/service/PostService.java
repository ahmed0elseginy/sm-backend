package zag.sm.post.service;

import zag.sm.post.model.generated.*;
import zag.sm.post.repository.entity.Post;


import java.util.Date;

public interface PostService {

    Long createPost(PostDTO postDTO);

    void deletePost(Long postId);

    public Post getPostById(Long postId);

    public PostResultSet getAllPostsByFilters(
            String title, Long createdById, java.util.Date createdOnFrom, Date createdOnTo,
            GetAllPostsOrderByAttributes orderBy, OrderDirections orderDir, Integer pageOffset, Integer pageSize);

    PostVTO getLightPostById(Long postID);

    PostVTO getSpecficPostById(Long postId);

}
