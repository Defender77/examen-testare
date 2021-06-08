package pom;

import core.AbstractPOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Login extends AbstractPOM {
    public Login(WebDriver driver){
        super(driver);
    }

//    WebElement loginElement= driver.findElement(By.xpath("//div[@class=\"login__title\"]"));
//    WebElement usernameInput = driver.findElement(By.xpath("//input[@name='login']"));
//    WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
//    WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));

    String loginElementStr = "//div[@class=\"login__title\"]";
    String usernameInputStr = "//input[@name='login']";
    String passwordInputStr= "//input[@name='password']";
    String buttonStr = "//button[@type='submit']";

    public void checkLoginElementPresence(){
        WebElement loginElement = driver.findElement(By.xpath(loginElementStr));
        Assert.assertTrue(loginElement.isDisplayed());
    }
    public void completeUsername(String username){
        WebElement usernameInput = driver.findElement(By.xpath(usernameInputStr));
        usernameInput.sendKeys(username);
    }

    public void completePassword(String password){
        WebElement usernameInput = driver.findElement(By.xpath(passwordInputStr));
        usernameInput.sendKeys(password);
    }

    public void clickLogin(){
        WebElement button = driver.findElement(By.xpath(buttonStr));
        button.click();
    }

    By loginElementBy = By.xpath("//div[@class=\"login__title\"]");
    By usernameInputBy = By.xpath("//input[@name='login']");
    By passwordInputBy= By.xpath("//input[@name='password']");
    By buttonBy = By.xpath("//button[@type='submit']");
    public void checkLoginElementPresenceBy(){
        WebElement loginElement = driver.findElement(loginElementBy);
        Assert.assertTrue(loginElement.isDisplayed());
    }
    public void completeUsernameBy(String username){
        WebElement usernameInput = driver.findElement(usernameInputBy);
        usernameInput.sendKeys(username);
    }

    public void completePasswordBy(String password){
        WebElement usernameInput = driver.findElement(passwordInputBy);
        usernameInput.sendKeys(password);
    }

    public void clickLoginBy(){
        WebElement button = driver.findElement(buttonBy);
        button.click();
    }

    @FindBy(xpath = "//div[@class=\\\"login__title\\\"]")
    public WebElement loginElement;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement usernameInputAnnotations;

    public void completeUsernameAnnotations(String username){
        usernameInputAnnotations.sendKeys(username);
    }

}
