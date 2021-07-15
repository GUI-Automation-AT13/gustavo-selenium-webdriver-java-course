package base.login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage= homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        secureAreaPage.getAlertText();
        //assertEquals(secureAreaPage.getAlertText(),
//                "You logged into a secure area! x",
//                "Alert text is incorrect");
        assertTrue(secureAreaPage.getAlertText().contains(
                "You logged into a secure area!"),
                "Alert text is incorrect");
    }
}

