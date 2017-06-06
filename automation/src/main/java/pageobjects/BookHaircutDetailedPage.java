package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Ovidiu Moscaliuc on 6/6/2017.
 *
 * Page object class which contains selectors used for book haircut detailed page.
 *
 */
public class BookHaircutDetailedPage extends PageFactory {

    public BookHaircutDetailedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css ="span.time")
    public List<WebElement> bookTimingOptions ;

}
