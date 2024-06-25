package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddCustomerPage;
import pages.LoginPage;

import java.time.Duration;

public class LoginSteps extends BaseClass {
    @Given("user launch chrome browser")
    public void user_launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("the user opens URL {string}")
    public void the_user_opens_url(String url) {
        driver.get(url);
    }

    @And("the user enters email as {string} and password as {string}")
    public void the_user_enters_email_as_and_password_as(String email, String password) {
        loginPage.setUserName(email);
        loginPage.setPassword(password);
    }

    @And("clicks on the login button")
    public void clicks_on_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String string) {
        Assert.assertTrue(!driver.getPageSource().contains("Login was unsuccesful."));
    }

    @When("user click on log out link")
    public void user_click_on_log_out_link() {
        loginPage.clickLogout();
    }

    @And("close browser")
    public void close_browser() {
        driver.close();
    }

    // Customer feature step definition
    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        addCustomerPage = new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration", addCustomerPage.getPageTitle());
    }

    @When("User click on customers Menu")
    public void user_click_on_customers_menu() {
        addCustomerPage.clickLinkCustomersMenu();
    }

    @When("click on customers menu item")
    public void click_on_customers_menu_item() {
        addCustomerPage.clickLinkCustomersMenuItem();
    }

    @When("click on Add new button")
    public void click_on_add_new_button() {
        addCustomerPage.clickBtnAddNew();
    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration", addCustomerPage.getPageTitle());
    }

    @When("User enter customer info")
    public void user_enter_customer_info() {
        Faker faker = new Faker();
        addCustomerPage.setEmail(faker.internet().emailAddress());
        addCustomerPage.setPassword("Test1234");

        addCustomerPage.setCustomerRoles(AddCustomerPage.CustomerRoles.Guests);
        addCustomerPage.selectGender(AddCustomerPage.Gender.Male);
        addCustomerPage.setManagerOfVendor(AddCustomerPage.Vendor.Vendor2);
        addCustomerPage.setTxtFirstName("Karan");
        addCustomerPage.setLastName("Gandu");
        addCustomerPage.setDob("7/05/2000"); // d/MM/yyyy
        addCustomerPage.setCompany("Namaskara");
        addCustomerPage.setAdminComment("Testing......");
    }

    @When("click on save button")
    public void click_on_save_button() {
        addCustomerPage.clickBtnSave();
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
                .contains("The new customer has been added successfully"));
    }
}
