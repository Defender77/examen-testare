package selenium;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearch {
    @Test
    public void googleSearch() throws InterruptedException {
//        String driverExecutablePath = "D:\\Drivers\\chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", driverExecutablePath);
//         Create a new instance of the FireFox driver
        System.setProperty("webdriver.gecko.driver", "G:\\geckodriver-v0.29.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        FirefoxOptions options = new FirefoxOptions();
//        WebDriver driver = new ChromeDriver();
//        ChromeOptions options = new ChromeOptions();

        String selectLinkOpenInNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        options.addArguments("--start-maximized");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait before each element
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);


        driver.get("https://www.google.com");
        //or old version
//        driver.navigate().to("google.com");
        driver.getWindowHandle();


        WebElement element = driver.findElement(By.name("q"));
//        driver.findElements(By.xpath()) --- returns list of WebElements
//        driver.findElement(By.xpath())
//        driver.findElement(By.cssSelector())
//        driver.findElement(By.id())
//        and other variants

        element.sendKeys("Cheetah");
        element.submit();

        //callback function wait for event - load page


        System.out.println("Page title " + driver.getTitle());

        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver1) {
                return driver1.getTitle().toLowerCase().startsWith("cheetah");
            }
        });
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='g']//a[contains(.,'heetah')]"));
//        List<WebElement> links = driver.findElements(By.xpath( "//div//h3[not(contains(text(),'People also ask'))][contains(text(),'heetah')]"));
//                "//div//h3[not(contains(text(),'People also ask'))]//div[@class='r']//a[contains(.,'heetah')]"));
//        for one element

//        links.get(0).sendKeys(selectLinkOpenInNewTab);
//        System.out.println("Page title tab1" + driver.getTitle());
//        System.out.println("Page url tab1" + driver.getCurrentUrl());
////        add stringUtils in pom.xml
//        System.out.println("Number of cheetahs: " + StringUtils.countMatches(driver.getPageSource().toLowerCase(), "cheetah"));

        int numberOfLinks = links.size();
        for (int iLinks = 0; iLinks < numberOfLinks; iLinks++) {
            links.get(iLinks).sendKeys(selectLinkOpenInNewTab);
        }


        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (int iTabs = 0; iTabs < tabs.size(); iTabs++) {
            driver.switchTo().window(tabs.get(iTabs));
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            System.out.println("Page title  " + iTabs + " " + driver.getTitle());
            System.out.println("Page url "  + iTabs + " " +  driver.getCurrentUrl());
            System.out.println("Number of cheetahs: on "  +  driver.getTitle() + "   "  + StringUtils.countMatches(driver.getPageSource().toLowerCase(), "cheetah"));
        }
        System.out.println("numberOfLinks" + numberOfLinks);

        Thread.sleep(30000);
        driver.quit();
    }
}
