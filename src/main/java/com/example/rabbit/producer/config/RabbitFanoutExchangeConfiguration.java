package com.example.rabbit.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author tang
 * @Description TO DO
 * @create 2019-08-29-19:47
 **/
@Configuration
public class RabbitFanoutExchangeConfiguration {

	/**
	 * 声明队列
	 * @return
	 */
	@Bean(name = "q.test1")
	public Queue queue() {
		return new Queue("q.test1");
	}

	@Bean("q.test2")
	public Queue queue2() {
		return new Queue("q.test2");
	}

	/**
	 * 声明交换器
	 * @return
	 */
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("x.test1");
	}

	/**
	 * 绑定队列到交换器
	 * @return
	 */
	@Bean
	public Binding bindingQueue2Exchange() {
		return BindingBuilder.bind(queue()).to(fanoutExchange());
	}

	@Bean
	public Binding bindingQueue2FanoutExchange() {
		return BindingBuilder.bind(queue2()).to(fanoutExchange());
	}
}
