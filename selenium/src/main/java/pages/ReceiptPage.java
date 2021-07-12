package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReceiptPage extends PageObject {

    @FindBy(tagName = "h1") private WebElement header;
    @FindBy(tagName = "p") private WebElement paragraph;

    public ReceiptPage(WebDriver driver) {
        super(driver);
    }

    public String confirmationHeader(){
        return header.getText();
    }

    public String confirmationParagraph(){
        return paragraph.getText();
    }
}
