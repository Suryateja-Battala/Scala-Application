package FirstTask

import java.sql.{PreparedStatement, ResultSet, Statement}

object EmployeeTestSupport extends DbTestSupport with App {
  val databasename = "TestDB"

  val connection = createDatabase(databasename)
  println("Connected to H2 in-memory database.")

  val tableName = "Employee"

  createTable(connection, tableName)
  println(s"Created table $tableName.")

  closeDatabase(connection)
  println("Closed database connection.")

}