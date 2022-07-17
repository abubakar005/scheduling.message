package com.hackerrank.scheduling.message;

import com.hackerrank.scheduling.model.MessageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ScheduledMessageReceiver {
    private static final Logger LOG = LoggerFactory.getLogger(ScheduledMessageReceiver.class);

    @JmsListener(destination = "mailbox", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(MessageObject message) {

        if(message.getToAddress().equalsIgnoreCase("info@example.com")) {
            LOG.info("Received message: " + message.getMessage());
        } else if(message.getToAddress().equalsIgnoreCase("test@example.com")) {
            throw new RuntimeException("Error Message : " + message.getMessage());
        }
        // receive messages here
    }
}
