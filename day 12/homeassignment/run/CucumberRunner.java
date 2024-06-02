package run;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/feature", 
glue={"steps","hooks"}, monochrome=true, publish=true,tags="@smoke and @sanity")
public class CucumberRunner extends AbstractTestNGCucumberTests{

}
