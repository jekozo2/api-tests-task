Feature: Create Repository Positive Tests


  @smoke @regression
  Scenario Outline: User created successfully with provided name and job
    Given create user request accepts user name and user job
    When a POST request is sent to create new user with the below user name and job:
    """
    name: <name>
    job: <job>
    """
    Then the status code is 201
    And the response body is as expected
    Examples:
      | name        | job                  |
      | Test User   | Automation Tester    |
      | Dev User    | Senior Developer     |
      | null        | Automation Tester    |
      | Dev User    | null                 |

  @smoke @regression
  Scenario: User created successfully with generated name and job from Faker
    Given create user request accepts user name and user job
    When a POST request is sent to create new user with Faker generated user name and job
    Then the status code is 201
    And the response body is as expected

