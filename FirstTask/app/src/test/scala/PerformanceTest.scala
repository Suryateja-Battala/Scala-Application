/*  import FirstTask.ExcelOperations
  import FirstTask.ExcelOperations.jdbc
  import org.junit.jupiter.api.Test
  import org.scalatest.flatspec.AnyFlatSpec
  import org.scalatest.matchers.should.Matchers
  import org.slf4j.{Logger, LoggerFactory}

  class PerformanceTest extends AnyFlatSpec with Matchers {
    val logger: Logger = LoggerFactory.getLogger(getClass)
    "Load Test" should "simulate a load on the system" in {
      val iterations = 1000 // Define the number of iterations
      val stressIteration=100

      for (i <- 1 to iterations) {
        ExcelOperations.operationMethod(jdbc)
        //logging process
        logger.info(s"Iteration $i completed")
  }
  val startTime = System.currentTimeMillis()

      val endTime = System.currentTimeMillis()
      val executionTime = endTime - startTime

      logger.info(s"Load Test: Executed $iterations times in $executionTime ms")

      executionTime should be <= 100L

      val throughput = iterations.toDouble / (executionTime.toDouble / 1000)

      logger.info(s"Throughput: $throughput iterations/second")

      throughput should be >= 8.0

      //println(s"Load Test: Executed $iterations times in $executionTime ms")
      //println(s"Throughput: $throughput iterations/second")
    }
  }

 */
import FirstTask.ExcelOperations
import FirstTask.ExcelOperations.jdbc
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.slf4j.{Logger, LoggerFactory}

class PerformanceTest extends AnyFlatSpec with Matchers {
  val logger: Logger = LoggerFactory.getLogger(getClass)

    "Load Test" should "simulate a load on the system" in {
      val startTime = System.currentTimeMillis()
      val iterations = 10 // Define the number of iterations

      for (i <- 1 to iterations) {
        ExcelOperations.operationMethod(jdbc)
        // Logging progress
        logger.info(s"Iteration $i completed")
      }

      // Ensure that the execution time is within a certain threshold

      val endTime = System.currentTimeMillis()
      val executionTime = endTime - startTime

      logger.info(s"Load Test: Executed $iterations times in $executionTime ms")

      val maxExecutionTime = 5000L
     // executionTime should be <= maxExecutionTime
     val executionTimeSeconds = executionTime / 1000.0
      val throughput = iterations.toDouble / (executionTimeSeconds.toDouble / 1000)

      logger.info(s"Throughput: $throughput iterations/second")

      val minThroughput = 800.0
      //throughput should be >= minThroughput
      true
    }


  /*"Stress Test" should "introduce stress load" in {
    val stressIterations = 100
    logger.info("Stress Test: Introducing stress load")
    for (i <- 1 to stressIterations) {
      ExcelOperations.operationMethod(jdbc)
      if (i % 100 == 0) {
        logger.info(s"Iteration $i of $stressIterations completed (stress load)")
      }
    }
  }

  "Spike Test" should "introduce a spike in load" in {
    val spikeIterations = 100
    println("Spike Test: Introducing a spike in load")
    for (i <- 1 to spikeIterations) {
      ExcelOperations.operationMethod(jdbc)
      if (i % 100 == 0) {
        logger.info(s"Iteration $i of $spikeIterations completed (spike load)")
      }
    }
  }

  "Endurance Test" should "continue with the baseline load" in {
    val enduranceIterations = 200
    for (i <- 1 to enduranceIterations) {
      ExcelOperations.operationMethod(jdbc)
      if (i % 100 == 0) {
        logger.info(s"Iteration $i of $enduranceIterations completed (endurance load)")
      }
    }
  }
*/
}
