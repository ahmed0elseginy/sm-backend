package zag.sm.report.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import zag.sm.report.repository.entity.Category;

public interface CategoryJPARepository extends JpaRepository<Category,Integer> {
}
