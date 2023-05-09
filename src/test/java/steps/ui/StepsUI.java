package steps.ui;

import core.interfaces.PageElement;
import io.cucumber.java.en.And;
import lombok.extern.log4j.Log4j2;
import site.pages.PagesNaming;

import static steps.ui.AllureSteps.*;
import static utility.DecoderLocal.decodeValue;
import static utility.PropertiesLoader.tryGetPropertyOrDefault;

@Log4j2
public class StepsUI {

   /* @And("Open page {string}, by the link {string}")
    public static void OPEN_PAGE_BY_LINK(PagesNaming pageName, String url) {
        String urlToOpen = tryGetPropertyOrDefault(url);
        String pageToOpen = pageName.getPageName();
        openPageByLink(pageToOpen, urlToOpen);
    }*/

    @And("Open page {string}, by the link {string}")
    public static void OPEN_PAGE_BY_LINK(String pageName, String url) {
        String urlToOpen = tryGetPropertyOrDefault(url);
        String pageToOpen = pageName;
        openPageByLink(pageToOpen, urlToOpen);
    }

    @And("Click on element {string}")
    public static void CLICK_ON_ELEMENT(String pageElement) {
        clickOnElement(pageElement);
    }

    public static void CLICK_ON_ELEMENT_WITH_VALUE(PageElement pageElement, String value) {
        clickOnElementWithValue(pageElement.getElementName(), value);
    }

    public static void ENTER_VALUE_INTO_FIELD(PageElement pageElement, String value) {
        String inputText = tryGetPropertyOrDefault(value);
        enterValueIntoField(pageElement.getElementName(), inputText);
    }

    @And("Into the field {string}, enter encrypted value {string}")
    public static void ENTER_ENCRYPTED_VALUE_INTO_FIELD(String pageElement, String inputText) {
        String decryptedValue = decodeValue(tryGetPropertyOrDefault(inputText));
        enterEncryptedValueIntoField(pageElement, decryptedValue);
    }

    @And("Page {string} is opened")
    public static void PAGE_IS_OPENED(String pageName) {
        pageIsOpened(pageName);
    }

    @And("Page is loaded")
    public static void PAGE_IS_LOADED() {
        pageIsLoaded();
    }


}
