package step_definitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigManager;

public abstract class BaseStep {

    protected static Response response;

    protected static RequestSpecification request;

    protected final String GET_ALL_USERS_ENDPOINT;

    protected final String GET_USER_ENDPOINT;


    public BaseStep(){
        RestAssured.baseURI  = ConfigManager.getProperty("baseURL");

        GET_ALL_USERS_ENDPOINT = ConfigManager.getProperty("get.all.users");

        GET_USER_ENDPOINT = ConfigManager.getProperty("get.user");
    }
}
