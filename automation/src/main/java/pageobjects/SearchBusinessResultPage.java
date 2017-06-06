package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Ovidiu Moscaliuc on 6/5/2017.
 *
 * Page object class which contains selectors used search results after searching in home page.
 *
 */
public class SearchBusinessResultPage extends PageFactory {

    public SearchBusinessResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css ="h2.business-name a")
    public List<WebElement> searchBusinessResultItems ;

}
