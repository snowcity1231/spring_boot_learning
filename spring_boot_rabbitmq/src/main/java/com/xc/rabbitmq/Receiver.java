package com.xc.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/** 
* @ClassName: Receiver 
* @Description: 消息消费者, 使用RabbitListener注解定义该类对hello队列的监听
* @author xuechen
* @date 2017年2月7日 下午5:16:10
*  
*/
@Component
@RabbitListener(queues = "hello")
public class Receiver {
	
	/**
	 * RabbitHandler注解来指定对消息的处理方法
	 * @param hello
	 */
	@RabbitHandler
	public void process(String hello) {
		System.out.println("Receiver : " + hello);
	}

}
