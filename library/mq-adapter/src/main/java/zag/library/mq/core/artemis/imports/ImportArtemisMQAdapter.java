package zag.library.mq.core.artemis.imports;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Import;
import org.springframework.jms.annotation.EnableJms;
import zag.library.mq.core.artemis.imports.config.ImportMQInterceptor;
import zag.library.mq.core.artemis.service.MQClientServiceImpl;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ImportArtemisMQAdapter.Root.class)
public @interface ImportArtemisMQAdapter {

    //    @Configuration
    @EnableJms
//    @PropertySource("${zag.lib.common-config-location}/message-queue-config.properties")
    @AllArgsConstructor
    @Import({MQClientServiceImpl.class, ImportMQInterceptor.class //, ActiveMQErrorHandler.class,
    })
    class Root {
        //        @Bean
//        public MessageConverter jmsJSONMessageConverter() {
//            MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//            converter.setTargetType(MessageType.TEXT);
//            converter.setTypeIdPropertyName("_type");
//            return converter;
//        }
//
//



    }
}
