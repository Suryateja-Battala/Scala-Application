package FirstTask

import com.sun.org.slf4j.internal.{Logger, LoggerFactory}
import com.typesafe.config.{Config, ConfigFactory}
import java.lang.ProcessHandle.Info
//import org.apache.logging.log4j.Logger
//import org.apache.logging.log4j.core.Logger
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.h2.engine.Database
import java.io.FileOutputStream
import java.sql.{Connection, DriverManager, Statement}
import scala.collection.immutable.Range.Inclusive
import org.h2.jdbcx.JdbcDataSource

object ExcelOperations {
  val config = ConfigFactory.load("application.conf")
  val jdbc = config.getConfig("jdbc")
  //val logger:Logger=LoggerFactory.getLogger(getClass)
  def operationMethod(config: Config): Unit = {
    val connection: Connection = DriverManager.getConnection(jdbc.getString("url"), jdbc.getString("user"), jdbc.getString("password"))
    ResourceManagement.withCloseable(connection) { conn =>
      val os: FileOutputStream = new FileOutputStream(jdbc.getString("excelFilePath"))

      ResourceManagement.withCloseable(os) { os =>

        try {
          val statement = connection.createStatement()
          val wb = new HSSFWorkbook()
          val sheet = wb.createSheet("EmployeesData888")
          val resultSet = statement.executeQuery("SELECT * FROM Employee")

          val dbData = resultSet.getMetaData
          val cc = dbData.getColumnCount

          val header: Seq[String] = (1 to cc).map(i => dbData.getColumnName(i))
          val rowHead = sheet.createRow(0)

          header.zipWithIndex.foreach { case (colName, index) =>
            rowHead.createCell(index).setCellValue(colName)
          }
          var r = 1

          while (resultSet.next()) {
            val rowData = sheet.createRow(r)
            val rowDataSeq: Seq[String] = (1 to cc).map(i => resultSet.getString(i))

            rowDataSeq.zipWithIndex.foreach { case (value, i) =>
              rowData.createCell(i).setCellValue(value)
            }

            r += 1
          }
          wb.write(os)
          println("Excel Generated Successfully")
          //logger.info("Excel Generated Successfully")
        } catch {
          case e: Exception =>
            e.printStackTrace()
          // logger.error("error occurred,e")
        }
      }
    }

    object ResourceManagement {
      def withCloseable[T <: AutoCloseable, R](resource: T)(block: T => R): R = {
        try {
          block(resource)
        } finally {
          resource.close()
        }
      }
    }
  }
}
