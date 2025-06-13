package zag.sm.user.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import zag.sm.user.model.generated.Genders;

import java.util.Date;

import static zag.sm.user.model.enums.UserStatuses.ACTIVATED;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "mobile_number")
    private String mobileNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Genders gender;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private UserStatus status;

    @Basic
    @Column(name = "created_on", insertable = false, updatable = false)
    private Date createdOn;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "created_by_id", insertable = false)
    private User createdBy; /// foreign key to this.user table

    @Basic
    @Column(name = "last_modified_on", insertable = false)
    private Date lastModifiedOn;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "last_modified_by_id")
    private User lastModifiedBy; /// foreign key to this.user table

    public void evaluateStatus() {
        this.status = UserStatus.builder().id(ACTIVATED.id()).build();
    }
}
