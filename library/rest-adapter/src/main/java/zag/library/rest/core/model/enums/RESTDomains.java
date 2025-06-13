package zag.library.rest.core.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;

@AllArgsConstructor
public enum RESTDomains implements Domains<RESTDomains> {
    REST(101,"");

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
