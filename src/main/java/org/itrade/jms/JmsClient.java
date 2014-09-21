package org.itrade.jms;

import org.itrade.commons.jms.ITradeJmsMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class JmsClient {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("jmsTemplate")
    private JmsTemplate jmsTemplate;

    public void sendMessageToInjection(String message, String type) {
        logger.debug("Send message: {}", message);
        try {
            ITradeJmsMessage iTradeJmsMessage = new ITradeJmsMessage();
            iTradeJmsMessage.setType(type);
            iTradeJmsMessage.setBody(message);
            jmsTemplate.convertAndSend(iTradeJmsMessage);
        } catch (JmsException e) {
            logger.error("Error when sending event: " + message, e);
        }
    }
}
