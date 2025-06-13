package zag.sm.post.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zag.sm.post.repository.entity.Rate;

@Repository
public interface RateJPARepository extends JpaRepository<Rate, Long> {

    @Query("SELECT AVG(r.postRate) FROM Rate r WHERE r.post.id = :postId")
    Float getPostRatesAvg(@Param("postId") Long postId);

    @Query("SELECT r FROM Rate r WHERE r.post.id = :postId AND r.createdById = :createdById")
    Rate findByPostIdAndCreatedById(@Param("postId") Long postId, @Param("createdById") Long createdById);

}
