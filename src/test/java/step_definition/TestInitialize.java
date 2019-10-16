package step_definition;

import cucumber.api.java.Before;
import utilities.RestAssuredExtension;

public class TestInitialize {

    @Before
    public void TestSetup() {
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
    }
}
