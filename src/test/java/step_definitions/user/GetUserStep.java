package step_definitions.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import pojo.response.user.User;
import step_definitions.BaseStep;
import utils.APIUtils;
import utils.DataReader;

public class GetUserStep extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(GetUserStep.class);

    User actualUser;
    User expectedUser = DataReader.readData("user.json", User.class);

    @SneakyThrows
    @When("the user sends request to get a specific jira user")
    public void theUserSendsRequestToGetASpecificJiraUser() {
        response = APIUtils.sendGetRequest(GET_USER_ENDPOINT,request,"accountId", expectedUser.getAccountId());
    }
@SneakyThrows
    @And("the user should see the jira user that has been requested")
    public void theUserShouldSeeTheJiraUserThatHasBeenRequested() {
        ObjectMapper mapper = new ObjectMapper();

        User user = mapper.readValue(response.asString(), new TypeReference<User>() {
        });
        Assertions.assertThat(user).isNotNull();
    }

    @And("the information of user must be as expected")
    public void theInformationOfUserMustBeAsExpected() {
        actualUser = response.as(User.class);
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualUser.getDisplayName()).isEqualTo(expectedUser.getDisplayName());
        softAssertions.assertThat(actualUser.getAvatarUrls().getJsonMember16x16())
                .isEqualTo(expectedUser.getAvatarUrls().getJsonMember16x16());
        softAssertions.assertThat(actualUser.getAvatarUrls().getJsonMember24x24())
                .isEqualTo(expectedUser.getAvatarUrls().getJsonMember24x24());
        softAssertions.assertThat(actualUser.getAvatarUrls().getJsonMember32x32())
                .isEqualTo(expectedUser.getAvatarUrls().getJsonMember32x32());
        softAssertions.assertThat(actualUser.getAvatarUrls().getJsonMember48x48())
                .isEqualTo(expectedUser.getAvatarUrls().getJsonMember48x48());
        softAssertions.assertThat(actualUser.getAccountType()).isEqualTo(expectedUser.getAccountType());

        softAssertions.assertAll();

    }
}
