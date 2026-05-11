package tests;

import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PurchaseFlowTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(description = "Agregar producto al carrito y verificar badge")
    public void testAddProductToCart() {
        Assert.assertTrue(inventoryPage.isOnInventoryPage());
        inventoryPage.addFirstItemToCart();
        Assert.assertEquals(inventoryPage.getCartCount(), "1", "El carrito debería tener 1 producto");
    }

    @Test(description = "Flujo completo de compra")
    public void testCompletePurchaseFlow() {
        inventoryPage.addFirstItemToCart();
        Assert.assertEquals(inventoryPage.getCartCount(), "1");

        inventoryPage.goToCart();
        Assert.assertTrue(cartPage.isOnCartPage(), "Debería estar en la página del carrito");
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "El carrito debería tener 1 item");

        cartPage.clickCheckout();

        checkoutPage.fillPersonalInfo("Sofia", "Arguello", "2000");
        checkoutPage.clickContinue();

        checkoutPage.clickFinish();
        Assert.assertTrue
