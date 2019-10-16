package step_definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItem;

public class weatherSteps {

    private static ResponseOptions<Response> response;
    private String[] weatherStatesArray = new String[] {"Snow","Sleet","Hail","Thunderstorm","Heavy Rains","Light Rain","Showers","Heavy Cloud",
            "Light Cloud","Clear"};
    private List<String> weatherStatesList = Arrays.asList(weatherStatesArray);

   @Given("^I perform GET operation for london \"([^\"]*)\"$")
    public void iPerformGETOperationForLondon(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
   }

    @Then("^I should see the weather state name for today is valid$")
    public void iShouldSeeTheWeatherStateNameForTodayIsValid() {
        String responseItem = response.getBody().jsonPath().get("consolidated_weather[0].weather_state_name");
        assertThat(weatherStatesList, hasItem(responseItem));
    }

    @Then("^I should see the weather state name for tomorrow is valid$")
    public void iShouldSeeTheWeatherStateNameForTomorrowIsValid() {
        String responseItem = response.getBody().jsonPath().get("consolidated_weather[1].weather_state_name");
        assertThat(weatherStatesList, hasItem(responseItem));
    }

    @Given("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
    }

    @Then("^I should see the location is \"([^\"]*)\"$")
    public void iShouldSeeTheLocationIs(String city) throws Throwable {
       // String responseItem = response.getBody().jsonPath().get("consolidated_weather[1].weather_state_name");
        assertThat(response.getBody().jsonPath().get("title"), equalTo(city));
    }

    @Given("^I perform GET operation for \"([^\"]*)\" for today$")
    public void iPerformGETOperationForForToday(String url) throws Throwable {
        String todaysDate = RestAssuredExtension.getCurrentDate1();
        String pathUrl = url+ '/' + todaysDate;
        response = RestAssuredExtension.GetOps(pathUrl);
    }

    @Then("^I should see the date returned is today's date$")
    public void iShouldSeeTheDateReturnedIsTodaySDate() {
        String applicableDate = response.getBody().jsonPath().get("[1].applicable_date");
        String todaysDate = RestAssuredExtension.getCurrentDate2();
        assertThat(applicableDate, equalTo(todaysDate));
    }
}
