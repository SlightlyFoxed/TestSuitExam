package ru.rambler;

import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import ru.rambler.RealizationMethods.*;
import org.openqa.selenium.support.PageFactory;

import static ru.rambler.Setups.*;



public class Test1 {

    public static UsersPage usersPage;

    RealizationMethods realizationMethods = PageFactory.initElements(driver,RealizationMethods.class);

    LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);

    private static final ConfigProps confProp = ConfigProps.conf;


    @Test(suiteName = "Тестирование UI",testName = "Авторизация пользователя",retryAnalyzer = Retry.class)
    public void enterToFirstAcc() throws InterruptedException {
        settings();

        realizationMethods.autorization(confProp.login1(), confProp.password1());

        loginPage.logOut();

        turnOff();
    }



}
