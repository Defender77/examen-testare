package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPOM {
    protected WebDriver driver;
    public AbstractPOM(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }
}
