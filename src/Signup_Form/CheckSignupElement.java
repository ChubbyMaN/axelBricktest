package Signup_Form;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class CheckSignupElement {

    WebDriver driver;

        @BeforeSuite 
        public void setup() throws InterruptedException{
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Axel Ryan Matthew\\Documents\\VS Code Workspace\\Selenium\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Thread.sleep(2000);
        }

        @Test
        public void TC12_displayLoginElements() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");
            
            driver.findElement(By.cssSelector("input#firstName")).isDisplayed();
            driver.findElement(By.cssSelector("input#lastName")).isDisplayed();
            driver.findElement(By.cssSelector("#email")).isDisplayed();
            driver.findElement(By.cssSelector("input#phoneNumber")).isDisplayed();
            driver.findElement(By.cssSelector("input#address")).isDisplayed();
            driver.findElement(By.cssSelector("input#password")).isDisplayed();
            driver.findElement(By.cssSelector("input#confirm_password")).isDisplayed();
            driver.findElement(By.cssSelector("input[name='register']")).isDisplayed();
            driver.findElement(By.linkText("Login")).isDisplayed();
            driver.findElement(By.linkText("Contact sales")).isDisplayed();

            Thread.sleep(2000);
        }

        @AfterSuite
        public void end(){
            driver.close();
            driver.quit();
        }


}
