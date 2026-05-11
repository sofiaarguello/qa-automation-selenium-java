package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class InventoryPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(css = ".inventory_item button")
    private List<WebElement> addToCartButtons;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public boolean isOnInventoryPage() {
        return driver.getCurrentUrl().contains("/inventory");
    }

    public int getInventoryItemCount() {
        return inventoryItems.size();
    }

    public void addFirstItemToCart() {
        click(addToCartButtons.get(0));
    }

    public void addItemToCart(int index) {
        click(addToCartButtons.get(index));
    }

    public String getCartCount() {
        try {
            return getText(cartBadge);
        } catch (Exception e) {
            return "0";
        }
    }

    public void goToCart() {
        click(cartIcon);
    }

    public void logout() {
        click(menuButton);
        click(logoutLink);
    }
}
