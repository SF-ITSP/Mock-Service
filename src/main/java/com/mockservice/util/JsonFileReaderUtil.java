package com.mockservice.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonFileReaderUtil {
    private static final String rootPath = "data/";

    public static String readFile(String fileName) throws IOException {
        File file = new File(rootPath.concat(fileName).concat(".json"));
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        bufferedReader.close();
        fileReader.close();

        return stringBuilder.toString();
    }
}
