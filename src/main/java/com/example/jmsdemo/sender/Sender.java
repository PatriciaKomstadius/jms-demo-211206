package com.example.jmsdemo.sender;

import com.example.jmsdemo.config.JmsConfig;
import com.example.jmsdemo.model.MessageObject;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class Sender {

    JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {

        System.out.println("Sending message...");
        MessageObject messageObject = new MessageObject(UUID.randomUUID(), "Hello from JU19_QUEUE!", LocalDateTime.now());
        jmsTemplate.convertAndSend(JmsConfig.JU20_QUEUE, messageObject);
        System.out.println("Message sent!");

    }

}
