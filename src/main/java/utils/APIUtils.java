package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIUtils {
    public static Response sendGetRequest(RequestSpecification request, String endpoint){
        return request.when().accept(ContentType.JSON).get(endpoint);
    }
}
