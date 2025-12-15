package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JsonSchemaFilePaths {

    CREATE_USER_SCHEMA_FILE_PATH("jsonschems/create_user_schema.json");

    private final String schemaPath;
}
