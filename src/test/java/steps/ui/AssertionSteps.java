package steps.ui;

import com.codeborne.selenide.Condition;
import core.interfaces.PageElement;
import io.cucumber.java.en.And;
import lombok.extern.log4j.Log4j2;
import site.pages.PagesNaming;

import static steps.ui.AllureSteps.*;

@Log4j2
public class AssertionSteps {

    public static void VERIFY_ELEMENT_CONDITION(PageElement pageElement, Condition condition) {
        verifyElementCondition(pageElement.getElementName(), condition);
    }

    public static void ASSERT_THAT_ELEMENT_CONTAINS_VALUE(PageElement pageElement, String text) {
        assertThatElementContainsValue(pageElement.getElementName(), text);
    }

    public static void ASSERT_THAT_CURRENT_URL_IS(String url) {
        assertThatCurrentUrlIs(url);
    }

    @And("Assert that element {string} by part {string} contains value {string}")
    public static void ASSERT_THAT_ELEMENT_BY_PART_CONTAINS_VALUE(String pageElementName, String elementLocatorPart, String expectedValue){
        assertThatElementByPartContainsValue(pageElementName,elementLocatorPart,expectedValue);
    }
}
