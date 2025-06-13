package zag.sm.post.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "created_on", insertable = false, updatable = false)
    private Date createdOn;

    @Basic
    @Column(name = "last_Modified_On", insertable = false)
    private Date lastModifiedOn;

    @Basic
    @Column(name = "created_by_id" ,updatable = false)
    private Long createdById;

    @Basic
    @Column(name = "is_deleted", insertable = false)
    private Boolean isDeleted = false;


}
