package step_definitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks extends BaseStep{

    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);
    @Before
    public void setUp(Scenario scenario){
        LOGGER.info("::::::::::::::::::::::::::TEST STARTED:::::::::::::::::::::::::::::::::");
        LOGGER.info("SCENARIO NAME ->>>>>> " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            if(response != null) {
                LOGGER.error("Scenario failed! Logging response body for failed scenario: " + scenario.getName());
                LOGGER.error(response.getBody().prettyPrint());
            }else {
                LOGGER.error("Scenario failed! But no response body");
            }
        }
        LOGGER.info("FINISHED SCENARIO ->>>>> " + scenario.getName());
        LOGGER.info("::::::::::::::::::::::::::TEST FINISHED:::::::::::::::::::::::::::::::::");
    }
}
