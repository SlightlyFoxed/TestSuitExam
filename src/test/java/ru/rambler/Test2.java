package ru.rambler;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import ru.rambler.RealizationMethods.*;
import org.openqa.selenium.support.PageFactory;

import static ru.rambler.Setups.*;

public class Test2 {

    UsersPage usersPage = PageFactory.initElements(driver,UsersPage.class);

    RealizationMethods realizationMethods = PageFactory.initElements(driver,RealizationMethods.class);

    LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);

    private static final ConfigProps confProp = ConfigProps.conf;



    @Test(suiteName = "Тестирование UI",testName = "Написание письма и проверка его получения")
    public void mailToMailFrom() throws InterruptedException {
        settings();

        realizationMethods.autorization(confProp.login1(), confProp.password1());

        realizationMethods.writeMessage(confProp.login2PostAdr(),confProp.topicExample(),confProp.mailExample());

        loginPage.logOut();

        realizationMethods.secondAutorization(confProp.login2(), confProp.password2());

        realizationMethods.checkNewMessage();

        loginPage.logOut();

        turnOff();
    }

}
