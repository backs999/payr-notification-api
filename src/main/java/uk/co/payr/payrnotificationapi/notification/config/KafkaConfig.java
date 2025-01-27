package uk.co.payr.payrnotificationapi.notification.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic notificationNew(final KafkaConfigProps kafkaConfigProps) {
        return TopicBuilder.name(kafkaConfigProps.getTopicNotificationNew())
                .partitions(10)
                .replicas(1)
                .build();
    }
}
