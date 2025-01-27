package uk.co.payr.payrnotificationapi.notification.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.flogger.Flogger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import uk.co.payr.payrnotificationapi.notification.model.event.NotificationNewEvent;

@Component
@RequiredArgsConstructor
@Flogger
public class NotificationListener {

    private final ObjectMapper mapper;

    @KafkaListener(topics = "${payr.kafka.topic-notification-new}", groupId = "payr-notification-api")
    public void listensNewUser(final String incomingNotification) {
        try {
            final var notification = mapper.readValue(incomingNotification, NotificationNewEvent.class);
            log.atInfo().log("Notification received from service: " + notification.getService() + " with " + notification.getMessage() + " at " + notification.getTimestamp());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}