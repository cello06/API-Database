package step_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

public class CommonSteps extends BaseStep{
    private static final Logger LOGGER = LogManager.getLogger(CommonSteps.class);
    @Given("the user is on the base uri")
    public void theUserIsOnTheBaseUri() {
        REQUEST = RestAssured.given();
        LOGGER.info("the user is on the base uri");
    }

    @And("the authentication is completed to reach jira api")
    public void theAuthenticationIsCompletedToReachJiraApi() {
        String username = System.getenv("jiraUsername");
        String password = System.getenv("jiraToken");

         REQUEST = REQUEST.auth().preemptive().basic(username,password);
         LOGGER.info("the authentication is completed to reach jira api");
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = RESPONSE.getStatusCode();

        Assertions.assertThat(actualStatusCode)
                .as("Status code is not as expected!")
                .isEqualTo(expectedStatusCode);

        LOGGER.debug("the status code is true");
    }
}
