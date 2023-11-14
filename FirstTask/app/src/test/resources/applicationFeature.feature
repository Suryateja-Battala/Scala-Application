Feature: Load Test

  @wip
  Scenario:Simulate a load on the system
    Given the system is ready
    When I simulate load with 100 iterations
    Then the system should handle the load efficiently
