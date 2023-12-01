package FirstTask

import FirstTask.ExcelOperations.jdbc
import io.cucumber.junit.{Cucumber, CucumberOptions}
import io.cucumber.scala.{EN, ScalaDsl}
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(plugin = Array("pretty"),
                 features = Array("src/test/resources"),
                 tags = "@wip")
class AcceptanceCucumber