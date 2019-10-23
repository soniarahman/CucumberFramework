package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import java.util.concurrent.TimeUnit;

@CucumberOptions (features = "/Users/soniarahman/Documents/TeamWork/IMDbFramework/IMDb/src/main/test/features", glue = {"stepDefinition"})
public class TestRunner extends AbstractTestNGCucumberTests{
    public static WebDriver driver =null;
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void setUp(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        System.setProperty("webdriver.chrome.driver", "/Users/soniarahman/Documents/TeamWork/IMDbFramework/Common/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
        // the 'featureWrapper' parameter solely exists to display the feature file in a test report
        testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
    }
    @DataProvider
    public Object[][] features (){
       return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass
    public void cleanUp() {
        driver.quit();
    }

}

