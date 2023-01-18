package Login_Form;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

public class LoginNegativeTest {

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
        public void TC02_NoInput() throws InterruptedException{
            driver.get("https://qademo.onebrick.io/login");

            driver.findElement(By.cssSelector("input[name='login']")).click();
            
            String pageTitle = driver.getTitle();
            Assert.assertEquals("Login", pageTitle,"Assertion Failed, Username & Password is Empty, User should stay at login page");

            Thread.sleep(3000);
        }

        @Test
        public void TC03_inputEmailOnly() throws InterruptedException{
            driver.get("https://qademo.onebrick.io/login");

            driver.findElement(By.cssSelector("#your_email")).sendKeys("axeltest123@email.com");
            driver.findElement(By.cssSelector("input[name='login']")).click();

            String pageTitle = driver.getTitle();
            Assert.assertEquals("Login", pageTitle,"Assertion Failed, Password is Empty, User should stay at login page");

            Thread.sleep(3000);
        }

        @Test
        public void TC04_inputPasswordOnly() throws InterruptedException{
            driver.get("https://qademo.onebrick.io/login");

            driver.findElement(By.cssSelector("input#password")).sendKeys("123456");
            driver.findElement(By.cssSelector("input[name='login']")).click();

            String pageTitle = driver.getTitle();
            Assert.assertEquals("Login", pageTitle,"Assertion Failed, Email is Empty, User should stay at login page");

            Thread.sleep(3000);
        }

        @Test
        public void TC05_inputIncorrectData() throws InterruptedException{
            driver.get("https://qademo.onebrick.io/login");

            driver.findElement(By.cssSelector("#your_email")).sendKeys("wrong@email.com");
            driver.findElement(By.cssSelector("input#password")).sendKeys("wrongpassword");
            driver.findElement(By.cssSelector("input[name='login']")).click();
            Thread.sleep(5000);
            driver.findElement(By.cssSelector(".swal2-actions")).click();
            Thread.sleep(3000);

            String pageTitle = driver.getTitle();
            Assert.assertEquals("Login", pageTitle,"Assertion Failed, Incorrect Email or PW, User should stay at login page");

            Thread.sleep(5000);
        }

        @AfterSuite
        public void end(){
            driver.close();
            driver.quit();
        }

}
