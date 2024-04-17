package seleniumtest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;



public class SeleniumRelative {

	
	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void officeworks_registration_page(String url) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rohit Kadam/Downloads/chromedriver-win64/chromedriver.exe");
		
		
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		
		driver.get(url);
		
		WebElement element = driver.findElement(By.id("firstname"));
		element.sendKeys("Rohit");
		
		WebElement lastNameElement = driver.findElement(RelativeLocator.with(By.tagName("input")).below(element));
		lastNameElement.sendKeys("Kadam");
		
		
		WebElement phoneNumberelement = driver.findElement(RelativeLocator.with(By.tagName("input")).below(lastNameElement));
		phoneNumberelement.sendKeys("0420492852");
		
		WebElement emailelement = driver.findElement(RelativeLocator.with(By.tagName("input")).below(phoneNumberelement));
		emailelement.sendKeys("rohitkadam@gmail.com");
		
		WebElement passwordelement = driver.findElement(RelativeLocator.with(By.tagName("input")).below(emailelement));
		passwordelement.sendKeys("ABCDEFG");
		
		WebElement confirmpasswordelement = driver.findElement(RelativeLocator.with(By.tagName("input")).below(passwordelement));
		confirmpasswordelement.sendKeys("ABCDEFG");
		
		
		WebElement backtohome = driver.findElement(By.className("BackLink__StyledLink-s3qzkwk-0"));
		
		WebElement createAccountButton = driver.findElement(RelativeLocator.with(By.tagName("button")).above(backtohome));
        createAccountButton.click();
        
        try {
          File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(scrFile, new File("C:\\Users\\Rohit Kadam\\Desktop\\screenshot\\scrsht.png"));
      } catch (IOException e) {
          e.printStackTrace();
      }
		
	   sleep(2);
		
		
		driver.close();	
	}
	
}
