package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

public class CommonStep extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(CommonStep.class);

    @Given("the user is in correct URI")
    public void theUserIsInCorrectURI() {
        request = RestAssured.given();
        LOGGER.info("the user is in correct URI");
    }

    @And("the authentication has been made for accessing api")
    public void theAuthenticationHasBeenMadeForAccessingApi() {
        String username = System.getenv("jiraUsername");
        String accessToken = System.getenv("jiraToken");

        request = request.auth().preemptive().basic(username, accessToken);
        LOGGER.info("the authentication has been made for accessing api");
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();

        Assertions.assertThat(actualStatusCode).as("The status code is not as expected!")
                .isEqualTo(expectedStatusCode);
        LOGGER.debug("the status code is as expected");
    }
}
