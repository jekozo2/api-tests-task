package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Constants {

    DEV_APPLICATION_PROPERTIES_FILE_PATH("src/main/resources/dev.properties"),
    TEST_APPLICATION_PROPERTIES_FILE_PATH("src/main/resources/test.properties"),
    CREATE_USER_ENDPOINT("/api/user");

    private final String value;
}
