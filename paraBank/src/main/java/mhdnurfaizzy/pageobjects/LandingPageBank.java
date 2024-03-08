package mhdnurfaizzy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mhdnurfaizzy.AbstractComponenet.abstractComponent;

public class LandingPageBank extends abstractComponent{

	WebDriver driver;
	
	public LandingPageBank(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy(id="userEmail")
	 WebElement useremail;
	
	//driver.findElement(By.id("userPassword")) 
	@FindBy(id="userPassword")
	 WebElement passwordEle;
	
	@FindBy(id="login")
	 WebElement submit;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	 WebElement registerLink;

	
	public void goToRegisterPage() {
		waitWebElementForAppear(registerLink);
		registerLink.click();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductCatalogue loginApplication(String email, String password) {
		useremail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalog = new ProductCatalogue(driver);
		return productCatalog;
		
	}
}
