# API Testing with BBC Weather - Test Assignment 

## Introduction

Java project for API Testing, using cucumber-maven framework. This framework contains the tests to verify that the open MetaWeather API is reliable.

## Installation

Maven needs to be installed to run this project. If you have homebrew installed you can use the below command to install maven:
```
Brew install maven
```
## Run the tests

### Directory structure

```bash
.
├── src
│   └── main
|    |   └── java
|    |         └── utilities
|    |               └── RestAssuredExtension
|    └── test
|         └── java
|              └── features
|              |     └── weather.feature
|              └── step_definition
|                    └── TestInitialize
|                    └── weatherSteps
├── pom.xml
```

## Feature file and Step Definitions:

- Scenarios to verify that 'weather_state_name is as expected' are written and automated
- Scenarios to test the location method /api/location/(woeid)/ are written and automated (for locations London and San Francisco)
- Scenarios to test that the correct date is returned are written and automated
