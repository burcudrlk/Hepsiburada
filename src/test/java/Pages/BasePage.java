package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickBy(By by){
        WebDriverWait waiter = new WebDriverWait(driver, 30);
        WebElement element = waiter.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }

    public void setByXpath(By by, String value){
        WebDriverWait waiter = new WebDriverWait(driver, 30);
        WebElement element = waiter.until(ExpectedConditions.visibilityOfElementLocated(by));

        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void scrollDown(){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("scroll(0, 750);");
    }

    public void waitForElement(By by){
        WebDriverWait waiter = new WebDriverWait(driver, 30);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public void waitUrlToBe(String value){
        WebDriverWait waiter = new WebDriverWait(driver, 30);
        waiter.until(ExpectedConditions.urlToBe(value));

    }

}
