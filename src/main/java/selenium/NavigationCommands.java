package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationCommands {
    public static void main(String[] args) {
        // Create a new instance of the FireFox driver
        System.setProperty("webdriver.gecko.driver", "G:\\geckodriver-v0.29.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        // Open ToolsQA web site
        String appUrl = "http://www.DemoQA.com";
        driver.get(appUrl);

        // Click on Registration link
//        .//*[@class="category-cards"]
//        .//*[@class="category-cards"]//*[.="Elements"]
//        .//*[@class="card mt-4 top-card"]//.[.="Elements"]
//        .//*[contains(text(),"Elem")]
        driver.findElement(By.xpath(".//*[@class=\"category-cards\"]//*[.=\"Elements\"]")).click();

        // Go back to Home Page
        driver.navigate().back();

        // Go forward to Registration page
        driver.navigate().forward();

        // Go back to Home page
        driver.navigate().to(appUrl);

        // Refresh browser
        driver.navigate().refresh();

        // Close browser

        System.out.println("Closing browser");
        driver.close();
    }
}
