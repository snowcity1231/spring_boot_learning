package com.xc.rabbitmq;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** 
* @ClassName: Sender 
* @Description: 消息生产者
* @author xuechen
* @date 2017年2月7日 下午5:12:46
*  
*/
@Component
public class Sender {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send() {
		String context = "hello" + new Date();
		System.out.println("Sender: " + context);
		try {
			this.amqpTemplate.convertAndSend("hello", context);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
