package pages;

import org.openqa.selenium.By;

public class BravePage extends BasePage {
    private By inpSearch = By.name("q");
    private By btnSearch = By.id("submit-button");
    private By btnQuickGoggles = By.id("quick-goggles-button");

    public boolean isSearchSuccessful() {
        return isElementExist(btnQuickGoggles);
    }

    public void search(String keyword) {
        type(inpSearch, keyword);
        click(btnSearch);
        waitForVisibility(btnQuickGoggles);
    }
}
