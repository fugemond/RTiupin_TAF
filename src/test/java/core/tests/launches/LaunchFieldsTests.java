package core.tests.launches;

import core.TestSetup;
import core.data.DataProviders;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static site.pages.LaunchesPage.LaunchPageElements.*;
import static site.pages.LoginPage.LoginPageElements.*;
import static site.pages.PagesNaming.*;
import static site.pages.blocks.CommonPanelBlock.CommonPanelBlockElements.LAUNCHES_TAB;
import static steps.ui.AssertionSteps.*;
import static steps.ui.StepsUI.*;
import static steps.ui.StepsUI.CLICK_ON_ELEMENT;

@Log4j2
public class LaunchFieldsTests extends TestSetup {

    @Test(groups = {REGRESSION_SUITE, LAUNCHES_SUITE},
            dataProvider = "launchesName",
            dataProviderClass = DataProviders.class)
    @Story("TAF-01")
    @Description("Check launch owner name")
    public void launchesNamesTest(String launchNumber, String launchName) {
        OPEN_PAGE_BY_LINK(LOGIN_PAGE, "baseUrl");
        PAGE_IS_OPENED(LOGIN_PAGE);
        ENTER_ENCRYPTED_VALUE_INTO_FIELD(LOGIN_FILED, "rpLogin");
        ENTER_ENCRYPTED_VALUE_INTO_FIELD(PASSWORD_FIELD, "rpPassword");
        CLICK_ON_ELEMENT(SIGN_IN_BUTTON);
        PAGE_IS_OPENED(COMMON_PANEL_BLOCK);
        PAGE_IS_LOADED();
        CLICK_ON_ELEMENT(LAUNCHES_TAB);
        PAGE_IS_OPENED(LAUNCHES_PAGE);
        ASSERT_THAT_ELEMENT_BY_PART_CONTAINS_VALUE(LAUNCH_NAME, launchNumber, launchName);
    }

    @Test(groups = {REGRESSION_SUITE, LAUNCHES_SUITE},
            dataProvider = "launchesRunTotal",
            dataProviderClass = DataProviders.class)
    @Story("TAF-01")
    @Description("Check launch total tests run")
    public void launchesTotalRunTest(String launchNumber, String totalTestsRun) {
        OPEN_PAGE_BY_LINK(LOGIN_PAGE, "baseUrl");
        PAGE_IS_OPENED(LOGIN_PAGE);
        ENTER_ENCRYPTED_VALUE_INTO_FIELD(LOGIN_FILED, "rpLogin");
        ENTER_ENCRYPTED_VALUE_INTO_FIELD(PASSWORD_FIELD, "rpPassword");
        CLICK_ON_ELEMENT(SIGN_IN_BUTTON);
        PAGE_IS_OPENED(COMMON_PANEL_BLOCK);
        PAGE_IS_LOADED();
        CLICK_ON_ELEMENT(LAUNCHES_TAB);
        PAGE_IS_OPENED(LAUNCHES_PAGE);
        ASSERT_THAT_ELEMENT_BY_PART_CONTAINS_VALUE(LAUNCH_TOTAL, launchNumber, totalTestsRun);
    }

    @Test(groups = {REGRESSION_SUITE, LAUNCHES_SUITE},
            dataProvider = "launchesRunPassed",
            dataProviderClass = DataProviders.class)
    @Story("TAF-01")
    @Description("Check launch passed tests run")
    public void launchesPassedRunTest(String launchNumber, String totalTestsRun) {
        OPEN_PAGE_BY_LINK(LOGIN_PAGE, "baseUrl");
        PAGE_IS_OPENED(LOGIN_PAGE);
        ENTER_ENCRYPTED_VALUE_INTO_FIELD(LOGIN_FILED, "rpLogin");
        ENTER_ENCRYPTED_VALUE_INTO_FIELD(PASSWORD_FIELD, "rpPassword");
        CLICK_ON_ELEMENT(SIGN_IN_BUTTON);
        PAGE_IS_OPENED(COMMON_PANEL_BLOCK);
        PAGE_IS_LOADED();
        CLICK_ON_ELEMENT(LAUNCHES_TAB);
        PAGE_IS_OPENED(LAUNCHES_PAGE);
        ASSERT_THAT_ELEMENT_BY_PART_CONTAINS_VALUE(LAUNCH_PASSED, launchNumber, totalTestsRun);
    }
}
