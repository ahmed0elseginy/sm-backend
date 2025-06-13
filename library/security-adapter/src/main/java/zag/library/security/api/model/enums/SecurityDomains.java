package zag.library.security.api.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;

@AllArgsConstructor
public enum SecurityDomains implements Domains<SecurityDomains> {
    SECURITY(101,""),
    LOGIN(102,""),
    JWT_TOKEN(103,"");

    private final Integer id;
    private final String topic;

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public String destination() {
        return null;
    }
}
