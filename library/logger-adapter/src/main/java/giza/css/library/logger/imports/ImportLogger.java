package giza.css.library.logger.imports;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ImportLogger.Root.class)
public @interface ImportLogger {

    @Configuration
    class Root {

    }
}
