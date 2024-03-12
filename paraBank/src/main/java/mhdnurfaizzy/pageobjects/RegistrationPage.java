package mhdnurfaizzy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver)
	{
//		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement registerLink;

    @FindBy(id = "customer.firstName")
    private WebElement firstNameInput;

    @FindBy(id = "customer.lastName")
    private WebElement lastNameInput;

    @FindBy(id = "customer.address.street")
    private WebElement addressInput;

    @FindBy(id = "customer.address.city")
    private WebElement cityInput;

    @FindBy(id = "customer.address.state")
    private WebElement stateInput;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCodeInput;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumberInput;

    @FindBy(id = "customer.ssn")
    private WebElement ssnInput;
    
    @FindBy(id = "customer.username")
    private WebElement usernameInput;

    @FindBy(id = "customer.password")
    private WebElement passwordInput;

    @FindBy(id = "repeatedPassword")
    private WebElement repeatedPasswordInput;
    
    @FindBy(xpath = "//input[@value='Register']")
    private WebElement register;
    

 
    public void goToRegisterPage() {
        registerLink.click();
    }

    public void fillRegistrationForm(String firstName, String lastName, String address, String city, String state, String zipCode, String phoneNumber, String ssn, String username, String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        stateInput.sendKeys(state);
        zipCodeInput.sendKeys(zipCode);
        phoneNumberInput.sendKeys(phoneNumber);
        ssnInput.sendKeys(ssn);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        repeatedPasswordInput.sendKeys(password);
    }
    
    public void clickRegister() {
    	register.click();
    }
    
    public String generateUsername() {
        // Generate username using Faker or any other method
        Faker faker = new Faker();
        String username = faker.name().username();
        return username;
    }
	
}
