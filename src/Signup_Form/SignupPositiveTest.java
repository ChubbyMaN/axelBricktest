package Signup_Form;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

public class SignupPositiveTest {

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
        public void TC28_SuccessRegister() throws InterruptedException{
            // the email to be used = usedEmail@mail.com

            driver.get("https://qademo.onebrick.io");
            driver.findElement(By.cssSelector("input#firstName")).sendKeys("axel00"+ Integer.toString(((new Random().nextInt(10))+1)));
            driver.findElement(By.cssSelector("input#lastName")).sendKeys("test"+ Integer.toString(((new Random().nextInt(10))+1)));
            driver.findElement(By.cssSelector("input#email")).sendKeys("EmailTest00"+ Integer.toString(((new Random().nextInt(100))+1)) + "@mail.com");
            driver.findElement(By.cssSelector("input#phoneNumber")).sendKeys("12345678"+ Integer.toString(((new Random().nextInt(10))+1)));
            driver.findElement(By.cssSelector("input#address")).sendKeys("used address00"+ Integer.toString(((new Random().nextInt(10))+1)));
            driver.findElement(By.cssSelector("input#password")).sendKeys("123456");
            driver.findElement(By.cssSelector("input#confirm_password")).sendKeys("123456");
            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement successMsg = driver.findElement(By.cssSelector("h2#swal2-title"));
            Assert.assertEquals("Success", successMsg.getText(), "Wrong Error Message 7");

            WebElement successConfirm = driver.findElement(By.cssSelector("div#swal2-content"));
            Assert.assertEquals("Check your email to confirm your registration", successConfirm.getText(), "Wrong Error Message 8");
            Thread.sleep(2000);

            driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled")).click();

            String pageTitle = driver.getTitle();
            Assert.assertEquals("Brick Sign Up Form", pageTitle,"User should still be on Brick Sign Up Form");

            Thread.sleep(2000);
        }

        @Test
        public void TC29_PhoneCodeDropdown() throws InterruptedException{
            // the email to be used = usedEmail@mail.com

            driver.get("https://qademo.onebrick.io");
        
            driver.findElement(By.cssSelector("[role='combobox']")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("li#iti-0__item-sg-preferred")).click();
            Thread.sleep(2000);

            driver.findElement(By.cssSelector("[role='combobox']")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("li#iti-0__item-my-preferred")).click();
            Thread.sleep(2000);

            driver.findElement(By.cssSelector("[role='combobox']")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector("li#iti-0__item-ph-preferred")).click();
            Thread.sleep(2000);

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
