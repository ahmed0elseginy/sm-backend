package zag.library.session.core.imports;

import org.springframework.context.annotation.Import;
import zag.library.session.core.service.ThreadContextRequestContext;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = {ImportRequestContext.Root.class})
public @interface ImportRequestContext {

    @Import(value = {ThreadContextRequestContext.class})
    class Root {

    }
}
