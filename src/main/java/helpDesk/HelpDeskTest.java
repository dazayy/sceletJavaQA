package helpDesk;

import core.BaseTest;
import helpers.TestValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import readProperties.ConfigProvider;

import static helpers.StringModifier.getUniqueString;

public class HelpDeskTest extends BaseTest {

/*
* each class is responsible for one page (login page, main page, etc)
* */
    @Test
    public void checkTicket() throws InterruptedException {
        /*
        * Из-за того, что TicketPage является финальной (последней) страницей, можно изменить код ниже
        *
        * */

// --------------------------------------------------------
//        MainPage mainPage = new MainPage();
//        mainPage.createTicket(TestValues.TEST_TITLE, TestValues.TEST_BODY, TestValues.TEST_EMAIL)
//                .openLoginPage()
//                .auth(ConfigProvider.DEMO_LOGIN, ConfigProvider.DEMO_PASSWORD)
//                .findTicket(TestValues.TEST_TITLE);
// --------------------------------------------------------
       // Измененная версия
        String title = getUniqueString(TestValues.TEST_TITLE);
        TicketPage ticketPage = new MainPage()

                .createTicket(title, TestValues.TEST_BODY, TestValues.TEST_EMAIL)
                .openLoginPage()
                .auth(ConfigProvider.DEMO_LOGIN, ConfigProvider.DEMO_PASSWORD)
                .findTicket(title);

        Assert.assertTrue(ticketPage.getTitle().contains(title));
        Assert.assertEquals(ticketPage.getDescription(), TestValues.TEST_BODY);
        Assert.assertEquals(ticketPage.getEmail(), TestValues.TEST_EMAIL);
    }
}
