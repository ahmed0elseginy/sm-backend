package zag.sm.report.repository.entity.workflow;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "workflow")
public class Workflow {

    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "title_en")
    private String title;
}
