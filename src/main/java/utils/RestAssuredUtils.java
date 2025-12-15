package utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class RestAssuredUtils {


    public static RequestSpecification getRequestSpecification() {

        String baseURI = Helper.getInstance().getProperty("baseUri");
        String apiKey = Helper.getInstance().getProperty("apiKey");

        return RestAssured
                .given()
                .baseUri(baseURI)
                .header("x-api-key", apiKey)
                .contentType("application/json");

    }
}
