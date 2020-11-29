package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;


public class SearchResultListingPage extends BasePage {

    private static final By FIRST_PRODUCT = By.xpath("//*[@class='product-list results-container do-flex list']/li");


    public SearchResultListingPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultListingPage selectFirstProduct() {

        String pageSource = driver.getPageSource();

        if (pageSource.contains("sonuç bulunamamıştır")){
            fail("Aratılan kelime ile ilgili sonuç bulunamamıştır.");
        }
        else {
            clickBy(FIRST_PRODUCT);
        }
        return this;
    }

}
