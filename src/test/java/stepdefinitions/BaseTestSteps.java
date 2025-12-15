package stepdefinitions;

import context.TestContext;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseTestSteps {

    private TestContext context = new TestContext();

}
