package zag.sm.post.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zag.sm.post.repository.entity.Post;


@Repository
public interface PostJPARepository extends JpaRepository<Post, Long> {

//    @Modifying
//    @Query("UPDATE Post p SET p.isDeleted = true WHERE p.id = :postId")
//    void softDeleteById(@Param("postId") Long postId);

    //Optional<Post> findById(Long postId);
}
