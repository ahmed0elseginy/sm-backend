package zag.sm.user.repository.entity.pk;

import lombok.Data;
import lombok.NoArgsConstructor;
import zag.sm.user.repository.entity.Role;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserRoleId implements Serializable {
    private Role role; /// foreign key to role table

    private Long userId; /// foreign key to user table
}
