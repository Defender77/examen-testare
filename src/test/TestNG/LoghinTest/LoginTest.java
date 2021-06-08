package TestNG.LoghinTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\examen\\geckodriver-v0.29.0-win64\\geckodriver.exe");
        String baseUrl = "https://simpalsid.com/user/login"; //https://simpalsid.com/user/register
        String existingUser = "username";
        String userPass = RandomStringUtils.randomAlphanumeric(6);
        WebDriver driver = new FirefoxDriver();
//        FirefoxOptions options = new FirefoxOptions();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        WebElement loginElement= driver.findElement(By.xpath("//div[@class=\"login__title\"]"));
        ////div/input[@name="email"]
        Assert.assertTrue(loginElement.isDisplayed());
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='login']"));
        usernameInput.sendKeys(existingUser);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys(userPass);
        ////input[@id='agree-rules']
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'username')]")));
        driver.close();
        driver.quit();

    }

}
