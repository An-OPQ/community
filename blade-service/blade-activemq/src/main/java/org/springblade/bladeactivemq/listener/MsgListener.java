package org.springblade.bladeactivemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class MsgListener {

	@JmsListener(destination = "SpringBoot_Queue")
	public void receiveMessage(Message message){
		if (message instanceof TextMessage){
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("ActiveMQ:"+textMessage.getText());
			} catch (JMSException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
