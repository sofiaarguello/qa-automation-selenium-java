package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement confirmationMessage;

    @FindBy(css = "[data-test='error']")
    private WebElement errorMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillPersonalInfo(String firstName, String lastName, String postalCode) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(postalCodeInput, postalCode);
    }

    public void clickContinue() {
        click(continueButton);
    }

    public void clickFinish() {
        click(finishButton);
    }

    public String getConfirmationMessage() {
        return getText(confirmationMessage);
    }

    public boolean isOrderComplete() {
        return driver.getCurrentUrl().contains("checkout-complete");
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
}
