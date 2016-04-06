package com.mockservice.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class JsonConverter {

	public static <T> String toJson(T t) {
		return getGson().toJson(t);
	}

	public static <T> T jsonToObject(String json, TypeToken typeToken) {
		return getGson().fromJson(json, typeToken.getType());
	}

	private static Gson getGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		return gsonBuilder.create();
	}

	public static <T> List<T> jsonFromObjectList(String json, TypeToken typeToken) {
		List<T> list = new ArrayList<T>();

		try {
			T[] o = getGson().fromJson(json, typeToken.getType());
			list = asList(o);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}

		return list;
	}
}
