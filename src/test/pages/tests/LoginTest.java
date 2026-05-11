package tests;

import pages.InventoryPage;
import pages.LoginPage;
import utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.open();
    }

    @Test(description = "Login exitoso con credenciales válidas")
    public void testSuccessfulLogin() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isOnInventoryPage(), "Debería estar en la página de inventario");
        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
    }

    @Test(description = "Login fallido con contraseña incorrecta")
    public void testLoginWithWrongPassword() {
        loginPage.login("standard_user", "wrong_password");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Debería mostrarse un mensaje de error");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }

    @Test(description = "Login fallido con usuario vacío")
    public void testLoginWithEmptyUsername() {
        loginPage.login("", "secret_sauce");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Debería mostrarse un mensaje de error");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"));
    }

    @Test(description = "Login fallido con contraseña vacía")
    public void testLoginWithEmptyPassword() {
        loginPage.login("standard_user", "");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Debería mostrarse un mensaje de error");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"));
    }

    @Test(description = "Login con usuario bloqueado")
    public void testLockedOutUser() {
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Debería mostrarse un mensaje de error");
        Assert.assertTrue(loginPage.getErrorMessage().contains("locked out"));
    }

    @Test(description = "Logout exitoso")
    public void testLogout() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isOnInventoryPage());
        inventoryPage.logout();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/"),
                "Debería redirigir al login después del logout");
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
