package zag.sm.point.model.vto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class UserEventData implements Serializable {

    private Long userId;

}
