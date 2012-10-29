import org.testng.annotations.*;

import com.thoughtworks.selenium.DefaultSelenium;

public class BaseTest {

	protected DefaultSelenium selenium = null;

	@BeforeClass(alwaysRun=true)
	public void setUp() {
		selenium = new DefaultSelenium("127.0.0.1", 4444, "*firefox", "https://github.com/");
		selenium.start();
		selenium.open("/");
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		selenium.stop();
	}

}