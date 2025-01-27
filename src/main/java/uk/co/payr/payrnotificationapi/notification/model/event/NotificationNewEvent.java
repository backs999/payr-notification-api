package uk.co.payr.payrnotificationapi.notification.model.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationNewEvent {
    private String timestamp;
    private String message;
    private String service;
}
