package FirstTask

import FirstTask.ExcelOperations.jdbc
import io.cucumber.scala.{EN, ScalaDsl}

object AcceptanceExecutionSteps extends ScalaDsl with EN {
  Given("""the system is ready""") { () =>
    ExcelOperations.operationMethod(jdbc)
    // Implementation for system setup
  }

  When("""I simulate load with {int} iterations""") { (iterations: Int) =>
    ExcelOperations.operationMethod(jdbc)

  }

  Then("""the system should handle the load efficiently""") { () =>
    ExcelOperations.operationMethod(jdbc)

  }
}

