package step_definitions.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pojo.response.user.User;
import step_definitions.BaseStep;
import utils.APIUtils;
import utils.ConfigManager;
import utils.DataWriter;

import java.util.List;

public class GetAllUsersStep extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(GetAllUsersStep.class);
    List<User> userList;
    @SneakyThrows
    @When("the user sends request to get list of all users")
    public void theUserSendsRequestToGetListOfAllUsers() {

        response = APIUtils.sendGetRequest(GET_ALL_USERS_ENDPOINT,request);
        LOGGER.info("the user sends request to get list of all users");

        userList = response.as(new TypeRef<List<User>>() {
        });

        DataWriter.writeData("user.json",userList.get(0));
        LOGGER.info("First user from list recorded for further inspection");
    }

    @And("the user should see list of all users")
    public void theUserShouldSeeListOfAllUsers() {
        Assertions.assertThat(userList).isNotNull().isNotEmpty();
        LOGGER.debug("the user can see list of all users");
    }
}
