package zag.library.mq.api.service;

import zag.library.common.interfaces.Events;

public interface MQClientService {
    void sendMessage(Events<?, ?> event, Object body);

    void sendMessage(Events<?, ?> event, Object body, Long delayedTime);
}
