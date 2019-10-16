Feature:
  git@github.com:shaziat/WeatherApiTest.git

  Scenario: Verify weather state name for today
    Given I perform GET operation for london "/location/44418"
    Then I should see the weather state name for today is valid

  Scenario: Verify weather state name for tomorrow
    Given I perform GET operation for london "/location/44418"
    Then I should see the weather state name for tomorrow is valid

  Scenario: Verify woeid for London
    Given I perform GET operation for "/location/44418"
    Then I should see the location is "London"

  Scenario: Verify woeid for San Francisco
    Given I perform GET operation for "/location/2487956"
    Then I should see the location is "San Francisco"

  Scenario: Verify right Date is returned
    Given I perform GET operation for "/location/44418" for today
    Then I should see the date returned is today's date