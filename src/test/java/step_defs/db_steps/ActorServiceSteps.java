package step_defs.db_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Actor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import service.ActorService;
import utils.DBUtils;

import java.sql.SQLException;
import java.util.List;

public class ActorServiceSteps {

    private static final Logger LOGGER = LogManager.getLogger(ActorServiceSteps.class);

    private List<Actor> actorList;
    @Given("the user connect to database")
    public void theUserConnectToDatabase() {
        try {
           DBUtils.getConnection();
        }catch (RuntimeException e){
            LOGGER.error(e.getMessage());
        }
    }

    @When("the user sent query to database to get actor list")
    public void theUserSentQueryToDatabaseToGetActorList() {
        actorList = ActorService.getListOfAllActors();
        LOGGER.info("the user sent query to database to get actor list");
    }

    @Then("the size of actor list should be {int}")
    public void theSizeOfActorListShouldBe(int size) {
        Assertions.assertThat(actorList.size()).isEqualTo(size);
        LOGGER.debug("the size of actor list should be " + size);
    }
}
