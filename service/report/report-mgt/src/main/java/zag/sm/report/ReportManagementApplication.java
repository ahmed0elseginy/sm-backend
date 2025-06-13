package zag.sm.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import zag.library.rest.core.imports.ImportRESTAdapter;
import zag.library.security.core.imports.ImportSecurityAdapter;
import zag.library.session.core.imports.ImportRequestContext;

@ImportRESTAdapter
@ImportRequestContext
@ImportSecurityAdapter

@EnableJms
@SpringBootApplication
public class ReportManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReportManagementApplication.class, args);
	}
}

