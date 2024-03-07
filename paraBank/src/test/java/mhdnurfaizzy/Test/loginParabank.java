package mhdnurfaizzy.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

public class loginParabank {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//headless mode
//		EdgeOptions options = new EdgeOptions();  
//		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors"); 
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://parabank.parasoft.com/");
		
		//user login valid data
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("izi");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("testing");
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
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("izi");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("testing890");
		driver.findElement(By.cssSelector("input[value='Log In']")).click();
		
		//landing on account overview
		driver.quit();
		

	}

}
