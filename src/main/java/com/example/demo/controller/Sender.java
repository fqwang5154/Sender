package com.example.demo.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sender {

	@Autowired
	public Queue queue;

	@Autowired
	public RabbitTemplate template;

	@GetMapping("sendMsg")
	@ResponseBody
	public void sendMsg() {
		template.convertAndSend(queue.getName(), "hello world");
	}
}
