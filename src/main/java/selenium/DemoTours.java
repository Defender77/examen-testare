package selenium;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoTours {
    @Test
    public void test() {
        WebDriver driver = new FirefoxDriver();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait before each element
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/newtours/");
        Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");

        WebElement registerLink = driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]"));
        registerLink.click();

        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='images/mast_register.gif']")).isDisplayed());

        String firstName = "John";
        String lastName = "Doe";
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstNameInput.sendKeys(firstName);

        WebElement lastNameInput = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastNameInput.sendKeys(lastName);

        WebElement phoneInput = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneInput.sendKeys("123");

        WebElement emailInput = driver.findElement(By.xpath("//input[@name='userName']"));
        emailInput.sendKeys("test@test.com");

        WebElement address1Input = driver.findElement(By.xpath("//input[@name='address1']"));
        address1Input.sendKeys("Downing str.10");

        WebElement cityInput = driver.findElement(By.xpath("//input[@name='city']"));
        cityInput.sendKeys("Washington");

        WebElement stateInput = driver.findElement(By.xpath("//input[@name='state']"));
        stateInput.sendKeys("Columbia");

        WebElement postalCodeInput = driver.findElement(By.xpath("//input[@name='postalCode']"));
        postalCodeInput.sendKeys("14345");

        WebElement countryElement = driver.findElement(By.xpath("//select[@name='country']"));
        Select countrySelect = new Select(countryElement);
        countrySelect.selectByVisibleText("UNITED KINGDOM");

        String username = "test@test.com";
        WebElement userNameInput = driver.findElement(By.xpath("//input[@name='email']"));
        userNameInput.sendKeys(username);

        String password = "1123456";
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys(password);

        WebElement confirmPasswordInput = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
        confirmPasswordInput.sendKeys(password);

        WebElement registerButton = driver.findElement(By.xpath("//input[@name='submit']"));
        registerButton.click();


        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(
                        driver.findElement(
                                By.xpath("//b[contains(text(),'Dear')]"))));

        WebElement dearMsg = driver.findElement(By.xpath("//b[contains(text(),'Dear')]"));
        Assert.assertEquals(dearMsg.getText().trim(), "Dear " + firstName + " " +  lastName + ",");


        WebElement noteMsg = driver.findElement(By.xpath("//b[contains(text(),'Note')]"));
        Assert.assertTrue(StringUtils.contains(noteMsg.getText().trim(), username));

    }
}
