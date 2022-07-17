package com.hackerrank.scheduling.message;

import com.hackerrank.scheduling.model.MessageObject;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledMessageSender {

    private final JmsTemplate jmsTemplate;

    public ScheduledMessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Scheduled(fixedRate = 5000)
    public void sendingInfoMessage() {
        // send message `info` toAddress `info@example.com` at each 5 sec
        jmsTemplate.convertAndSend("mailbox", new MessageObject("info@example.com","info"));
    }

    @Scheduled(fixedRate = 8000)
    public void sendingTestMessage() {
        // send message `test` toAddress `test@example.com` at each 8 sec
        jmsTemplate.convertAndSend("mailbox", new MessageObject("test@example.com","test"));
    }
}
