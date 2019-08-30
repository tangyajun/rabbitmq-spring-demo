package com.example.rabbit.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tangyajun
 * @Description TO DO
 * @create 2019-08-30-13:43
 **/
@Configuration
public class TopicExchangeConfiguration {

	/**
	 * 动态声明队列
	 * @return
	 */
	@Bean
	public Queue topicQueue1() {
		return new Queue("q.topic1");
	}

	/**
	 * 动态声明队列
	 * @return
	 */
	@Bean
	public Queue topicQueue2() {
		return new Queue("q.topic2");
	}

	/**
	 * 动态声明交换器
	 * @return
	 */
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("x.topic");
	}

	@Bean
	public Binding bindingTopicExchange2Queue1() {
		return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("*.*.test");
	}

	@Bean
	public Binding bindingTopicExchange2Queue2() {
		return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("*.topic.*");
	}

	@Bean
	public Binding bindingTopicExchange2Queue3() {
		return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("com.#");
	}
}
