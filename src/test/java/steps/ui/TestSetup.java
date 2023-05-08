package steps.ui;

import com.codeborne.selenide.WebDriverRunner;
import core.EnvContainer;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.browserVersion;
import static core.TestScenario.getTestScenario;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.parseBoolean;
import static utility.PropertiesLoader.tryGetPropertyOrDefault;

public class TestSetup {

    private final DesiredCapabilities capabilities = new DesiredCapabilities();


    private final static String DEFAULT_BROWSER_WIDTH = "1920";
    private final static String DEFAULT_BROWSER_HEIGHT = "1080";

    private final static String WIDTH = tryGetPropertyOrDefault("browserWidth", DEFAULT_BROWSER_WIDTH);
    private final static String HEIGHT = tryGetPropertyOrDefault("browserHeight", DEFAULT_BROWSER_HEIGHT);
    protected final static String REGRESSION_SUITE = "regression";
    protected final static String SMOKE = "smoke";
    protected final static String LOGIN = "login";
    protected final static String LAUNCHES_SUITE = "launches";
    protected final static String BUG = "bug";

    //@BeforeMethod(alwaysRun = true)
    @Before
    public void setup() {

        browser = tryGetPropertyOrDefault("browser", "chrome");
        browserVersion = tryGetPropertyOrDefault("browserVersion", "");

        switch (browser) {
            case CHROME: {
                WebDriverRunner.setWebDriver(createLocalChromeDriver(capabilities));
                break;
            }
            case FIREFOX: {
                WebDriverRunner.setWebDriver(createLocalFirefoxDriver(capabilities));
            }
        }
        getTestScenario().setEnvironment(new EnvContainer());
    }

    //@AfterMethod(alwaysRun = true)
    @After
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
        getTestScenario().removeEnvironment();
    }

    private WebDriver createLocalChromeDriver(DesiredCapabilities capabilities) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--window-size=" + WIDTH + "," + HEIGHT);
        if (parseBoolean(tryGetPropertyOrDefault("headlessRun", FALSE.toString()))) {
            chromeOptions.setHeadless(true);
        }
        chromeOptions.merge(capabilities);
        return new ChromeDriver(chromeOptions);
    }

    private WebDriver createLocalFirefoxDriver(DesiredCapabilities capabilities) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (parseBoolean(tryGetPropertyOrDefault("headless", FALSE.toString()))) {
            firefoxOptions.setHeadless(true);
        }
        firefoxOptions.merge(capabilities);
        return new FirefoxDriver(firefoxOptions);
    }
}
