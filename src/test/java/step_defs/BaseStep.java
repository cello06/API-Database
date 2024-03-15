package step_defs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigManager;

public class BaseStep {
    protected static Response RESPONSE;

    protected static RequestSpecification REQUEST;

    protected final String GET_ALL_USERS_ENDPOINT;

    public BaseStep(){
        RestAssured.baseURI = ConfigManager.getProperty("baseURI");
        GET_ALL_USERS_ENDPOINT = ConfigManager.getProperty("get.user.endpoint");
    }
}
