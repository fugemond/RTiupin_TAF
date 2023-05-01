package site.pages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum PagesNaming {
    HOME_PAGE("Home page"),
    LOGIN_PAGE("Login page"),

    LAUNCHES_PAGE("Launches page"),

    MAIN_PAGE("Main page"),

    LAUNCHES_BLOCK("Launch block"),
    COMMON_PANEL_BLOCK("Common panel block");

    final String pageName;
}
