import org.testng.Assert;
import org.testng.annotations.*;

import com.thoughtworks.selenium.DefaultSelenium;

public class LoginTests extends BaseTest {

	@Test(groups={"positive","login"})
	public void testSuccessfulLogin() {
        login("vchethan", "password1", selenium);
        Assert.assertTrue(selenium.isElementPresent("userbox"),"The user box was not found indicating the sign in failed");       
	}
	
	@Test(groups={"negative","login"})
	public void testInvalidLogin() {
        login("vchethan","password", selenium);
        Assert.assertTrue(selenium.isTextPresent("Incorrect username or password."));
	}
	
	public void login(String userName, String password, DefaultSelenium selenium) {
		selenium.click("link=Sign in");
        selenium.waitForPageToLoad("30000");
        selenium.type("login_field", userName);
        selenium.type("password",password);
        selenium.click("xpath=//input[@name='commit' and @type='submit']");
        selenium.waitForPageToLoad("30000");
	}
}
