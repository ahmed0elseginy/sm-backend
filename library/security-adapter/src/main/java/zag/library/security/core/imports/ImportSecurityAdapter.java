package zag.library.security.core.imports;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import zag.library.security.core.config.SecurityConfiguration;
import zag.library.security.core.filter.AuthenticationRESTFilter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = {ImportSecurityAdapter.Root.class})
public @interface ImportSecurityAdapter {

    @Import(value = {SecurityConfiguration.class, AuthenticationRESTFilter.class})
    @ComponentScan(basePackages = {"zag.library.security.core.service", "zag.library.security.core.mapper"})
    class Root {

    }
}
