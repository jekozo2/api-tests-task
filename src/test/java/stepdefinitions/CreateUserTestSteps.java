package stepdefinitions;

import com.github.javafaker.Faker;
import endpoints.UserEndpoint;
import enums.HttpStatuses;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import models.UserModel;

import static helpers.AssertionHelper.assertCreateUserResponseBody;
import static helpers.AssertionHelper.assertResponseStatusCode;

@Slf4j
public class CreateUserTestSteps extends BaseTestSteps {


    @Given("create user request accepts user name and user job")
    public void dummyTestStepWithoutParameters() {
        log.info("Executing Dummy Test Step without parameters.");

    }

    @When("a POST request is sent to create new user with the below user name and job:")
    public void createNewUser(String docString) {
        UserModel userModel = new UserModel();
        userModel.setName(docString.split("\n")[0].split(": ")[1].trim());
        userModel.setJob(docString.split("\n")[1].split(": ")[1].trim());

        if (userModel.getName().equals("null")) {
            userModel.setName(null);
        }

        if (userModel.getJob().equals("null")) {
            userModel.setJob(null);
        }
        log.info(String.format("Create User with name: %s and job: %s", userModel.getName(), userModel.getJob()));

        Response response = UserEndpoint.createUser(userModel);

        getContext().setResponse(response);
        getContext().setUser(userModel);
    }

    @When("a POST request is sent to create new user with Faker generated user name and job")
    public void createNewUserWithFakerParams() {
        UserModel userModel = new UserModel();
        userModel.setName(String.format("%s %s", Faker.instance().name().firstName(), Faker.instance().name().lastName()));
        userModel.setJob(Faker.instance().job().position());

        log.info(String.format("Create User with name: %s and job: %s", userModel.getName(), userModel.getJob()));

        Response response = UserEndpoint.createUser(userModel);

        getContext().setResponse(response);
        getContext().setUser(userModel);
    }

    @Then("the status code is 201")
    public void assertCreateUserStatusCode() {
        assertResponseStatusCode(getContext().getResponse(), HttpStatuses.STATUS_CREATED);
    }

    @Then("the response body is as expected")
    public void assertCreateNewUserResponseBody() {
        assertCreateUserResponseBody(getContext().getResponse(), getContext().getUser());
    }
}
