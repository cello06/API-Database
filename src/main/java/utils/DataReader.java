package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.poi.ss.formula.functions.T;

import java.io.FileInputStream;
import java.io.IOException;

public class DataReader {
    @SneakyThrows
    public static  <T> T readData(String path, Class<T> objectType) {
        ObjectMapper objectMapper = new ObjectMapper();

        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/test_data/" + path);

        return objectMapper.readValue(file, objectType);

    }
}
