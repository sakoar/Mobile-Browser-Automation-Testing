package NativeApp;

import java.awt.Checkbox;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestNativeApp {
	public static AndroidDriver driver;
	
	@BeforeTest
	public void setUP() throws MalformedURLException{
		
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  
		  capabilities.setCapability("deviceName", "SAMSUNG-SM-N900A");
		  capabilities.setCapability("platformVersion", "4.4.2");
		  capabilities.setCapability("platformName", "Android");
		  
		  capabilities.setCapability("appPackage", "com.android.chrome");
		  capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		  
		  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				 
	}
	
  @Test
  public void Test() throws MalformedURLException {
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  System.out.println("Browser Launched");
	  driver.get("https://www.google.com");
	  System.out.println("Page title: "+driver.getTitle());
	  driver.findElement(By.name("q")).sendKeys("Appium test");
	  
	  /* WebElement Framelayout =driver.findElement(By.className("android.widget.FrameLayout"));
	  WebElement LinearLayOut = Framelayout.findElement(By.className("android.widget.LinearLayout"));
	  
	  WebElement CheckBox = LinearLayOut.findElement(By.className("android.widget.CheckBox"));
	 // WebElement AcceptButton = LinearLayOut.findElement(By.className("android.widget.Button"));
	  System.out.println("The Text is: "+CheckBox.getText());*/
	  //AcceptButton.click();
	 //tis is real device test
  }
  @AfterTest
  public void teatDown(){
	  driver.quit();
	  System.out.println("tearing down");
	  //driver.close();
  }
}
