package ru.rambler;
import org.testng.annotations.Test;

import ru.rambler.RealizationMethods.*;
import org.openqa.selenium.support.PageFactory;

import static ru.rambler.Setups.*;


public class Test3 {

    UsersPage usersPage = PageFactory.initElements(driver,UsersPage.class);

    RealizationMethods realizationMethods = PageFactory.initElements(driver,RealizationMethods.class);

    LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);

    private static final ConfigProps confProp = ConfigProps.conf;



    @Test()
    public void mailToMailFrom() throws InterruptedException {
        settings();

        realizationMethods.autorization(confProp.login1(), confProp.password1());

        realizationMethods.saveDraftLetter(confProp.login2PostAdr(),confProp.topicExample(),confProp.mailExample());

    }

}

