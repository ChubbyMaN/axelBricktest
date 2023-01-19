package Signup_Form;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

public class SignupLinkText {

    WebDriver driver;

        @BeforeSuite 
        public void setup() throws InterruptedException{
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Axel Ryan Matthew\\Documents\\VS Code Workspace\\Selenium\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Thread.sleep(3000);
        }

        @Test
        public void TC31_LoginLink() throws InterruptedException{
            // the email to be used = usedEmail@mail.com

            driver.get("https://qademo.onebrick.io");
  
            driver.findElement(By.linkText("Login")).click();
            Thread.sleep(3000);

            String pageTitle = driver.getTitle();
            Assert.assertEquals("Login", pageTitle,"User should be redirected to the Login Page");

            String pageUrl = driver.getCurrentUrl();
            Assert.assertEquals("https://qademo.onebrick.io/login", pageUrl,"User should be redirected to Login Page");

            Thread.sleep(2000);
        }

        @Test
        public void TC32_ContactLink() throws InterruptedException{
            // the email to be used = usedEmail@mail.com

            driver.get("https://qademo.onebrick.io");
  
            driver.findElement(By.linkText("Contact sales")).click();
            Thread.sleep(3000);

            Thread.sleep(2000);
        }

        @AfterSuite
        public void end(){
            driver.close();
            driver.quit();
        }

}
