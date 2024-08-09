package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    // Constructor injection for WebDriver
    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage.openLoginPage();
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        loginPage.enterUsername("vayd.prakash@gmail.com");
        loginPage.enterPassword("Void@2024");
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully()
    {
        // Assertions to verify successful login
        // Locate the page heading element
        String actualPageHeading = driver.findElement(By.xpath("//h1[contains(text(), 'Dashboard')]")).getText();

        // Assert the expected page heading
        Assert.assertEquals(actualPageHeading, "Dashboard", "Page heading is incorrect");

    }

}
