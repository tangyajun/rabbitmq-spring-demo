package com.example.rabbit.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author tangyajun
 * @Description TO DO
 * @create 2019-08-30-11:50
 **/
@Configuration
public class RabbitDirectExchangeConfiguration {

	/**
	 * 动态声明队列
	 * @return
	 */
	@Bean(name = "q.direct1")
	public Queue queue1() {
		return new Queue("q.direct1");
	}

	/**
	 * 动态声明队列
	 * @return
	 */
	@Bean(name = "q.direct2")
	public Queue queue2() {
		return new Queue("q.direct2");
	}

	/**
	 * 动态声明交换器
	 * @return
	 */
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("x.direct");
	}

	/**
	 * 使用路由键r.direct.routingKey1将交换器绑定到队列 q.direct1
	 * @return
	 */
	@Bean
	public Binding bindingQueue1Exchange() {
		return BindingBuilder.bind(queue1()).to(directExchange()).with("r.direct.routingKey1");
	}

	/**
	 * 使用路由键r.direct.routingKey2 将交换器绑定到队列 q.direct1
	 * @return
	 */
	@Bean
	public Binding bindingExchange2Queue2() {
		return BindingBuilder.bind(queue1()).to(directExchange()).with("r.direct.routingKey2");
	}

	/**
	 * 使用路由键 r.direct.routingKey1将交换器绑定到队列 q.direct2
	 * @return
	 */
	@Bean
	public Binding bindingExchange2Queue() {
		return BindingBuilder.bind(queue2()).to(directExchange()).with("r.direct.routingKey1");
	}
}
