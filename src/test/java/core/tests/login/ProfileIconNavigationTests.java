package core.tests.login;

import steps.ui.TestSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static site.pages.LoginPage.LoginPageElements.*;
import static site.pages.PagesNaming.COMMON_PANEL_BLOCK;
import static site.pages.PagesNaming.LOGIN_PAGE;
import static site.pages.blocks.CommonPanelBlock.CommonPanelBlockElements.LAUNCHES_TAB;
import static steps.ui.StepsUI.*;

@Log4j2
public class ProfileIconNavigationTests extends TestSetup {

    @Test(groups = {REGRESSION_SUITE, LAUNCHES_SUITE})
    @Story("TAF-02")
    @Description("Test ability to open Launches page for logged user")
    public void userAbleToOpenProfilePage() {
        OPEN_PAGE_BY_LINK(LOGIN_PAGE.getPageName(), "baseUrl");
        PAGE_IS_OPENED(LOGIN_PAGE.getPageName());
        ENTER_ENCRYPTED_VALUE_INTO_FIELD(LOGIN_FILED.getElementName(), "rpLogin");
        ENTER_ENCRYPTED_VALUE_INTO_FIELD(PASSWORD_FIELD.getElementName(), "rpPassword");
        CLICK_ON_ELEMENT(SIGN_IN_BUTTON.getElementName());
        PAGE_IS_OPENED(COMMON_PANEL_BLOCK.getPageName());
        PAGE_IS_LOADED();
        CLICK_ON_ELEMENT(LAUNCHES_TAB.getElementName());
    }
}
