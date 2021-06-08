package LoghinTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class RegisterTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\examen\\geckodriver-v0.29.0-win64\\geckodriver.exe");
        String baseUrl = "https://simpalsid.com/user/register";
        String newUserName = "username" + RandomStringUtils.randomAlphabetic(2);
        String loginEMailText = "mail+"+ RandomStringUtils.randomNumeric(3) + "@gmil.com";
        String userPass = RandomStringUtils.randomAlphanumeric(6);
        WebDriver driver = new FirefoxDriver();
//        FirefoxOptions options = new FirefoxOptions();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        WebElement loginElement = driver.findElement(By.xpath("//div[@class=\"login__title\"]"));
        Assert.assertTrue(loginElement.isDisplayed());
        WebElement loginEMail = driver.findElement(By.xpath("//div/input[@name=\"email\"]"));
        loginEMail.sendKeys(loginEMailText);
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='login']"));
        usernameInput.sendKeys(newUserName);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys(userPass);
        WebElement rulesCheckbox = driver.findElement(By.xpath("//input[@id='agree-rules']"));
        rulesCheckbox.isSelected();
        rulesCheckbox.click();
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'sent')]")));
        driver.close();
        driver.quit();
    }
}
