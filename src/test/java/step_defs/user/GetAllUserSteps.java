package step_defs.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import lombok.SneakyThrows;
import model.UserDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pojo.response.User;
import service.UserService;
import step_defs.BaseStep;
import utils.APIUtils;
import utils.DBUtils;
import utils.DataWriter;

import java.util.List;

public class GetAllUserSteps extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(GetAllUserSteps.class);



    private List<User> userListFromAPI;
    private List<UserDatabase> userListFromDatabase;
    @SneakyThrows
    @When("the user send request to jira api to get all users")
    public void theUserSendRequestToJiraApiToGetAllUsers() {
        RESPONSE = APIUtils.sendGetRequest(REQUEST, GET_ALL_USERS_ENDPOINT);
       userListFromAPI = RESPONSE.as(new TypeRef<List<User>>() {
       });

        DataWriter.writeData("user.json", userListFromAPI.get(0));

       for (User user: userListFromAPI){
           DBUtils.addUserToDatabase(user);
       }


    }

    @And("the user list should not be empty or null")
    public void theUserListShouldNotBeEmptyOrNull() {
        Assertions.assertThat(userListFromAPI).isNotNull().isNotEmpty();
    }

    @And("the user list must be the same as the list in database")
    public void theUserListMustBeTheSameAsTheListInDatabase() {
        userListFromDatabase = UserService.getListOfAllUsers();

    }
}
