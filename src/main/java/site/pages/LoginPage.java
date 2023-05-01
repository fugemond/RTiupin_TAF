package site.pages;

import com.codeborne.selenide.SelenideElement;
import core.annotations.Name;
import core.interfaces.PageElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.openqa.selenium.support.FindBy;

@Name("Login page")
public class LoginPage extends BasePage {

    @Getter
    @ToString
    @AllArgsConstructor
   public enum LoginPageElements implements PageElement {
        LOGIN_FILED("Login field"),
        PASSWORD_FIELD("Password field"),
        SIGN_IN_BUTTON("Sign in button");

        final String elementName;
    }

    @Name("Login field")
    @FindBy(css = "[name='login']")
    SelenideElement loginField;

    @Name("Password field")
    @FindBy(css = "[name='password']")
    SelenideElement passwordField;

    @Name("Sign in button")
    @FindBy(css = "[type='submit']")
    SelenideElement signInButton;
}
