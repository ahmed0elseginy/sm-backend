package zag.sm.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zag.library.rest.core.imports.ImportRESTAdapter;
import zag.library.security.core.imports.ImportSecurityAdapter;
import zag.library.session.core.imports.ImportRequestContext;

@ImportRESTAdapter
@ImportRequestContext
@ImportSecurityAdapter

@SpringBootApplication
public class UserManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}
}
