Feature: Example dot com example

  @test
  Scenario: Open home page and click More Information
    Given I am at page with URL "https://example.com/"
    And I maximize page
    And I refresh page
    Then I am able to see title "Example Domain"
    When I click link with text containing "More information..."
    Then I am able to see title "Further Reading"
    When I go back
    Then I am able to see title "Example Domain"
    When I go forward
    Then I am able to see title "Further Reading"
