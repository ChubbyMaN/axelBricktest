package Signup_Form;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

public class SignupNegativeTest2 {

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
        public void TC21_EmptyEmail() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");

            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement em = driver.findElement(By.cssSelector("label#email-error"));
            Assert.assertEquals("Please provide an email", em.getText(), "Wrong Error Message 3");

            //note: cannot test phone number validation error because the label does not exist in the DOM
            
            String pageTitle = driver.getTitle();
            Assert.assertEquals("Brick Sign Up Form", pageTitle,"User should still be on Brick Sign Up Form");

            String pageLink = driver.getCurrentUrl();
            Assert.assertEquals("https://qademo.onebrick.io/", pageLink,"User should still be on https://qademo.onebrick.io/");

            Thread.sleep(2000);
        }

        @Test
        public void TC22_InvalidEmail() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");

            driver.findElement(By.cssSelector("input#email")).sendKeys("ngasal");
            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement em = driver.findElement(By.cssSelector("label#email-error"));
            Assert.assertEquals("Please enter a valid email address.", em.getText(), "Wrong Error Message 3a");

            //note: cannot test phone number validation error because the label does not exist in the DOM
            
            String pageTitle = driver.getTitle();
            Assert.assertEquals("Brick Sign Up Form", pageTitle,"User should still be on Brick Sign Up Form");

            String pageLink = driver.getCurrentUrl();
            Assert.assertEquals("https://qademo.onebrick.io/", pageLink,"User should still be on https://qademo.onebrick.io/");

            Thread.sleep(2000);
        }

        @Test
        public void TC23_EmptyPassword() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");

            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement pw = driver.findElement(By.cssSelector("label#password-error"));
            Assert.assertEquals("Please enter a password", pw.getText(), "Wrong Error Message 4a");

            //note: cannot test phone number validation error because the label does not exist in the DOM
            
            String pageTitle = driver.getTitle();
            Assert.assertEquals("Brick Sign Up Form", pageTitle,"User should still be on Brick Sign Up Form");

            String pageLink = driver.getCurrentUrl();
            Assert.assertEquals("https://qademo.onebrick.io/", pageLink,"User should still be on https://qademo.onebrick.io/");

            Thread.sleep(2000);
        }

        @Test
        public void TC24_InvalidPassword() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");

            driver.findElement(By.cssSelector("input#password")).sendKeys("123");
            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement pw = driver.findElement(By.cssSelector("label#password-error"));
            Assert.assertEquals("Please enter at least 6 characters.", pw.getText(), "Wrong Error Message 4a");

            //note: cannot test phone number validation error because the label does not exist in the DOM
            
            String pageTitle = driver.getTitle();
            Assert.assertEquals("Brick Sign Up Form", pageTitle,"User should still be on Brick Sign Up Form");

            String pageLink = driver.getCurrentUrl();
            Assert.assertEquals("https://qademo.onebrick.io/", pageLink,"User should still be on https://qademo.onebrick.io/");

            Thread.sleep(2000);
        }

        @Test
        public void TC25_EmptyConfirmPW() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");

            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement cp = driver.findElement(By.cssSelector("label#confirm_password-error"));
            Assert.assertEquals("Please enter a password", cp.getText(), "Wrong Error Message 5");

            //note: cannot test phone number validation error because the label does not exist in the DOM
            
            String pageTitle = driver.getTitle();
            Assert.assertEquals("Brick Sign Up Form", pageTitle,"User should still be on Brick Sign Up Form");

            String pageLink = driver.getCurrentUrl();
            Assert.assertEquals("https://qademo.onebrick.io/", pageLink,"User should still be on https://qademo.onebrick.io/");

            Thread.sleep(2000);
        }

        @Test
        public void TC26_InvalidConfirmPW() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");

            driver.findElement(By.cssSelector("input#password")).sendKeys("123456");
            driver.findElement(By.cssSelector("input#confirm_password")).sendKeys("111111");
            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement cp = driver.findElement(By.cssSelector("label#confirm_password-error"));
            Assert.assertEquals("Password need to match", cp.getText(), "Wrong Error Message 5a");

            //note: cannot test phone number validation error because the label does not exist in the DOM
            
            String pageTitle = driver.getTitle();
            Assert.assertEquals("Brick Sign Up Form", pageTitle,"User should still be on Brick Sign Up Form");

            String pageLink = driver.getCurrentUrl();
            Assert.assertEquals("https://qademo.onebrick.io/", pageLink,"User should still be on https://qademo.onebrick.io/");

            Thread.sleep(2000);
        }

        @Test
        public void TC27_RegisteringSameEmail() throws InterruptedException{
            // the email to be used = usedEmail@mail.com

            driver.get("https://qademo.onebrick.io");
            driver.findElement(By.cssSelector("input#firstName")).sendKeys("used");
            driver.findElement(By.cssSelector("input#lastName")).sendKeys("test");
            driver.findElement(By.cssSelector("input#email")).sendKeys("usedEmail@mail.com");
            driver.findElement(By.cssSelector("input#phoneNumber")).sendKeys("12345678");
            driver.findElement(By.cssSelector("input#address")).sendKeys("used address");
            driver.findElement(By.cssSelector("input#password")).sendKeys("123456");
            driver.findElement(By.cssSelector("input#confirm_password")).sendKeys("123456");
            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement errorsu = driver.findElement(By.cssSelector("#swal2-content"));
            Assert.assertEquals("Email has been taken!", errorsu.getText(), "Wrong Error Message 6");
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled")).click();

            String pageTitle = driver.getTitle();
            Assert.assertEquals("Brick Sign Up Form", pageTitle,"User should still be on Brick Sign Up Form");

            Thread.sleep(2000);
        }

        @AfterSuite
        public void end(){
            driver.close();
            driver.quit();
        }

}
