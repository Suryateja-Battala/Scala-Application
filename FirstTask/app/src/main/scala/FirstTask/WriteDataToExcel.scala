package FirstTask

import com.typesafe.config.ConfigFactory
import FirstTask.ExcelOperations.jdbc
import java.sql.{Connection, DriverManager}

object WriteDataToExcel extends App {

  ExcelOperations.operationMethod(jdbc)

//For Stashing
/*

  val iterations=100     //Performance--stress testing

  val sleepTest=10

  // Perform a performance test
  val startTime = System.currentTimeMillis()

  for(i <- 1 to iterations){              //Performance-using stress testing load

  //for (_ <- 1 to 1000) {                      //performance-using some load ==> Load testing
    ExcelOperations.operationMethod(jdbc)
    //Thread.sleep(sleepTest)

    if (i % 10 == 0) {
      println(s"Iteration $i of $iterations completed")     //this loop will print the current iteration count every 100 iterations.
    }

  }
  val endTime = System.currentTimeMillis()

  val executionTime = endTime - startTime
  val executionTimeSeconds = executionTime / 1000.0 // Convert to seconds
 // println(s"Performance Test: Executed 1000 times in $executionTime ms")
 // println(s"Performance Test: Executed 1000 times in $executionTimeSeconds secs")

  println(s"Stress Test: Executed $iterations times with a $sleepTest ms sleep between iterations in $executionTimeSeconds seconds")
*/


}




/*

object WriteDataToExcel extends App {

  ExcelOperations.operationMethod(jdbc)

  val iterations = 10000   // The total number of iterations you want to perform
  val sleepTest = 100      // Sleep time between iterations (in milliseconds)
  val testDurationInSeconds = 3600  // Duration of the endurance test in seconds (1 hour in this example)

  val startTime = System.currentTimeMillis()
  var i = 0

  // Keep running the test until the specified duration is reached
  while (System.currentTimeMillis() - startTime < testDurationInSeconds * 1000) {
    ExcelOperations.operationMethod(jdbc)
    i += 1

    if (i % 100 == 0) {
      println(s"Iteration $i completed")
    }

    Thread.sleep(sleepTest)
  }

  val endTime = System.currentTimeMillis()
  val executionTime = endTime - startTime
  val executionTimeSeconds = executionTime / 1000.0

  println(s"Endurance Test: Executed $i iterations with a $sleepTest ms sleep between iterations in $executionTimeSeconds seconds")
}
 */

/*
object WriteDataToExcel extends App {

  ExcelOperations.operationMethod(jdbc)

  val iterations = 10000     // The total number of iterations for the baseline load
  val spikeIterations = 500  // The number of iterations during the spike
  val sleepTest = 100
  val spikeLoad = 100       // The increase in load during the spike

  // Perform the baseline load test
  for (i <- 1 to iterations) {
    ExcelOperations.operationMethod(jdbc)
    if (i % 100 == 0) {
      println(s"Iteration $i of $iterations completed (baseline load)")
    }
    Thread.sleep(sleepTest)
  }

  // Introduce the spike
  println("Spike Test: Introducing a spike in load")
  for (i <- 1 to spikeIterations) {
    ExcelOperations.operationMethod(jdbc)
    if (i % 100 == 0) {
      println(s"Iteration $i of $spikeIterations completed (spike load)")
    }
    Thread.sleep(sleepTest)
  }

  // Continue with the baseline load
  for (i <- iterations + 1 to iterations + spikeIterations) {
    ExcelOperations.operationMethod(jdbc)
    if (i % 100 == 0) {
      println(s"Iteration $i of $iterations completed (baseline load)")
    }
    Thread.sleep(sleepTest)
  }
}

 */

/*
//Using all types of performance testing at once except scalability

object WriteDataToExcel extends App {

  ExcelOperations.operationMethod(jdbc)

  val iterations = 10000     // The total number of iterations for the baseline load
  val stressIterations = 100  // The number of iterations during the stress test
  val spikeIterations = 500  // The number of iterations during the spike
  val enduranceIterations = 5000  // The number of iterations for endurance testing
  val sleepTest = 100
  val spikeLoad = 100       // The increase in load during the spike

  // Perform the baseline load test
  for (i <- 1 to iterations) {
    ExcelOperations.operationMethod(jdbc)
    if (i % 100 == 0) {
      println(s"Iteration $i of $iterations completed (baseline load)")
    }
    Thread.sleep(sleepTest)
  }

  // Perform stress testing
  println("Stress Test: Introducing stress load")
  for (i <- 1 to stressIterations) {
    ExcelOperations.operationMethod(jdbc)
    if (i % 100 == 0) {
      println(s"Iteration $i of $stressIterations completed (stress load)")
    }
    Thread.sleep(sleepTest)
  }

  // Introduce the spike
  println("Spike Test: Introducing a spike in load")
  for (i <- 1 to spikeIterations) {
    ExcelOperations.operationMethod(jdbc)
    if (i % 100 == 0) {
      println(s"Iteration $i of $spikeIterations completed (spike load)")
    }
    Thread.sleep(sleepTest)
  }

  // Continue with the baseline load
  for (i <- iterations + 1 to iterations + enduranceIterations) {
    ExcelOperations.operationMethod(jdbc)
    if (i % 100 == 0) {
      println(s"Iteration $i of $enduranceIterations completed (endurance load)")
    }
    Thread.sleep(sleepTest)
  }
  // The test suite is now complete
  println("Performance Test Suite completed")
}


 */

//Press Shift twice to open edit configurations
//Press Ctrl button tu Run anything