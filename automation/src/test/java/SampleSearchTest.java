import org.junit.Test;
import pageobjects.BookHaircutDetailedPage;
import pageobjects.BusinessDetailedPage;
import pageobjects.HomePage;
import pageobjects.SearchBusinessResultPage;
import util.GenericTestCase;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Ovidiu Moscaliuc on 6/5/2017.
 *
 * This test class verifies that end user can search haircuts in seattle wa
 * and then he has more than 20 options presented , he chooses first option
 * and then he can see at least 10 time slots available
 *
 */
public class SampleSearchTest extends GenericTestCase {

    @Test
    public void checkSearchHaircutWorksCorrect() {
        HomePage homePage = new HomePage(driver);
        SearchBusinessResultPage searchBusinessResultPage = new SearchBusinessResultPage(driver);
        BusinessDetailedPage businessDetailedPage = new BusinessDetailedPage(driver);
        BookHaircutDetailedPage bookHaircutDetailedPage = new BookHaircutDetailedPage(driver);
        homePage.searchInput.sendKeys("haircut");
        homePage.searchResultItems.get(0).click();
        homePage.searchLocationInput.clear();
        homePage.searchLocationInput.sendKeys("seattle, wa");
        homePage.searchLocationItems.get(1).click();
        homePage.searchButton.click();
        assertTrue(searchBusinessResultPage.searchBusinessResultItems.size()>=20);
        searchBusinessResultPage.searchBusinessResultItems.get(0).click();
        businessDetailedPage.bookHaircutButtons.get(0).click();
        assertTrue(bookHaircutDetailedPage.bookTimingOptions.size()>=10);


    }

}
