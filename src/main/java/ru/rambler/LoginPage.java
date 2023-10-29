package ru.rambler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static ru.rambler.UsersPage.logOutButton;
import static ru.rambler.UsersPage.userMenu;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@data-cerber='header::mail::login']")
    public static WebElement loginButton;

    @FindBy(xpath = "//input[@autocomplete = 'username']")
    public static WebElement loginField;

    @FindBy(xpath = "//a[text()='Забыли пароль?']")
    public static WebElement forgotPass;

    @FindBy (xpath = "//span[text()='Запомнить']")
    public static WebElement rememberMe;

    @FindBy(css = "#password")
    public static WebElement passwordField;

    @FindBy(xpath = "//span[contains(text(),'Войти')]/..")
    public static WebElement entryButton;

    @FindBy(xpath = "//a[@href='https://mail.rambler.ru/folder/INBOX']/span")
    public static WebElement toTheInbox;

    @FindBy(xpath = "//span[text()='knock-knockout']")
    public static WebElement userNameMenu;

    public boolean equalsURL(){
        String currentURL = driver.getCurrentUrl();
        String targetURL = "https://www.rambler.ru/";
        if (currentURL.equals(targetURL))
            return true;
        else
            return false;
    }
    public void logOut () {

        userMenu.click();

        logOutButton.click();

    }





}
