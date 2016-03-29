package com.mockservice.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonFileReaderUtil {

	private static String rootPath = "";

	static {
		rootPath = Class.class.getClass().getResource("/").getPath().concat("com/mockservice/data/").substring(1);
	}

	public static void main(String[] args) {
		try {
			String file = JsonFileReaderUtil.class.getClass().getResource("/").getFile();

			System.out.println(file);

			System.out.println(readFile("test"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readFile(String enitiyName) throws IOException {
		File file = new File(rootPath.concat(enitiyName).concat(".json"));
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		StringBuffer sb = new StringBuffer();
		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line);
		}
		bufferedReader.close();
		fileReader.close();
		return sb.toString();
	}
}
