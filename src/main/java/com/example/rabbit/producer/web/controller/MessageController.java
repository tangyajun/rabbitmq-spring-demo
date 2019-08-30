package com.example.rabbit.producer.web.controller;

import com.example.rabbit.producer.web.mq.RabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tang
 * @Description TO DO
 * @create 2019-08-29-20:18
 **/
@RestController
@RequestMapping(value = "/messages")
public class MessageController {

	@Autowired
	RabbitProducer rabbitProducer;

	@PostMapping(value = "/fanout")
	public Map<String,Object> sendMessage() {
		Map<String,Object> map=new HashMap<>();
		map.put("username","test1");
		map.put("password","123456");
		map.put("name","我是fanout 交换器测试人员");
		rabbitProducer.sendMessage(map);
		Map<String,Object> resultMap=new HashMap<>();
		resultMap.put("code","200");
		resultMap.put("message","success");
		return resultMap;
	}

	@PostMapping(value = "/direct")
	public Map<String,Object> sendMessage2DirectExchange() {
		Map<String,Object> map=new HashMap<>();
		map.put("username","test2");
		map.put("password","123456");
		map.put("name","我是direct 交换器测试人员");
		rabbitProducer.sendMessage2DirectExchange(map);
		Map<String,Object> resultMap=new HashMap<>();
		resultMap.put("code","200");
		resultMap.put("message","success");
		return resultMap;
	}

	@PostMapping(value = "/topic")
	public Map<String,Object> sendMessage2TopicExchange() {
		Map<String,Object> map=new HashMap<>();
		map.put("username","test3");
		map.put("password","123456");
		map.put("name","我是topic 交换器测试人员");
		rabbitProducer.sendMessage2TopicMessage(map);
		Map<String,Object> resultMap=new HashMap<>();
		resultMap.put("code","200");
		resultMap.put("message","success");
		return resultMap;
	}

	@PostMapping(value = "/topic1")
	public Map<String,Object> sendMessage2TopicExchange1() {
		Map<String,Object> map=new HashMap<>();
		map.put("username","test3");
		map.put("password","123456");
		map.put("name","我是topic 交换器测试人员");
		rabbitProducer.sendMessage2TopicMessage2(map);
		Map<String,Object> resultMap=new HashMap<>();
		resultMap.put("code","200");
		resultMap.put("message","success");
		return resultMap;
	}
}
