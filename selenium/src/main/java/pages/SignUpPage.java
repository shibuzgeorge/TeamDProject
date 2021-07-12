package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends PageObject {

    @FindBy(id="firstname") private WebElement firstNameTextField;
    @FindBy(id="lastname") private WebElement lastNameTextField;
    @FindBy(id="address") private WebElement addressTextField;
    @FindBy(id="signup") private WebElement submitButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isInitialised() {
        return firstNameTextField.isDisplayed();
    }

    public void enterName(String firstName, String lastName) {
        this.firstNameTextField.clear();
        this.firstNameTextField.sendKeys(firstName);
        this.lastNameTextField.clear();
        this.lastNameTextField.sendKeys(lastName);
    }

    public void enterAddress(String address) {
        this.addressTextField.clear();
        this.addressTextField.sendKeys(address);
    }

    public ReceiptPage submit() {
        submitButton.click();
        return new ReceiptPage(driver);
    }
}
