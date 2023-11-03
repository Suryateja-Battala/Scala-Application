package FirstTask

import com.typesafe.config.{Config, ConfigFactory}

import java.sql.{Connection, DriverManager, Statement}
import org.h2.jdbcx.JdbcDataSource
import resource.managed

import java.util.UUID
trait DbTestSupport {

  val sqlType: Map[String, String] = Map(
    "ID" -> "Int",
    "name" -> "varchar(50)",
    "location" -> "varchar(50)"
  )

  val config: Config = ConfigFactory.load("applicationTest.conf")
  val url: String = config.getString("jdbc.url")
  val user: String = config.getString("jdbc.user")
  val password: String = config.getString("jdbc.password")

  def createDatabase(databasename: String): Connection = {
    DriverManager.getConnection(url, user, password)
  }
  val databaseName:String=UUID.randomUUID.toString
  def dataSourceURL:String=s"jdbc:h2:mem:$databaseName;$DbTestSupport.DoNotAutoClose;"

  def withInmemoryData:JdbcDataSource= {
    val dataSource = new JdbcDataSource
    dataSource.setUrl("dataSourceURL")
    managed(dataSource.getConnection) acquireAndGet{conn =>
      dropAllObjects(conn)
      setupDatabase(conn)
    }
    dataSource
  }
  def setupDatabase(connection:Connection):Unit={}
  def executeSql(connection: Connection, sql: String):Boolean=managed(connection.createStatement).acquireAndGet(_.execute(sql))
  def dropAllObjects(connection: Connection):Unit=executeSql(connection,"DROP ALL OBJECTS")

  def createTable(connection: Connection, tableName: String): Unit = {
    val statement: Statement = connection.createStatement()
    val columns = sqlType.map { case (columnName, columnIndex) =>
      s"$columnName $columnIndex"
    }.mkString(", ")
    val createTableSql = s"CREATE TABLE $tableName ($columns)"
    statement.execute(createTableSql)
    statement.close()
  }

  def closeDatabase(connection: Connection): Unit = {
    connection.close()
  }
}

object DbTestSupport {
  val DoNotAutoClose = "DB_CLOSE_DELAY=-1"
}