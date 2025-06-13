package zag.library.mq.core.artemis.imports.config;

import jakarta.annotation.PostConstruct;
import jakarta.jms.ConnectionFactory;
import lombok.AllArgsConstructor;
import org.apache.activemq.artemis.api.core.client.ServerLocator;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jms.connection.CachingConnectionFactory;
import zag.library.mq.core.artemis.interceptor.ActiveMQListenerInterceptor;

@Configuration
@Import({ActiveMQListenerInterceptor.class})
@AllArgsConstructor
public class ImportMQInterceptor {
    private final ConnectionFactory connectionFactory;
    private final ActiveMQListenerInterceptor listenerInterceptor;

    @PostConstruct
    public void postConstruct() {
        ActiveMQConnectionFactory _conFactory = (ActiveMQConnectionFactory) ((CachingConnectionFactory) connectionFactory).getTargetConnectionFactory();
        ServerLocator serverLocator = _conFactory.getServerLocator();
        serverLocator.addIncomingInterceptor(listenerInterceptor);
    }
}
