package zag.sm.point.listener;

import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import zag.sm.point.model.vto.UserEventData;
import zag.sm.point.service.mq.UserMgtListenerService;

@Component
@AllArgsConstructor
public class UserMgtListener {
/*
    private final UserMgtListenerService userListenerService;

    @JmsListener(destination = "sm.user")
    public void onUserEvent(@Header("EVENT_ID") Integer eventId, @Payload UserEventData user) {
        Long userId = user.getUserId();
        if (eventId.equals(UserEvents.REGISTER_USER.id())) {
            userListenerService.registrationPoints(userId, eventId);
        }

        if (eventId.equals(UserEvents.ASSIGN_ADMIN_ROLE.id())) {
            userListenerService.registrationPoints(userId, eventId);
        }

        if (eventId.equals(UserEvents.REMOVE_ADMIN_ROLE.id())) {
            userListenerService.registrationPoints(userId, eventId);
        }

    }
*/
}
