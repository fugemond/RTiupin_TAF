package site.pages;

import com.codeborne.selenide.SelenideElement;
import core.annotations.Name;
import core.interfaces.PageElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.openqa.selenium.support.FindBy;

@Name("Launches page")
public class LaunchesPage extends BasePage{

    @Getter
    @ToString
    @AllArgsConstructor
    public enum LaunchPageElements implements PageElement {
        LAUNCH_NAME("Launch name"),
        LAUNCH_DESCRIPTION("Launch description"),
        LAUNCH_OWNER("Launch owner"),
        LAUNCH_TOTAL("Launch total"),
        LAUNCH_PASSED("Launch passed"),
        LAUNCH_FAILED("Launch failed"),
        LAUNCH_SKIPPED("Launch skipped");

        final String elementName;
    }

    @Name("Launch name")
    @FindBy(xpath = "//div[contains(@class,'gridRow__grid-row-wrapper')][%s]//td//div[contains(@class,'itemInfo__main-info')]")
    SelenideElement dashBoardTab;

    @Name("Launch description")
    @FindBy(xpath = "//div[contains(@class,'gridRow__grid-row-wrapper')][%s]//td//div[contains(@class,'markdownViewer__mark')]")
    SelenideElement launchDescription;

    @Name("Launch owner")
    @FindBy(xpath = "//div[contains(@class,'gridRow__grid-row-wrapper')][%s]//td//div[contains(@title,'Owner')]")
    SelenideElement launchOwner;

    @Name("Launch total")
    @FindBy(xpath = "//div[contains(@class,'gridRow__grid-row-wrapper')][%s]//div[contains(@class,'launchSuiteGrid__total')]")
    SelenideElement launchTotal;

    @Name("Launch failed")
    @FindBy(xpath = "//div[contains(@class,'gridRow__grid-row-wrapper')][%s]//div[contains(@class,'launchSuiteGrid__failed')]")
    SelenideElement launchFailed;

    @Name("Launch passed")
    @FindBy(xpath = "//div[contains(@class,'gridRow__grid-row-wrapper')][%s]//div[contains(@class,'launchSuiteGrid__passed')]")
    SelenideElement launchPassed;

    @Name("Launch skipped")
    @FindBy(xpath = "//div[contains(@class,'gridRow__grid-row-wrapper')][%s]//div[contains(@class,'launchSuiteGrid__skipped')]")
    SelenideElement launchSkipped;
}
