package ru.rambler;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static ru.rambler.LoginPage.*;
import static ru.rambler.Setups.driver;
import static ru.rambler.Setups.settings;
import static ru.rambler.UsersPage.*;

public class Test1 {

    public static LoginPage loginPage;

    public static UsersPage usersPage;
    private static final ConfigProps confProp = ConfigProps.conf;


    @Test
    public void test1() throws InterruptedException {
        settings();

        /*String title = driver.getTitle();

        Assert.assertEquals(title, "Рамблер/новости, почта и поиск — медийный портал: новости России и мира, электронная почта, погода, развлекательные и коммуникационные сервисы. Новости сегодня и сейчас");

        loginButton.isDisplayed();

        driver.get("https://mail.rambler.ru/folder/INBOX");*/

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginField.isDisplayed();

        passwordField.isDisplayed();

        rememberMe.isDisplayed();

        forgotPass.isDisplayed();

        entryButton.isDisplayed();

        loginField.sendKeys(confProp.login1());

        passwordField.sendKeys(confProp.password1());

        entryButton.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        userNameMenu.isDisplayed();

        toTheInbox.isDisplayed();

        String loginWindow = driver.getWindowHandle();

        toTheInbox.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        Set<String> currentWindows = driver.getWindowHandles();

        String userWindow = null;

        for (String window : currentWindows) {
            if (!window.equals(loginWindow)) {
                userWindow = window;
                break;
            }
        }
        driver.switchTo().window(userWindow);

        Assert.assertEquals(driver.getCurrentUrl(),"https://mail.rambler.ru/folder/INBOX");

        inboxMessageFolder.isDisplayed();

        sentMessageFolder.isDisplayed();

        draftsFolder.isDisplayed();

        basketFolder.isDisplayed();

        spamFolder.isDisplayed();

        newMessage.isDisplayed();

        userNameMenu.isDisplayed();

        userMenu.click();

        logOutButton.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.rambler.ru/");

        driver.quit();

        driver.switchTo().window(loginWindow);

    }

}
