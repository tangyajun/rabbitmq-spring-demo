package com.example.rabbit.producer.web.mq;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * @author tang
 * @Description TO DO
 * @create 2019-08-29-19:56
 **/
@Component
public class RabbitProducer {

	@Autowired
	AmqpTemplate amqpTemplate;

	public void sendMessage(Object object) {
		try {
			Message message= MessageBuilder.withBody(JSON.toJSONString(object).getBytes("UTF-8"))
					.setContentType(MessageProperties.CONTENT_TYPE_JSON)
					.setContentEncoding("UTF-8")
					.setMessageId(UUID.randomUUID().toString()).build();
			// 指定exchange 为x.test1
			amqpTemplate.send("x.test1","",message);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage2DirectExchange(Object object) {
		try {
			Message message= MessageBuilder.withBody(JSON.toJSONString(object).getBytes("UTF-8"))
					.setContentType(MessageProperties.CONTENT_TYPE_JSON)
					.setContentEncoding("UTF-8")
					.setMessageId(UUID.randomUUID().toString()).build();
			// 指定exchange 为x.direct, 路由键为 r.direct.routingKey1
			amqpTemplate.send("x.direct","r.direct.routingKey1",message);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage2DirectDirectExchange(Object object) {
		try {
			Message message= MessageBuilder.withBody(JSON.toJSONString(object).getBytes("UTF-8"))
					.setContentType(MessageProperties.CONTENT_TYPE_JSON)
					.setContentEncoding("UTF-8")
					.setMessageId(UUID.randomUUID().toString()).build();
			// 指定exchange 为x.direct, 路由键为 r.direct.routingKey2
			amqpTemplate.send("x.direct","r.direct.routingKey2",message);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage2TopicMessage(Object object) {
		try {
			Message message= MessageBuilder.withBody(JSON.toJSONString(object).getBytes("UTF-8"))
					.setContentType(MessageProperties.CONTENT_TYPE_JSON)
					.setContentEncoding("UTF-8")
					.setMessageId(UUID.randomUUID().toString()).build();
			// 指定exchange 为x.direct, 路由键为 r.direct.routingKey2
			amqpTemplate.send("x.topic","com.test",message);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage2TopicMessage2(Object object) {
		try {
			Message message= MessageBuilder.withBody(JSON.toJSONString(object).getBytes("UTF-8"))
					.setContentType(MessageProperties.CONTENT_TYPE_JSON)
					.setContentEncoding("UTF-8")
					.setMessageId(UUID.randomUUID().toString()).build();
			// 指定exchange 为x.direct, 路由键为 r.direct.routingKey2
			amqpTemplate.send("x.topic","client.topic.test",message);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
