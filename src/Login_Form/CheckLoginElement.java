package Login_Form;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class CheckLoginElement {

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
        public void TC01_displayLoginElements() throws InterruptedException{
            driver.get("https://qademo.onebrick.io/login");
            
            driver.findElement(By.cssSelector("input#your_email")).isDisplayed();
            driver.findElement(By.cssSelector("input#password")).isDisplayed();
            driver.findElement(By.cssSelector("input[name='login']")).isDisplayed();
            driver.findElement(By.linkText("Forgot Password?")).isDisplayed();
            driver.findElement(By.linkText("Sign Up")).isDisplayed();
            Thread.sleep(2000);
        }

        @AfterSuite
        public void end(){
            driver.close();
            driver.quit();
        }


}
