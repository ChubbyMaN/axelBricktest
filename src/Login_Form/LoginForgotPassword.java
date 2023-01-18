package Login_Form;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

public class LoginForgotPassword {

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
        public void TC08_ForgotPassword() throws InterruptedException{
            driver.get("https://qademo.onebrick.io/login");

            driver.findElement(By.linkText("Forgot Password?")).click();
            Thread.sleep(2000);

            //String pageTitle = driver.getTitle();
            //Assert.assertEquals("Forgot password", pageTitle,"Assertion Failed, User Should Be On the Signup  Page");

            String pageUrl = driver.getCurrentUrl();
            Assert.assertEquals("https://qademo.onebrick.io/forgot", pageUrl,"Assertion Failed, User Should Be On the Forgot Password Page");

            Thread.sleep(2000);
        }


        @AfterSuite
        public void end(){
            driver.close();
            driver.quit();
        }

}
