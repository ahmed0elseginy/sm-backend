package zag.sm.report.service;

import zag.sm.report.model.vto.PostVTO;

public interface PostService {

    PostVTO getPostById(Long postId);

    void deletePostById(Long postId);

}
