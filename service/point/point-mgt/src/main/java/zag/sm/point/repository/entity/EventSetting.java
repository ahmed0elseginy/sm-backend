package zag.sm.point.repository.entity;

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
@Table(name = "event_setting")
public class EventSetting {
    @Id
    private int eventId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Basic
    @Column(name = "positive_points", nullable = false)
    private Integer positivePoints;

    @Basic
    @Column(name = "negative_points", nullable = false)
    private Integer negativePoints;

}
