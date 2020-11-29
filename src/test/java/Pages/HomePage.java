package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    private static final By SEARCH_BUTTON = By.className("SearchBoxOld-buttonContainer");
    private static final By SEARCH_BOX = By.xpath("//*[@id=\"SearchBoxOld\"]/div/div/div[1]/div[2]/input");



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage search(String keyword) {
        setByXpath(SEARCH_BOX,keyword);
        clickBy(SEARCH_BUTTON);


        String expectedSearchUrl = "https://www.hepsiburada.com/ara?q="+keyword;
        waitUrlToBe(expectedSearchUrl);

        return this;
    }
}
