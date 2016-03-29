package com.mockservice.controller;

import java.io.IOException;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.reflect.TypeToken;
import com.mockservice.model.Order;
import com.mockservice.util.JsonConverter;
import com.mockservice.util.JsonFileReaderUtil;

@Controller
@EnableAutoConfiguration
public class MyController {

	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Hello world!";
	}

	@RequestMapping("/josnToObject")
	@ResponseBody
	public Order jsonToObject() {
		Order order = new Order();
		try {
			String readFile = JsonFileReaderUtil.readFile("Order");
			order = JsonConverter.jsonToObject(readFile, new TypeToken<Order>() {
			}.getType());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return order;
	}

	@RequestMapping("/objectToJson")
	@ResponseBody
	public String objectToJson() {

		// 假数据
		Order order = new Order();
		order.setId(111L);
		order.setName("name111");
		order.setValue("value111");
		order.setDate(new Date());

		return JsonConverter.objectToJson(order);
	}

	public static void main(String[] args) {
		SpringApplication.run(MyController.class, args);
	}
}
