package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.FileInputStream;


public class DataReader {
    @SneakyThrows
    public static <T> T readData(String path, Class<T> specificClass) {
        ObjectMapper objectMapper = new ObjectMapper();

        FileInputStream fileInputStream = new FileInputStream(
                System.getProperty("user.dir") + "src/test/resources/test_data" + path
        );
        return objectMapper.readValue(fileInputStream, specificClass);

    }
}
