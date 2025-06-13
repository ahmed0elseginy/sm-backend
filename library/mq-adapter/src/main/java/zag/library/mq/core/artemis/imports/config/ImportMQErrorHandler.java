package zag.library.mq.core.artemis.imports.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Import({ActiveMQErrorHandler.class})
@AllArgsConstructor
public class ImportMQErrorHandler {

//    @Bean
//    public DefaultJmsListenerContainerFactory containerFactory(ErrorHandler errorHandler,
//                                                               ConnectionFactory connectionFactory,
//                                                               MessageConverter messageConverter) {
//        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
//        containerFactory.setConnectionFactory(connectionFactory);
//        containerFactory.setErrorHandler(errorHandler::handleError);
//        containerFactory.setMessageConverter(messageConverter);
//        return containerFactory;
//    }
}
