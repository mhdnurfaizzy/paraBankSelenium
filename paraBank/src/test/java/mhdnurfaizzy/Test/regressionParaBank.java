package mhdnurfaizzy.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

public class regressionParaBank {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//headless mode
		EdgeOptions options = new EdgeOptions();  
		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors"); 
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://parabank.parasoft.com/");
		
		//Register new account
		//go to register page
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(30))
	            .pollingEvery(Duration.ofSeconds(1));
//	            .ignoring(org.openqa.selenium.NoSuchElementException.class);

	        // Wait for the element to be clickable
//	        WebElement registerLink = 
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Register']")));

		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		//fill form register new account
		 // Find form elements by XPath and send keys
        driver.findElement(By.xpath("//input[@id='customer.firstName']"))
              .sendKeys("John");
        driver.findElement(By.xpath("//input[@id='customer.lastName']"))
              .sendKeys("Doe");
        driver.findElement(By.xpath("//input[@id='customer.address.street']"))
              .sendKeys("123 Main St");
        driver.findElement(By.xpath("//input[@id='customer.address.city']"))
              .sendKeys("Anytown");
        driver.findElement(By.xpath("//input[@id='customer.address.state']"))
              .sendKeys("CA");
        driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"))
              .sendKeys("12345");
        driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"))
              .sendKeys("123-456-7890");
        driver.findElement(By.xpath("//input[@id='customer.ssn']"))
              .sendKeys("123-45-6789");
        driver.findElement(By.xpath("//input[@id='customer.username']"))
              .sendKeys("johndoe");
        driver.findElement(By.xpath("//input[@id='customer.password']"))
              .sendKeys("password123");
        driver.findElement(By.xpath("//input[@id='repeatedPassword']"))
              .sendKeys("password123");
        //submit
        driver.findElement(By.cssSelector("input[value='Register']")).click();
        
       // End of Register Account
        
        //Logout 
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Log Out']")));
        driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();

		
		//user login with invalid data
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("johndoe");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("password");
		driver.findElement(By.cssSelector("input[value='Log In']")).click();
		//verify error message
//		String bodyText = driver.findElement(By.cssSelector(".error")).getText();
//		Assert.assertTrue("Text not found!", bodyText.contains(text));
		String ActualTitle = driver.findElement(By.cssSelector(".error")).getText();
		String ExpectedTitle = "An internal error has occurred and has been logged.";
		Thread.sleep(2000);
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		
//		driver.findElement(By.cssSelector(".error")).getText();
		
		//user login valid data
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("johndoe");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("password123");
		driver.findElement(By.cssSelector("input[value='Log In']")).click();
		
		
		
		//landing on account overview
		//Verify table account overview
		driver.findElement(By.cssSelector(".title")).getText();
		driver.quit();
		

	}

}
