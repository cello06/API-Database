package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.FileOutputStream;

public class DataWriter {
    @SneakyThrows
    public static void writeData(String path, Object object){
        ObjectMapper objectMapper = new ObjectMapper();

        FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir") + "/src/test/resources/test_data/" + path);

        objectMapper.writeValue(outputStream,object);
    }
}
