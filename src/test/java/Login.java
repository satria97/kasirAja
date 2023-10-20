import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    @Test
    public void success_login() throws InterruptedException {
        WebDriver driver;
        String baseUrl = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();

        // apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        // Assert login page
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(), 'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert, "hai, kasirAja");

        // input email
        driver.findElement(By.id("email")).sendKeys("admin@sel.com");
        // input password
        driver.findElement(By.id("password")).sendKeys("test321");
        // click login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String successLogin = driver.findElement(By.xpath("//dt[contains(text(),'Sel Ventures')]")).getText();
        Assert.assertEquals(successLogin, "Sel Ventures");
    }

    @Test
    public void failed_login() {
        WebDriver driver;
        String baseUrl = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        // Assert login page
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(), 'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert, "hai, kasirAja");

        // input email
        driver.findElement(By.id("email")).sendKeys("admin@sel.com");
        // input password
        driver.findElement(By.id("password")).sendKeys("123456");
        // click login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String errorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(errorLogin, "Kredensial yang Anda berikan salah");
    }
}
