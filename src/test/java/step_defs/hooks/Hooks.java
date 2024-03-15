package step_defs.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.Before;
import step_defs.BaseStep;

public class Hooks extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);

    @Before
    public void setUpEnvironment(Scenario scenario) {
        LOGGER.info(":::::::::TEST INFORMATION::::::::::::::");
        LOGGER.info("TEST SCENARIO " + scenario.getName() + " is started!");
    }


    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            if(RESPONSE != null){
                LOGGER.error("Scenario failed! Logging response for failed scenario : " + scenario.getName());
                LOGGER.error(RESPONSE.getBody().prettyPrint());
            }else {
                LOGGER.error("Scenario is failed! But there is no response to display!");
            }
        }

        LOGGER.info("Finished scenario : " + scenario.getName());
        LOGGER.info(":::::::::::::::::::::::::::::::::::::::::");
    }
}
