import com.applitools.eyes.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by FecheteP on 2/22/2016.
 */
public class VisualTest {
    private WebDriver driver;
    private Eyes eyes;
    private static final String API_KEY = "97P12rLBwXa2fILvIRCYZpVrs9JKjEjiSWYYhCwHMViQ110";

    @BeforeMethod
    public void setup() {
        WebDriver browser = new FirefoxDriver();
        browser.manage().window().maximize();
        eyes = new Eyes();
        eyes.setApiKey(API_KEY);
        driver = eyes.open(browser, "test", "visualTest");
    }

    @Test
    public void visualTest() {
        driver.get("https://www.google.ro");
        eyes.checkWindow("Google search");
        eyes.close();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
