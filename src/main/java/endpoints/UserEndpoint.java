package endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import models.UserModel;

import static enums.Constants.CREATE_USER_ENDPOINT;
import static utils.JsonUtils.toJson;
import static utils.RestAssuredUtils.getRequestSpecification;

@Data
@Slf4j
@Builder
public class UserEndpoint {

    public static Response createUser(UserModel user) {
        log.info("Execute Create User request.");

        RequestSpecification requestSpecification = getRequestSpecification();

        return requestSpecification
                .body(toJson(user))
                .when()
                .post(CREATE_USER_ENDPOINT.getValue())
                .then()
                .log().ifError()
                .extract()
                .response();
    }
}
