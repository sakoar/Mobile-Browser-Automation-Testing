package NativeApp;

import java.awt.Checkbox;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.testng.Assert;
import org.testng.DependencyMap;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.java.swing.plaf.windows.resources.windows;
import com.sun.tracing.dtrace.DependencyClass;
import com.thoughtworks.selenium.webdriven.commands.Click;
public class MPSPortalAutomation {
	public static AndroidDriver driver;
	
@BeforeTest
	public void setUP() throws MalformedURLException{
		
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("deviceName", "iPhone");
		  capabilities.setCapability("platformVersion", "5.4.2");
		  capabilities.setCapability("platformName", "Android");
		  
		  capabilities.setCapability("appPackage","com.android.chrome");
		  capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main"); 
		
		  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
//######################################## LOGIN TEST #######################################
@Test
  public void LoginTest() throws MalformedURLException, InterruptedException {
	  System.out.println("Browser Launched");
	  driver.get("https://venus-dev.lexmark.com");
	  driver.findElement(By.id("user_email")).sendKeys("test15@walmart.com");
	  driver.findElement(By.id("user_password")).sendKeys("Password12345");
	  driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
	  System.out.println("Login Button Clicked");
	  System.out.println("Going to click on MENU");
  }
  
//######################################## DASHBOARD TEST #####################################
@Test(dependsOnMethods={ "LoginTest" })
  public void DashboardTest() throws InterruptedException{
	  driver.findElement(By.xpath("//span[text()='Menu']")).click();
	  System.out.println("Selected Tab is :"+driver.findElement(By.xpath("//*[@id='mobileNav']/aside/nav/ul/li[1]/a/span[2]")).getText());
	  Thread.sleep(2000);
 }
 
//######################################## ADDRESS TEST #######################################
 @Test (dependsOnMethods={"DashboardTest"})
  public void AddressTest() throws InterruptedException{
	  driver.findElement(By.xpath("//*[@id='mobileNav']/aside/nav/ul/li[3]/a/span[2]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[text()='Menu']")).click();
	  Thread.sleep(2000);
 }

//######################################## DEVICE TEST #######################################
@Test (dependsOnMethods={"AddressTest"})
 public void DeviceTest() throws InterruptedException{
	  driver.findElement(By.xpath("//*[@id='mobileNav']/aside/nav/ul/li[2]/a/span[2]")).click();
	  Thread.sleep(10000);
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("scroll(0,250);");
	  driver.findElement(By.xpath("//span[text()='Menu']")).click();
	  Thread.sleep(2000);
}

//######################################## REPORTS TEST ####################################### 
@Test(dependsOnMethods={"DeviceTest"})
	public void TestReport() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='mobileNav']/aside/nav/ul/li[7]/a/span[2]")).click();  //Reports- //*[@id="mobileNav"]/aside/nav/ul/li[7]/a/span[2]
		Thread.sleep(8000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div[2]/div[3]/a")));
		Thread.sleep(2000);
 }
  
//######################################## TEAR DOWN #########################################
@AfterTest
  public void teatDown(){
	 	  driver.quit();
	   }
}
