package zag.sm.point.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zag.sm.point.repository.entity.Domain;

@Repository
public interface DomainJPARepository extends JpaRepository<Domain, Integer> {

}
