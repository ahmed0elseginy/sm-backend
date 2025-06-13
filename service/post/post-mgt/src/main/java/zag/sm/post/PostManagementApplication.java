package zag.sm.post;

import org.apache.activemq.artemis.core.config.Configuration;
import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.ActiveMQServer;
import org.apache.activemq.artemis.core.server.impl.ActiveMQServerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import zag.library.rest.core.imports.ImportRESTAdapter;
import zag.library.security.core.imports.ImportSecurityAdapter;
import zag.library.session.core.imports.ImportRequestContext;

@ImportRESTAdapter
@ImportRequestContext
@ImportSecurityAdapter

@EnableJms
@SpringBootApplication
public class PostManagementApplication {
    
    @Bean
    public ActiveMQServer activeMQServer() throws Exception {
        Configuration config = new ConfigurationImpl()
            .setPersistenceEnabled(false)
            .setSecurityEnabled(false)
            .addAcceptorConfiguration("invm", "vm://0");
            
        ActiveMQServer server = new ActiveMQServerImpl(config);
        server.start();
        return server;
    }

    public static void main(String[] args) {
        SpringApplication.run(PostManagementApplication.class, args);
    }
}
