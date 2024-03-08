package mhdnurfaizzy.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import mhdnurfaizzy.pageobjects.LandingPageBank;
import mhdnurfaizzy.pageobjects.RegistrationPage;
import mhdnurfaizzy.testComponent.baseTestBank;


public class regressionParaBank extends baseTestBank {
	
//	public static WebDriver driver;

	@Test
	public void regresion() throws InterruptedException {
		

	    LandingPageBank landingPageBank = new LandingPageBank(driver);
	    landingPageBank.goToRegisterPage();
	    
        RegistrationPage registrationPage = new RegistrationPage(driver);

        // Click on the Register link
        registrationPage.goToRegisterPage();

        // Instantiate Faker
        Faker faker = new Faker();
        // Generate fake data for registration form
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String address = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().stateAbbr();
        String zipCode = faker.address().zipCode();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        String ssn = faker.idNumber().validSvSeSsn();
        String username = faker.name().username();
        String password = "password123"; // Use a fixed password for simplicity


        // Fill the registration form
        registrationPage.fillRegistrationForm(firstName, lastName, address, city, state, zipCode, phoneNumber, ssn, username, password);
        registrationPage.clickRegister();
        
        // End of Register Account
        
        //Logout 
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();

		//user login valid data
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("password123");
		driver.findElement(By.cssSelector("input[value='Log In']")).click();
		
		//landing on account overview
		//Verify table account overview
		System.out.println(driver.findElement(By.cssSelector(".title")).getText());
		driver.quit();
		

	}

}



//user login with invalid data
//driver.findElement(By.cssSelector("input[name='username']")).sendKeys("john");
//driver.findElement(By.cssSelector("input[name='password']")).sendKeys("123");
//driver.findElement(By.cssSelector("input[value='Log In']")).click();
//verify error message
//String bodyText = driver.findElement(By.cssSelector(".error")).getText();
//Assert.assertTrue("Text not found!", bodyText.contains(text));
//String ActualTitle = driver.findElement(By.cssSelector(".error")).getText();
//String ExpectedTitle = "An internal error has occurred and has been logged.";
//Thread.sleep(2000);
//Assert.assertEquals(ExpectedTitle, ActualTitle);

//driver.findElement(By.cssSelector(".error")).getText();


//driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
////fill form register new account
// // Find form elements by XPath and send keys
//driver.findElement(By.xpath("//input[@id='customer.firstName']"))
//      .sendKeys("John");
//driver.findElement(By.xpath("//input[@id='customer.lastName']"))
//      .sendKeys("Doe");
//driver.findElement(By.xpath("//input[@id='customer.address.street']"))
//      .sendKeys("123 Main St");
//driver.findElement(By.xpath("//input[@id='customer.address.city']"))
//      .sendKeys("Anytown");
//driver.findElement(By.xpath("//input[@id='customer.address.state']"))
//      .sendKeys("CA");
//driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"))
//      .sendKeys("12345");
//driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"))
//      .sendKeys("123-456-7890");
//driver.findElement(By.xpath("//input[@id='customer.ssn']"))
//      .sendKeys("123-45-6789");
////Generate username using faker
//Faker faker = new Faker();
//String username = faker.name().username();
//username field and fill it with the generated username
//WebElement usernameField = driver.findElement(By.xpath("//input[@id='customer.username']"));
//usernameField.sendKeys(username);
//driver.findElement(By.xpath("//input[@id='customer.password']"))
//      .sendKeys("password123");
//driver.findElement(By.xpath("//input[@id='repeatedPassword']"))
//      .sendKeys("password123");
////submit
//driver.findElement(By.cssSelector("input[value='Register']")).click();








