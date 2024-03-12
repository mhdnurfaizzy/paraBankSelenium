package mhdnurfaizzy.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import mhdnurfaizzy.pageobjects.LandingPageBank;
import mhdnurfaizzy.pageobjects.RegistrationPage;
import mhdnurfaizzy.testComponent.baseTestBank;


public class regressionParaBank extends baseTestBank {
	
	private String generatedUsername;

	@Test
	public void registration() throws InterruptedException {
		

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
//        String username = faker.name().username();
        generatedUsername = generateUsername();
        
        String password = "password123"; // Use a fixed password for simplicity


        // Fill the registration form
        registrationPage.fillRegistrationForm(firstName, lastName, address, city, state, zipCode, phoneNumber, ssn, generatedUsername, password);
        registrationPage.clickRegister();
        
        // End of Register Account
        
        //Logout 
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();
        
        

	}
	
	public void Login() { 
		//user login valid data
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(generatedUsername);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("password123");
		driver.findElement(By.cssSelector("input[value='Log In']")).click();
		
		//landing on account overview
		//Verify table account overview
		System.out.println(driver.findElement(By.cssSelector(".title")).getText());
		driver.quit();
		
		
        }
	
	   private String generateUsername() {
	        // Generate username using Faker or any other method
	        // For example, using Faker
	        Faker faker = new Faker();
	        String username = faker.name().username();
	        return username;
	    }

}










