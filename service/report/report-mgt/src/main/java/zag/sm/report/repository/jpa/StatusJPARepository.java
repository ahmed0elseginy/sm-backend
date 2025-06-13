package zag.sm.report.repository.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import zag.sm.report.repository.entity.Report;
import org.springframework.stereotype.Repository;
import zag.sm.report.repository.entity.Status;

import java.util.Optional;

@Repository
public interface StatusJPARepository extends JpaRepository<Status, Integer> {

    //Optional<Status> findByTitle(String title);

}
