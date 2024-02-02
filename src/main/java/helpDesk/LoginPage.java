package helpDesk;

import core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {
    @FindBy(css = "input#username")
    private WebElement loginInputUsername;

    @FindBy(css = "input#password")
    private WebElement loginInputPassword;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    public TicketsPage auth(String usernameValue, String passwordValue) {
        loginInputUsername.sendKeys(usernameValue);
        loginInputPassword.sendKeys(passwordValue, Keys.ENTER);
        return new TicketsPage();
    }
}
