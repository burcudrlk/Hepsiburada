package Scenerios;

import Pages.HomePage;
import Pages.ProductDetailPage;
import Pages.SearchResultListingPage;
import org.junit.Test;

public class UITest extends BaseTest{


        /**
         * Seçilen üründe daha önce yapılmış yorum varsa ilk yorum için like verilir.
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

        //Aşağıdaki testler ekstradır.
        //Seçilen search keywordunde sonuç bulunamazsa, veya ürün bulunsa bile, herhangi bir yorum olmadığı durumlarda
        //kodun nasıl davrandığını gösterecek örneklerdir. Dilerseniz deneyebilirsiniz.

        /**
         * Seçilen ürün herhangi bir yorum bulundurmuyorsa, "değerlendirme bulunamadı" şeklinde döner.
         */
        @Test
        public void uiTest2() {
            new HomePage(driver)
                .search("HBV000005CW3K");

            new SearchResultListingPage(driver)
                .selectFirstProduct();

            new ProductDetailPage(driver)
                .goToReviews()
                .giveLikeToFirstReview();

    }

        /**
         * Seçilen keyword'de herhangi bir ürün sonucu gelmiyorsa, "Aratılan kelime ile ilgili sonuç bulunamamıştır." seklinde döner.
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
