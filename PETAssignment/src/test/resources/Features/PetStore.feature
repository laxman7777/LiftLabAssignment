Feature: Pet Store API Testing

Scenario Outline: Get pets with status available
    Given I set the base URI
    When I get pets with status "<status>"
    And I "get" request with resource "<resource>"
    Then I should receive status code <status_code>
    And the response should match the schema "<schema>"

    Examples:
      | status   | resource             | status_code | schema     |
      | available| /pet/findByStatus   | 200         | schema.json|

Scenario Outline: Update pet with ID <petId> and name <name> and status <status> and tag <tag>
    Given I set the base URI
    When I update pet with ID <petId> and name "<name>" and status "<status>" and tag "<tag>"
    And I "put" request with resource "<resource>"
    Then I should receive status code <status_code>
    And the response should contain updated pet information with ID <petId> and name "<name>" and status "<status>" and tag "<tag>"

    Examples:
      | petId | name                  | status         | tag       | resource | status_code |
      | 7777  | doggie-laxman-update2 | Available-Update | tag-update | /pet/   | 200         |

Scenario Outline: Get pet with ID <petId>
    Given I set the base URI
    When I "get" request with resource "/pet/<petId>"
    Then I should receive status code <status_code>
    And the response should match the schema "<schema>"
    And the response should contain updated pet information with ID <petId> and name "<name>" and status "<status>" and tag "<tag>"
    

    Examples:
      | petId |  status_code | schema      | name                 | status            | tag 			 |
      | 7777  |  200         | schema2.json| doggie-laxman-update2 | Available-Update | tag-update |