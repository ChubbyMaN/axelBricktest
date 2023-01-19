package Login_Form;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

public class LoginPositiveTest {

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
        public void TC06_successLogin() throws InterruptedException{
            driver.get("https://qademo.onebrick.io/login");

            driver.findElement(By.cssSelector("#your_email")).sendKeys("axeltest123@email.com");
            driver.findElement(By.cssSelector("input#password")).sendKeys("123456");
            driver.findElement(By.cssSelector("input[name='login']")).click();
            Thread.sleep(4000);

            String successMessage = driver.findElement(By.cssSelector("#swal2-title")).getText();
            Assert.assertEquals("Success", successMessage);

            Thread.sleep(2000);
            
            driver.findElement(By.cssSelector(".swal2-confirm")).click();

            String pageTitle = driver.getTitle();
            Assert.assertEquals("Brick Dashboard", pageTitle,"Assertion Failed, Login Succced, User Should Be on Brick Dashboard");
           
            Thread.sleep(2000);
        }

        @Test
        public void TC07_Logout() throws InterruptedException{
            driver.get("https://qademo.onebrick.io/login");

            driver.findElement(By.cssSelector("#your_email")).sendKeys("axeltest123@email.com");
            driver.findElement(By.cssSelector("input#password")).sendKeys("123456");
            driver.findElement(By.cssSelector("input[name='login']")).click();
            Thread.sleep(4000);

            String successMessage = driver.findElement(By.cssSelector("#swal2-title")).getText();
            Assert.assertEquals("Success", successMessage);

            Thread.sleep(2000);
            
            driver.findElement(By.cssSelector(".swal2-confirm")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(".btn-danger")).click();
            Thread.sleep(2000);

            String pageTitle = driver.getTitle();
            Assert.assertEquals("Login", pageTitle,"Assertion Failed, Login Logout, User Should Be Back on Login Page");

            String pageUrl = driver.getCurrentUrl();
            Assert.assertEquals("https://qademo.onebrick.io/login", pageUrl,"Assertion Failed, User Should Be Back on Login Page");

            Thread.sleep(2000);
        }

        @Test
        public void TC08_BackButtonAfterLogin() throws InterruptedException{
            driver.get("https://qademo.onebrick.io/login");

            driver.findElement(By.cssSelector("#your_email")).sendKeys("axeltest123@email.com");
            driver.findElement(By.cssSelector("input#password")).sendKeys("123456");
            driver.findElement(By.cssSelector("input[name='login']")).click();
            Thread.sleep(4000);

            String successMessage = driver.findElement(By.cssSelector("#swal2-title")).getText();
            Assert.assertEquals("Success", successMessage);

            Thread.sleep(2000);
            
            driver.findElement(By.cssSelector(".swal2-confirm")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);

            String pageTitle = driver.getTitle();
            Assert.assertEquals("Login", pageTitle,"Assertion Failed, Login Logout, User Should Be Back on Login Page");

            String pageUrl = driver.getCurrentUrl();
            Assert.assertEquals("https://qademo.onebrick.io/login", pageUrl,"Assertion Failed, User Should Be Back on Login Page");

            Thread.sleep(2000);
        }

        @Test
        public void TC09_BackForwardAfterLogin() throws InterruptedException{
            driver.get("https://qademo.onebrick.io/login");

            driver.findElement(By.cssSelector("#your_email")).sendKeys("axeltest123@email.com");
            driver.findElement(By.cssSelector("input#password")).sendKeys("123456");
            driver.findElement(By.cssSelector("input[name='login']")).click();
            Thread.sleep(4000);

            String successMessage = driver.findElement(By.cssSelector("#swal2-title")).getText();
            Assert.assertEquals("Success", successMessage);

            Thread.sleep(2000);
            
            driver.findElement(By.cssSelector(".swal2-confirm")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().forward();

            String pageTitle = driver.getTitle();
            Assert.assertEquals("Brick Dashboard", pageTitle,"Assertion Failed, After Pressing Back & Forth, User Should Be Back on Dashboard Page logged in");

            Thread.sleep(2000);
        }

        @AfterSuite
        public void end(){
            driver.close();
            driver.quit();
        }

}
