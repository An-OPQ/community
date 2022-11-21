package org.springblade.bladeactivemq.controller;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/activemq")
public class ActiveController {

	@Resource
	private JmsMessagingTemplate jmsMessagingTemplate;

	@GetMapping("/contextLoad1")
	public Object contextLoad1(){
		jmsMessagingTemplate.convertAndSend("SpringBoot_Queue","SpringBootTest");
		return null;
	}

}
