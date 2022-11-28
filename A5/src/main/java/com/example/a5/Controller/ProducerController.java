package com.example.a5.Controller;

import com.example.a5.CachedEntity;
import com.example.a5.ProducerApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private static final Logger logger =
            LoggerFactory.getLogger(ProducerController.class);

    private final KafkaTemplate<String, Object> template;
    private final ProducerApplicationProperties producerApplicationProperties;

    @GetMapping("/produce")
    public String produce(){
        String topicName = producerApplicationProperties.getTopic();
        int messages = producerApplicationProperties.getMessages();
        String message = "Hello World";
        String name = "John Doe";

        IntStream.range(0, messages)
                .forEach(index -> this.template.send(topicName, String.valueOf(index),
                        new CachedEntity(index, name, message))
                );

        logger.info("All messages sent");
        return "Messages added!";
    }
}