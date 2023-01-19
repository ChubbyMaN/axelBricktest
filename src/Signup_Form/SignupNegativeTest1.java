package Signup_Form;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

public class SignupNegativeTest1 {

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
        public void TC13_NoInput() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");

            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement fn = driver.findElement(By.cssSelector("label#firstName-error"));
            Assert.assertEquals("Please enter a firstname", fn.getText(), "Wrong Error Message 1");

            WebElement ln = driver.findElement(By.cssSelector("label#lastName-error"));
            Assert.assertEquals("Please enter a lastname", ln.getText(), "Wrong Error Message 2");

            WebElement em = driver.findElement(By.cssSelector("label#email-error"));
            Assert.assertEquals("Please provide an email", em.getText(), "Wrong Error Message 3");

            WebElement pw = driver.findElement(By.cssSelector("label#password-error"));
            Assert.assertEquals("Please enter a password", pw.getText(), "Wrong Error Message 4");

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
        public void TC14_OnlyFirstName() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");

            driver.findElement(By.cssSelector("input#firstName")).sendKeys("Alex");

            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement ln = driver.findElement(By.cssSelector("label#lastName-error"));
            Assert.assertEquals("Please enter a lastname", ln.getText(), "Wrong Error Message 2");

            WebElement em = driver.findElement(By.cssSelector("label#email-error"));
            Assert.assertEquals("Please provide an email", em.getText(), "Wrong Error Message 3");

            WebElement pw = driver.findElement(By.cssSelector("label#password-error"));
            Assert.assertEquals("Please enter a password", pw.getText(), "Wrong Error Message 4");

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
        public void TC15_OnlyLastName() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");


            driver.findElement(By.cssSelector("input#lastName")).sendKeys("Matthew");

            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement fn = driver.findElement(By.cssSelector("label#firstName-error"));
            Assert.assertEquals("Please enter a firstname", fn.getText(), "Wrong Error Message 1");

            WebElement em = driver.findElement(By.cssSelector("label#email-error"));
            Assert.assertEquals("Please provide an email", em.getText(), "Wrong Error Message 3");

            WebElement pw = driver.findElement(By.cssSelector("label#password-error"));
            Assert.assertEquals("Please enter a password", pw.getText(), "Wrong Error Message 4");

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
        public void TC16_OnlyEmail() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");

            driver.findElement(By.cssSelector("input#email")).sendKeys("alextest@mail.com");

            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement fn = driver.findElement(By.cssSelector("label#firstName-error"));
            Assert.assertEquals("Please enter a firstname", fn.getText(), "Wrong Error Message 1");

            WebElement ln = driver.findElement(By.cssSelector("label#lastName-error"));
            Assert.assertEquals("Please enter a lastname", ln.getText(), "Wrong Error Message 2");

            WebElement pw = driver.findElement(By.cssSelector("label#password-error"));
            Assert.assertEquals("Please enter a password", pw.getText(), "Wrong Error Message 4");

            WebElement cp = driver.findElement(By.cssSelector("label#confirm_password-error"));
            Assert.assertEquals("Please enter a password", cp.getText(), "Wrong Error Message 5");

    //note: cannot test phone number validation error because the label does not exist in the DOM & reported in the bug report
            
            String pageTitle = driver.getTitle();
            Assert.assertEquals("Brick Sign Up Form", pageTitle,"User should still be on Brick Sign Up Form");

            String pageLink = driver.getCurrentUrl();
            Assert.assertEquals("https://qademo.onebrick.io/", pageLink,"User should still be on https://qademo.onebrick.io/");

            Thread.sleep(2000);
        }

        @Test
        public void TC17_OnlyPhoneNumber() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");

            driver.findElement(By.cssSelector("input#phoneNumber")).sendKeys("12345678");

            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement fn = driver.findElement(By.cssSelector("label#firstName-error"));
            Assert.assertEquals("Please enter a firstname", fn.getText(), "Wrong Error Message 1");

            WebElement ln = driver.findElement(By.cssSelector("label#lastName-error"));
            Assert.assertEquals("Please enter a lastname", ln.getText(), "Wrong Error Message 2");

            WebElement em = driver.findElement(By.cssSelector("label#email-error"));
            Assert.assertEquals("Please provide an email", em.getText(), "Wrong Error Message 3");

            WebElement pw = driver.findElement(By.cssSelector("label#password-error"));
            Assert.assertEquals("Please enter a password", pw.getText(), "Wrong Error Message 4");

            WebElement cp = driver.findElement(By.cssSelector("label#confirm_password-error"));
            Assert.assertEquals("Please enter a password", cp.getText(), "Wrong Error Message 5");
            
            String pageTitle = driver.getTitle();
            Assert.assertEquals("Brick Sign Up Form", pageTitle,"User should still be on Brick Sign Up Form");

            String pageLink = driver.getCurrentUrl();
            Assert.assertEquals("https://qademo.onebrick.io/", pageLink,"User should still be on https://qademo.onebrick.io/");

            Thread.sleep(2000);
        }

        @Test
        public void TC18_NoAddress() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");

            driver.findElement(By.cssSelector("input#address")).sendKeys("address alam");

            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement fn = driver.findElement(By.cssSelector("label#firstName-error"));
            Assert.assertEquals("Please enter a firstname", fn.getText(), "Wrong Error Message 1");

            WebElement ln = driver.findElement(By.cssSelector("label#lastName-error"));
            Assert.assertEquals("Please enter a lastname", ln.getText(), "Wrong Error Message 2");

            WebElement em = driver.findElement(By.cssSelector("label#email-error"));
            Assert.assertEquals("Please provide an email", em.getText(), "Wrong Error Message 3");

            WebElement pw = driver.findElement(By.cssSelector("label#password-error"));
            Assert.assertEquals("Please enter a password", pw.getText(), "Wrong Error Message 4");

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
        public void TC19_OnlyPassword() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");

            driver.findElement(By.cssSelector("input#password")).sendKeys("123456");;
            
            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement fn = driver.findElement(By.cssSelector("label#firstName-error"));
            Assert.assertEquals("Please enter a firstname", fn.getText(), "Wrong Error Message 1");

            WebElement ln = driver.findElement(By.cssSelector("label#lastName-error"));
            Assert.assertEquals("Please enter a lastname", ln.getText(), "Wrong Error Message 2");

            WebElement em = driver.findElement(By.cssSelector("label#email-error"));
            Assert.assertEquals("Please provide an email", em.getText(), "Wrong Error Message 3");

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
        public void TC20_OnlyConfirmPW() throws InterruptedException{
            driver.get("https://qademo.onebrick.io");

            driver.findElement(By.cssSelector("input#confirm_password")).sendKeys("123456");

            driver.findElement(By.cssSelector(".register")).click();
            Thread.sleep(3000);

            WebElement fn = driver.findElement(By.cssSelector("label#firstName-error"));
            Assert.assertEquals("Please enter a firstname", fn.getText(), "Wrong Error Message 1");

            WebElement ln = driver.findElement(By.cssSelector("label#lastName-error"));
            Assert.assertEquals("Please enter a lastname", ln.getText(), "Wrong Error Message 2");

            WebElement em = driver.findElement(By.cssSelector("label#email-error"));
            Assert.assertEquals("Please provide an email", em.getText(), "Wrong Error Message 3");

            WebElement pw = driver.findElement(By.cssSelector("label#password-error"));
            Assert.assertEquals("Please enter a password", pw.getText(), "Wrong Error Message 4");

            //note: cannot test phone number validation error because the label does not exist in the DOM
            
            String pageTitle = driver.getTitle();
            Assert.assertEquals("Brick Sign Up Form", pageTitle,"User should still be on Brick Sign Up Form");

            String pageLink = driver.getCurrentUrl();
            Assert.assertEquals("https://qademo.onebrick.io/", pageLink,"User should still be on https://qademo.onebrick.io/");

            Thread.sleep(2000);
        }

        @AfterSuite
        public void end(){
            driver.close();
            driver.quit();
        }

}
