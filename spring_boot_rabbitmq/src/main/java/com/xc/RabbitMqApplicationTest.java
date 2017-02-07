package com.xc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xc.rabbitmq.Sender;

/** 
* @ClassName: RabbitMqApplicationTest 
* @Description: 单元测试类，用于调用消息生产者
* @author xuechen
* @date 2017年2月7日 下午5:20:02
*  
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RabbitMqApplication.class)
public class RabbitMqApplicationTest {
	
	@Autowired
	private Sender sender;
	
	@Test
	public void hello() throws Exception{
		sender.send();
	}

}
