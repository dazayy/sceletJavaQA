package helpDesk;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfigProvider;

public class MainPage extends BaseSeleniumPage {
    @FindBy(xpath = "//select[@id='id_queue']")
    private WebElement queueList;

    @FindBy(xpath = "//select[@id='id_queue']//option[@value='1']")
    private WebElement queueValue;

    @FindBy(xpath = "//input[@id=\"id_title\"]")
    private WebElement titleInput;

    @FindBy(xpath = "//textArea[@id=\"id_body\"]")
    private WebElement textArea;

    @FindBy(xpath = "//input[@id=\"id_due_date\"]")
    private WebElement inputDueData;

    @FindBy(xpath = "//table[@class=\"ui-datepicker-calendar\"]//a[text()=\"23\"]")
    private WebElement dateValue;

    @FindBy(xpath = "//input[@id=\"id_submitter_email\"]")
    private WebElement inputEmail;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(id = "userDropdown")
    private WebElement loginButton;

    public MainPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public MainPage createTicket(String titleValue, String bodyValue, String emailValue) {
        queueList.click();
        queueValue.click();
        titleInput.sendKeys(titleValue);
        textArea.sendKeys(bodyValue);
        inputDueData.click();
        dateValue.click();
        inputEmail.sendKeys(emailValue);
        submitButton.click();
        return this;
    }

    public LoginPage openLoginPage() {
        loginButton.click();
        return  new LoginPage();
    }

}
