package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
    WebDriver driver;

    // Initialization ============================
    public AddCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Declaration =============================
    @FindBy(xpath = "//a[@href='#']//p[contains(text(), 'Customers')]")
    @CacheLookup
    private WebElement linkCustomersMenu;

    @FindBy(xpath = "(//li[@class='nav-item has-treeview'])[4]")
    @CacheLookup
    private WebElement linkCustomersMenuItem;

    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    @CacheLookup
    private WebElement btnAddNew;

    @FindBy(id = "Email")
    @CacheLookup
    private WebElement txtEmail;

    @FindBy(id = "Password")
    @CacheLookup
    private WebElement txtPassword;

    @FindBy(xpath = "(//ul[@class='select2-selection__rendered'])[2]")
    private WebElement txtCustomerRoles;

    @FindBy(xpath = "//li[@title= 'Registered']")
    private WebElement registeredRole;

    @FindBy(xpath = "//li[@title= 'Registered']/span")
    private WebElement clearCustomerRole;

    @FindBy(id = "select2-SelectedCustomerRoleIds-result-bqm5-3")
    private WebElement listItemRegistered;

    @FindBy(id = "select2-SelectedCustomerRoleIds-result-ofx5-4")
    private WebElement listItemGuest;

    @FindBy(id = "select2-SelectedCustomerRoleIds-result-j9rf-5")
    private WebElement listItemVendors;

    @FindBy(id = "Gender_Male")
    private WebElement rdMaleGender;

    @FindBy(id = "Gender_Female")
    private WebElement rdFemaleGender;

    @FindBy(id = "VendorId")
    private WebElement managerOfVendor;

    @FindBy(id = "FirstName")
    private WebElement txtFirstName;

    @FindBy(id = "LastName")
    private WebElement txtLastName;

    @FindBy(id = "DateOfBirth")
    private WebElement txtDob;

    @FindBy(id = "Company")
    private WebElement txtCompany;

    @FindBy(id = "AdminComment")
    private WebElement txtAdminComment;

    @FindBy(xpath = "//button[@name='save']")
    private WebElement btnSave;

    // Utilization =============================
    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickLinkCustomersMenu() {
        linkCustomersMenu.click();
    }

    public void clickLinkCustomersMenuItem() {
        linkCustomersMenuItem.click();
    }

    public void clickBtnAddNew() {
        btnAddNew.click();
    }

    public void setEmail(String email) {
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password) {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void setCustomerRoles(CustomerRoles customerRoles) {
        switch (customerRoles) {
            case Registered:
                registeredRole.isDisplayed();
                break;
            case Guests:
                clearCustomerRole.click();
                listItemGuest.click();
                break;
            case Vendors:
                clearCustomerRole.click();
                listItemVendors.click();
        }
    }

    public enum CustomerRoles {
        Registered,
        Guests,
        Vendors
    }

    public void selectGender(Gender gender) {
        if (gender == Gender.Male) {
            rdMaleGender.click();
        } else if (gender == Gender.Female) {
            rdFemaleGender.click();
        }
    }

    public enum Gender {
        Male,
        Female
    }

    public void setManagerOfVendor(Vendor vendor) {
        Select select = new Select(managerOfVendor);
        select.selectByVisibleText(vendor.toString());
    }

    public enum Vendor {
        NotAVendor,
        Vendor1,
        Vendor2
    }

    public void setTxtFirstName(String firstName) {
        txtFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        txtLastName.sendKeys(lastName);
    }

    public void setDob(String dob) {
        txtDob.sendKeys(dob);
    }

    public void setCompany(String company) {
        txtCompany.sendKeys(company);
    }

    public void setAdminComment(String adminComment) {
        txtAdminComment.sendKeys(adminComment);
    }

    public void clickBtnSave() {
        btnSave.click();
    }
}
