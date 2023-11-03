package FirstTask

import com.typesafe.config.ConfigFactory
import FirstTask.ExcelOperations.jdbc
import java.sql.{Connection, DriverManager}

object WriteDataToExcel extends App {

  ExcelOperations.operationMethod(jdbc)

//For Stashing

}

//Press Shift twice to open edit configurations
//Press Ctrl button tu Run anything
