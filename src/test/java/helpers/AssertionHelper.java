package helpers;

import enums.HttpStatuses;
import enums.JsonSchemaFilePaths;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import models.UserModel;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;
import static org.hamcrest.Matchers.*;

@Slf4j
public class AssertionHelper {

    public static void assertResponseStatusCode(Response response, HttpStatuses expectedStatusCode) {
        log.info("Assert Response Status Code.");

        response
                .then()
                .assertThat()
                .statusCode(expectedStatusCode.getStatusCode());
    }

    public static void assertCreateUserResponseBody(Response response, UserModel user) {
        log.info(String.format("Assert Create User Response for user: %s - %s.", user.getName(), user.getJob()));

        response
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(
                        JsonSchemaFilePaths.CREATE_USER_SCHEMA_FILE_PATH.getSchemaPath())
                        .using(settings()
                                .with()
                                .checkedValidation(true)))
                .body("name", equalTo(user.getName()))
                .body("job", equalTo(user.getJob()))
                .body("id", notNullValue())
                .body("createdAt", notNullValue())
                .body("createdAt", matchesPattern("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}Z$"));
    }
}
