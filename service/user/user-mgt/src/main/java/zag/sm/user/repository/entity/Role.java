package zag.sm.user.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "title_en")
    private String titleEn;

    @Basic
    @Column(name = "level")
    private Integer level;

    @Basic
    @Column(name = "parent_role_id")
    private Integer parentRoleId;

    @CreatedDate
    @Column(name = "created_on")
    private Date createdOn;
}
