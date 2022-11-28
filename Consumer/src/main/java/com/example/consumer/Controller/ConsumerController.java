package com.example.consumer.Controller;

import com.example.consumer.CachedEntity;
import com.example.consumer.mail.Mail;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @KafkaListener(
            topics = "custom-topic1",
            clientIdPrefix = "json",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(ConsumerRecord<String, CachedEntity> record, @Payload CachedEntity payload) {
        Mail mail = new Mail();
        String name = payload.getName();
        String message = payload.getMsg();

        try {
            mail.generateMail(name, message);
        } catch (Exception ex) {
            logger.error(String.valueOf(ex));
        }

        logger.info("Received Payload: {} | Record: {}", payload, record);
    }
}
