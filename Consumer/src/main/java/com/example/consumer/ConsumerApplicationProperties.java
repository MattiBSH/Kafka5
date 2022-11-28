package com.example.consumer;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("kafka")
@EnableConfigurationProperties
public class ConsumerApplicationProperties {
    private String topic;
    private int messages;
}