package zag.sm.report.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zag.sm.report.repository.entity.Report;

import java.util.List;

@Repository
public interface ReportJPARepository extends JpaRepository<Report, Long> {

    //        List<Report> findByPostId(Long postId);
    @Query("SELECT r FROM Report r WHERE r.postId = :postId")
    List<Report> findAllByPostId(@Param("postId") Long postId);

    @Query("SELECT r FROM Report r WHERE r.id = :reportId AND r.postId = :postId")
    List<Report> findAllByReportIdAndByPostId(@Param("reportId") Long reportId,@Param("postId") Long postId);

    @Query("SELECT r FROM Report r WHERE r.postId = :postId AND r.id != :excludeReportId")
    List<Report> findRelatedReports(@Param("postId") Long postId, @Param("excludeReportId") Long excludeReportId);

    @Query("SELECT EXISTS (SELECT 1 FROM Report r WHERE r.status.id = 1 AND r.postId = :postId AND r.createdById = :createdById)")
    boolean existsByPostIdAndCreatedByIdAndStatus(@Param("postId") Long postId, @Param("createdById") Long createdById);

}
