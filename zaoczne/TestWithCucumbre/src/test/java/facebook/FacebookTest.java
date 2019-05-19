package facebook;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class FacebookTest {
    WebDriver wD = null;

    @Given("^Im on Facebook Page$")
    public void given(){
        System.setProperty(
                "webdriver.gecko.driver",
                "D:\\Programowanie\\gecodriver\\geckodriver.exe");
        wD = new FirefoxDriver();
        wD.navigate().to("https://www.facebook.com/");
    }

    @When("^I enter username '(.*)'$")
    public void insertUserName(String arg1){
        wD.findElement(By.id("email")).sendKeys(arg1);
    }

    @When("^I enter password '(.*)'$")
    public void insertPassword(String arg1){
        wD.findElement(By.id("pass")).sendKeys(arg1);
    }

    @When("^I click on Login$")
    public void clickLogin(){
        wD.findElement(By.id("loginbutton")).click();
    }

    @Then("^Login failed$")
    public void loginFailed(){
        assertTrue(wD.getCurrentUrl().equalsIgnoreCase(
                "https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=110"));
        wD.close();
    }

    @Then("^Login is succesfull$")
    public void LoginSuccess(){
        fail();
    }

}
