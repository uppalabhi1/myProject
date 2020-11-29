package Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class MobileTesting {

AndroidDriver driver;
@BeforeTest
public void SplashScreen() throws MalformedURLException, InterruptedException {
DesiredCapabilities capabilities = new DesiredCapabilities();// intialize the capabilities
capabilities.setCapability("deviceName", "RZ8M412KQLJ"); //obtained from the command "adb devices"
capabilities.setPlatform(Platform.WIN10);
capabilities.setCapability("platformName", "Android");
capabilities.setCapability("appPackage", "com.opsway.boodmo");
capabilities.setCapability("appActivity", "com.opsway.boodmo.MainActivity"); 
driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}

@Test
public void Login() throws InterruptedException{
	driver.findElement(By.xpath("//android.view.View[@content-desc=\"OK\"]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"CAR\"]")).click();
	driver.findElement(By.xpath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[2]")).click();
	driver.findElement(By.xpath("//*[@text='BMW']")).click();
	driver.findElement(By.xpath("//*[@text='Model Line']")).click();
	driver.findElement(By.xpath("//*[@text='4 SERIES']")).click();
	driver.findElement(By.xpath("(//android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3])[2]")).click();
	driver.findElement(By.xpath("//*[@text='2018']")).click();
	driver.findElement(By.xpath("//*[@text='Modification']")).click();
	driver.findElement(By.xpath("//*[@text='M4/3.0L/Petrol']")).click();
	driver.findElement(By.xpath("//*[@text='SEARCH PARTS']")).click();
	driver.findElement(By.xpath("//*[@text='Rim Cleaner (250ml)']")).click();
	String Part2= driver.findElement(By.xpath("//*[@text='Rim Cleaner (250ml)']")).getText();
	System.out.println("The name of part is :" +Part2);
	Thread.sleep(3000);
	scrollAndClick("Add to cart");
	//driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Proceed to checkout']")).click();
	driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@text='BAG, TOOL STOW']")).click();
	Thread.sleep(1000);
	String Part1= driver.findElement(By.xpath("//*[@text='BAG, TOOL STOW']")).getText();
	System.out.println("The name of part is :" +Part1);
	Thread.sleep(3000);
	scrollAndClick("Add to cart");
	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Proceed to checkout']")).click();
	driver.findElement(By.xpath("//*[@text='Enter your email address']")).sendKeys("test1274abc@mailinator.com");
	driver.hideKeyboard();
	driver.findElement(By.xpath("//*[@text='CONTINUE']")).click();
	driver.findElement(By.xpath("//*[@text='Pincode']")).sendKeys("147001");
	driver.hideKeyboard();
	driver.findElement(By.xpath("//*[@text='Phone']")).sendKeys("9789898990");
	driver.hideKeyboard();
	driver.findElement(By.xpath("//*[@text='First Name']")).sendKeys("testing");
	driver.hideKeyboard();
	driver.findElement(By.xpath("//*[@text='Last Name']")).sendKeys("testing");
	driver.hideKeyboard();
	driver.findElement(By.xpath("//*[@text='Address']")).sendKeys("123, testerhome");
	driver.hideKeyboard();
	scrollAndClick("SAVE AND CONTINUE");
	driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Proceed to checkout']")).click();
	driver.findElement(By.xpath("//*[@text='SAVE AND CONTINUE']")).click();
	if(Part1.equals("BAG, TOOL STOW")) {
		System.out.println("Success");
	}
	else {
		System.out.println("Failure");
	}

	scroll("Rim Cleaner (250ml)");
	if(Part2.equals("Rim Cleaner (250ml)")) {
		System.out.println("Success");
	}
	else {
		System.out.println("Failure");
	}	
	

}

@AfterTest
public void end()
{
driver.quit(); //Close application
}
public void scrollAndClick(String visibleText) {
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
       }

public void scroll(String visibleText) {
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))");
       }


}
