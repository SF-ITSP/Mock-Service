package com.mockservice.util;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mockservice.model.Order;

public class JsonConverter {

	private static Gson gson = new Gson();

	public static <T> String objectToJson(T obj) {
		return gson.toJson(obj);
	}

	public static <T> T jsonToObject(String jsonStr, Type typeOfT) {
		return gson.fromJson(jsonStr, typeOfT);
	}

	public static void main(String[] args) {
		Order order = new Order();
		order.setId(1L);
		order.setName("name1");
		order.setValue("value1");
		order.setDate(new Date());

		List<Order> list = new ArrayList<Order>();
		list.add(order);
		list.add(order);
		String jsonStr = objectToJson(list);
		System.out.println(jsonStr);

		try {
			String readFile = JsonFileReaderUtil.readFile("Order");
			Order fromJson = jsonToObject(readFile, new TypeToken<Order>() {
			}.getType());
			System.out.println(fromJson.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
