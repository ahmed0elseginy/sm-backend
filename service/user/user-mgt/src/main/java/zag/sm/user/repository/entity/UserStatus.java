package zag.sm.user.repository.entity;

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
@Table(name = "user_status")
public class UserStatus {
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "title_en")
    private String titleEn;

}
