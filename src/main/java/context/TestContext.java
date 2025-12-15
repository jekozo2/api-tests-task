package context;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import models.UserModel;

@Getter
@Setter
public class TestContext {


    private Response response;
    private UserModel user;
    private Scenario scenario;

}
