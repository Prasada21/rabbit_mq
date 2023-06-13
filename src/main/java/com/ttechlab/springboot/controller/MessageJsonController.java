package com.ttechlab.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttechlab.springboot.dto.User;
import com.ttechlab.springboot.publisher.RabbitMQJsonProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

	@Autowired
	private RabbitMQJsonProducer jsonProducer;

	@PostMapping("/publish")
	public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
		jsonProducer.sendJsonMessage(user);
		return ResponseEntity.ok("Json Message sent to RabbitMQ........");

	}

}
