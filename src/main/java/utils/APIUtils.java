package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIUtils {
    public static Response sendGetRequest(String endPoint, RequestSpecification request){
        return request.accept(ContentType.JSON).when().get(endPoint);
    }

    public static Response sendGetRequest(String endpoint,RequestSpecification request,String key, String value){
        return request.queryParam(key,value).when().get(endpoint);
    }
}
