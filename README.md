# Create User Automation Task

REST API TAF is a Java based framework for completing the EGT Digital Task for Create User Automation Tests

## Setup
The project is build on Java 22.\
Apache [Maven] (https://maven.apache.org) should be installed.\
The most important libraries being used are:\
- [TestNG] (https://testng.org/doc/)
- [Cucumber] (https://cucumber.io/docs/cucumber)and
- [Rest Assured] (https://rest-assured.io)

## Running Tests

In order to change the Environment (dev, test):
```bash
 -Denv=test
```
In order to change the parallel execution to sequential change @DataProvider(parallel=true) to false in TestRunner class \

Run specific tests
```bash
-Dcucumber.filter.tags="@regression" 
```

## Reporting

The TAF is using Extent Report that generates html reports in `target/reports` folder or in `cucumber-reports` folder
