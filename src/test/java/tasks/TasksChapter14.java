package tasks;

import base.BaseTests;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class TasksChapter14 extends BaseTests {

    @Test
    public void testDeleteCookie(){

        Cookie cookie = new Cookie.Builder("optimizelyBuckets", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
        driver.manage().deleteCookie(cookie);
        assertTrue(driver.manage().getCookieNamed(cookie.getName()) == null);
    }
}
