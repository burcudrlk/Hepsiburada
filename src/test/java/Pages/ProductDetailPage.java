package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class ProductDetailPage extends BasePage {

    private static final By PRODUCT_REVIEWS_TAB = By.id("productReviewsTab");
    private static final By REVIEW_LIKE_BUTTON = By.xpath("//*[@id=\"hermes-voltran-comments\"]/div[3]/div[3]/div/div[1]/div[2]/div[4]/div[1]/div/div[1]/div[1]");
    private static final By REVIEW_RATE_MESSAGE = By.className("hermes-ReviewCard-module-1ZiTv");
    private static final By REVIEWS = By.xpath("//*[@class='hermes-ReviewList-module-2Ymrn']/child::node()");


    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPage goToReviews(){
        clickBy(PRODUCT_REVIEWS_TAB);
        return this;
    }

    public ProductDetailPage giveLikeToFirstReview() {

        scrollDown();

           try {
               if (driver.findElement(REVIEWS).isDisplayed()) {
                   clickBy(REVIEW_LIKE_BUTTON);

                   String reviewRateSuccessMessage = "Teşekkür Ederiz.";
                   waitForElement(REVIEW_RATE_MESSAGE);
                   String reviewRateMessage = driver.findElement(REVIEW_RATE_MESSAGE).getText();
                   assertEquals(reviewRateSuccessMessage, reviewRateMessage);

               } else {
                   throw new Exception();
               }
           }
           catch(Exception e){
               fail("Değerlendirme bulunmamaktadır.");
           }

        return this;
    }


}
