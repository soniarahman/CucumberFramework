package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import runner.TestRunner;

public class SignInPage extends TestRunner {
    private String signInPageUrl = "https://www.imdb.com/registration/signin";
    private String homePageUrl = "https://www.imdb.com/?ref_=login";

    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver, SignInPage.class);
    }
    @FindBy (xpath = "//a[@class='list-group-item ]")
    private WebElement signInWithIMDb;
    @FindBy(css = "input[name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;
    @FindBy (css = "input#signInSubmit")
    private WebElement signInButton;



    //--------------------------------------------------------------------
    public void navigateToSignInPage (){
     driver.navigate().to(this.signInPageUrl);
    }
    public void validateSignInWithIMDb (){
        signInWithIMDb.click();
    }
    public void enterInEmail(String email){
      emailField.sendKeys(email);
    }
    public void enterInPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void enterSignInBtn (){
        signInButton.click();
    }
    public void navigateToHomePage (){
        driver.navigate().to(this.homePageUrl);
    }

}
