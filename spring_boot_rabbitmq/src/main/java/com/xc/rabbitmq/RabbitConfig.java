package com.xc.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/** 
* @ClassName: RabbitConfig 
* @Description: RabbitMQ配置类
* @author xuechen
* @date 2017年2月7日 下午5:18:02
*  
*/
@Configuration
public class RabbitConfig {
	
	@Bean
	public Queue helloQueue() {
		return new Queue("hello");
	}
}
