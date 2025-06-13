package zag.library.rest.core.imports;

import org.springframework.context.annotation.Import;
import zag.library.rest.core.config.RESTWebConfig;
import zag.library.rest.core.error.RESTGlobalExceptionHandler;
import zag.library.rest.core.filter.InitRequestContextRESTFilter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = {ImportRESTAdapter.Root.class})
public @interface ImportRESTAdapter {

    @Import(value = {InitRequestContextRESTFilter.class, RESTGlobalExceptionHandler.class, RESTWebConfig.class})
    class Root {

    }
}
