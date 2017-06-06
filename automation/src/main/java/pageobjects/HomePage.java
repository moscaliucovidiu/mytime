package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Ovidiu Moscaliuc on 6/5/2017.
 *
 * Page object class which contains selectors for mytime home page.
 *
 */
public class HomePage extends PageFactory  {


        public HomePage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        @FindBy(css="div.form-overlay.hidden-xs form[id='search-form'] input[id='search-query'][name='search']")
        public WebElement searchInput;

        @FindBy(css="div.form-overlay.hidden-xs form[id='search-form'] input[id='search-location'][name='location']")
        public WebElement searchLocationInput;

        @FindBy(css="div.search-button button")
        public WebElement searchButton;

        @FindBy(css ="ul li a[tabindex='-1']")
        public List<WebElement> searchResultItems;

        @FindBy(css ="ul[style*='z-index: 800'] li a[tabindex='-1']")
        public List<WebElement> searchLocationItems;

        @FindBy(css ="h2.business-name a")
        public List<WebElement> searchBusinessResultItems ;

    }


