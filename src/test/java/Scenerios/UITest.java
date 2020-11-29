package Scenerios;

import Pages.HomePage;
import Pages.ProductDetailPage;
import Pages.SearchResultListingPage;
import org.junit.Test;

public class UITest extends BaseTest{


        /**
         * Example for a product with comments
         */
        @Test
        public void uiTest() {

            new HomePage(driver)
                    .search("iphone");

            new SearchResultListingPage(driver)
                    .selectFirstProduct();

            new ProductDetailPage(driver)
                    .goToReviews()
                    .giveLikeToFirstReview();

        }


        /**
         * Example for a product without comments
         */
        @Test
        public void uiTest2() {
            new HomePage(driver)
                .search("HBV00000V64MN");

            new SearchResultListingPage(driver)
                .selectFirstProduct();

            new ProductDetailPage(driver)
                .goToReviews()
                .giveLikeToFirstReview();

    }

        /**
         * Example for a search keyword returns no result
        */
        @Test
        public void uiTest3() {
            new HomePage(driver)
                    .search("gesgsdgd");

            new SearchResultListingPage(driver)
                    .selectFirstProduct();

            new ProductDetailPage(driver)
                    .goToReviews()
                    .giveLikeToFirstReview();

    }
}
