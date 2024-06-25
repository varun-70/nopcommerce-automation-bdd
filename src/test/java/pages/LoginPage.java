package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    // Initialization
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Declaration
    @FindBy(id = "Email")
    @CacheLookup
    private WebElement txtEmail;

    @FindBy(id = "Password")
    @CacheLookup
    private WebElement txtPassword;

    @FindBy(xpath = "//button[.='Log in']")
    @CacheLookup
    private WebElement btnLogin;

    @FindBy(xpath = "//a[.='Logout']")
    @CacheLookup
    private WebElement btnLogout;

    // Utilization
    public void setUserName(String userName) {
        txtEmail.clear();
        txtEmail.sendKeys(userName);
    }

    public void setPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void clickLogout() {
        btnLogout.click();
    }

}
