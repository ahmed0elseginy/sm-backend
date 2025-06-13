package zag.sm.user.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRoles {
    ADMIN(1, "Admin"),
    MEMBER(2, "Member");

    public static final String ADMIN_ROLE = "1";
    public static final String MEMBER_ROLE = "2";

    private final Integer id;
    private final String title;
}
