package zag.sm.user.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserStatuses {
    PENDING(1, "Pending"),
    ACTIVATED(2, "Activated")
    ;
    private final Integer id;
    private final String titleEn;

    public Integer id() {
        return id;
    }

    public String title() {
        return titleEn;
    }
}
