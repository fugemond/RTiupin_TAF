package core.tests.launches;

import steps.ui.TestSetup;
import core.data.DataProviders;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j2;
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
        OPEN_PAGE_BY_LINK(LOGIN_PAGE.getPageName(), "baseUrl");
        PAGE_IS_OPENED(LOGIN_PAGE.getPageName());
        ENTER_ENCRYPTED_VALUE_INTO_FIELD(LOGIN_FILED.getElementName(), "rpLogin");
        ENTER_ENCRYPTED_VALUE_INTO_FIELD(PASSWORD_FIELD.getElementName(), "rpPassword");
        CLICK_ON_ELEMENT(SIGN_IN_BUTTON.getElementName());
        PAGE_IS_OPENED(COMMON_PANEL_BLOCK.getPageName());
        PAGE_IS_LOADED();
        CLICK_ON_ELEMENT(LAUNCHES_TAB.getElementName());
        PAGE_IS_OPENED(LAUNCHES_PAGE.getPageName());
        ASSERT_THAT_ELEMENT_BY_PART_CONTAINS_VALUE(LAUNCH_NAME.getElementName(), launchNumber, launchName);
    }

    @Test(groups = {REGRESSION_SUITE, LAUNCHES_SUITE},
            dataProvider = "launchesRunTotal",
            dataProviderClass = DataProviders.class)
    @Story("TAF-01")
    @Description("Check launch total tests run")
    public void launchesTotalRunTest(String launchNumber, String totalTestsRun) {
        OPEN_PAGE_BY_LINK(LOGIN_PAGE.getPageName(), "baseUrl");
        PAGE_IS_OPENED(LOGIN_PAGE.getPageName());
        ENTER_ENCRYPTED_VALUE_INTO_FIELD(LOGIN_FILED.getElementName(), "rpLogin");
        ENTER_ENCRYPTED_VALUE_INTO_FIELD(PASSWORD_FIELD.getElementName(), "rpPassword");
        CLICK_ON_ELEMENT(SIGN_IN_BUTTON.getElementName());
        PAGE_IS_OPENED(COMMON_PANEL_BLOCK.getPageName());
        PAGE_IS_LOADED();
        CLICK_ON_ELEMENT(LAUNCHES_TAB.getElementName());
        PAGE_IS_OPENED(LAUNCHES_PAGE.getPageName());
        ASSERT_THAT_ELEMENT_BY_PART_CONTAINS_VALUE(LAUNCH_TOTAL.getElementName(), launchNumber, totalTestsRun);
    }

    @Test(groups = {REGRESSION_SUITE, LAUNCHES_SUITE},
            dataProvider = "launchesRunPassed",
            dataProviderClass = DataProviders.class)
    @Story("TAF-01")
    @Description("Check launch passed tests run")
    public void launchesPassedRunTest(String launchNumber, String totalTestsRun) {
        OPEN_PAGE_BY_LINK(LOGIN_PAGE.getPageName(), "baseUrl");
        PAGE_IS_OPENED(LOGIN_PAGE.getPageName());
        ENTER_ENCRYPTED_VALUE_INTO_FIELD(LOGIN_FILED.getElementName(), "rpLogin");
        ENTER_ENCRYPTED_VALUE_INTO_FIELD(PASSWORD_FIELD.getElementName(), "rpPassword");
        CLICK_ON_ELEMENT(SIGN_IN_BUTTON.getElementName());
        PAGE_IS_OPENED(COMMON_PANEL_BLOCK.getPageName());
        PAGE_IS_LOADED();
        CLICK_ON_ELEMENT(LAUNCHES_TAB.getElementName());
        PAGE_IS_OPENED(LAUNCHES_PAGE.getPageName());
        ASSERT_THAT_ELEMENT_BY_PART_CONTAINS_VALUE(LAUNCH_PASSED.getElementName(), launchNumber, totalTestsRun);
    }
}
