package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Ovidiu Moscaliuc on 6/6/2017.
 *
 * Page object class which contains selectors used for businesses detailed page.
 *
 */
public class BusinessDetailedPage extends PageFactory {

    public BusinessDetailedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css ="div div.panel-title-button a")
    public List<WebElement> bookHaircutButtons ;

}
