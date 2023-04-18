package site.pages.blocks;

import com.codeborne.selenide.SelenideElement;
import core.annotations.Name;
import core.interfaces.PageElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.openqa.selenium.support.FindBy;
import site.pages.BasePage;

@Name("Common panel block")
public class CommonPanelBlock extends BasePage {

    @Getter
    @ToString
    @AllArgsConstructor
    public enum CommonPanelBlockElements implements PageElement {
        DASHBOARDS_TAB("Dashboard tab"),
        LAUNCHES_TAB("Launches tab"),
        FILTERS_TAB("Filers tab"),
        DEBUG_TAB("Debug tab"),
        PROJECT_MEMBERS_TAB("Project members tab"),
        PROJECT_SETTINGS_TAB("Project settings tab"),
        PROFILE_TAB("Profile tab");

        final String elementName;
    }


    @Name("Dashboard tab")
    @FindBy(css = "[href*=dashboard]")
    SelenideElement dashBoardTab;

    @Name("Launches tab")
    @FindBy(css = "[href*=launches]")
    SelenideElement launchesTab;

    @Name("Filters tab")
    @FindBy(css = "[href*=filters]")
    SelenideElement filtersTab;

    @Name("Debug tab")
    @FindBy(css = "[href*=debug]")
    SelenideElement debugTab;

    @Name("Project members tab")
    @FindBy(css = "[href*=members]")
    SelenideElement projectMembersTab;

    @Name("Dashboard settings tab")
    @FindBy(css = "[href*=settings]")
    SelenideElement projectSettingsTab;

    @Name("Profile tab")
    @FindBy(css = "[href*=profile]")
    SelenideElement profileTab;
}