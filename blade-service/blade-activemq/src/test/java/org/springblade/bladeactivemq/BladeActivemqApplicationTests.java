package org.springblade.bladeactivemq;

import org.junit.jupiter.api.Test;
import org.springblade.core.test.BladeBootTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.annotation.Resource;

@SpringBootTest(classes = BladeActivemqApplication.class)
@BladeBootTest(appName = "blade-activemq")
class BladeActivemqApplicationTests {

	@Resource
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Test
	void contextLoads() {
		jmsMessagingTemplate.convertAndSend("SpringBoot_Queue","SpringBootMessage");
	}

}
