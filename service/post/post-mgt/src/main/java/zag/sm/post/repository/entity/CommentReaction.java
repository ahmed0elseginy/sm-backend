package zag.sm.post.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zag.sm.post.model.generated.CommentReactions;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "comment_reaction")
public class CommentReaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comment_id",updatable = false)
    private Comment comment;

    @Basic
    @Column(name = "created_on", insertable = false, updatable = false)
    private Date createdOn;

    @Basic
    @Column(name = "created_by_id",updatable = false)
    private Long createdById;

    @Enumerated(EnumType.STRING)
    @Column(name = "react")
    private CommentReactions react;
}
