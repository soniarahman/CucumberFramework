package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObjects.SignInPage;
import runner.TestRunner;

public class SignInStepDefinition extends TestRunner {
    SignInPage signInPage = new SignInPage(driver);

    @Given("^user have navigate to Signin Page$")
    public void userNavigateToSignIn () throws InterruptedException {
        this.signInPage.navigateToSignInPage();
        Thread.sleep(1000);
    }
    @Then("^user have to click to Sign in with IMDb$")
    public void userClickSignInBtn () throws InterruptedException {
        this.signInPage.validateSignInWithIMDb();
        Thread.sleep(1500);
    }
    @And("^user enters 'email' and '<password>'$")
    public void userEntersEmailAndPasswrd () throws InterruptedException {
    this.signInPage.enterInEmail("automationsonia@gmail.com");
    Thread.sleep(1000);
    this.signInPage.enterInPassword("S1234567@");
    }
    @Then("^user clicks on Signin button$")
    public void userClickOnSignInBtn(){
        this.signInPage.enterSignInBtn();
    }
    @Then("^user navigates to home page$")
    public void userNavigatesToHomePage () throws InterruptedException {
        this.signInPage.navigateToSignInPage();
        Thread.sleep(1000);
    }




}
