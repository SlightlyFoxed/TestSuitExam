package ru.rambler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
    public WebDriver driver;

    public UsersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy (xpath = "//a[contains (@class,'unseen')]")
    public static WebElement newMessage;

    @FindBy (xpath = "//a[contains(@title,'Входящие')]")
    public static WebElement inboxMessageFolder;

    @FindBy (xpath = "//span[text()='Социальные сети']")
    public static WebElement socialMediaFolder;

    @FindBy (xpath = "//span[text()='Рассылки']")
    public static WebElement newslettersFolder;

    @FindBy (xpath = "//span[text()='Отправленные']")
    public static WebElement sentMessageFolder;

    @FindBy (xpath = "//span[text()='Черновики']")
    public static WebElement draftsFolder;

    @FindBy (xpath = "//span[text()='Корзина']")
    public static WebElement basketFolder;

    @FindBy (xpath = "//span[text()='Спам']")
    public static WebElement spamFolder;

    @FindBy (xpath = "//li[@class='ExpandButton-root-1T']/div")
    public static WebElement expandButton;

    @FindBy (xpath = "//span[text()='Скрыть']")//Только после expandButton
    public static WebElement hideExpandButton;

    @FindBy (xpath = "//span[text()='Написать']")
    public static WebElement writeNewLetterButton;

    @FindBy (xpath = "//button[@aria-label='Открыть меню пользователя']")//Разворачивает меню пользователя и сворачивает при повторном нажатии
    public static WebElement userMenu;

    @FindBy (xpath = "//button[text()='Выход']")//Только после нажатия на userMenu
    public static WebElement logOutButton;

    @FindBy (css = "#receivers")
    public static WebElement receiversField; //Только после нажатия на writeNewLetterButton

    @FindBy (css = "#subject")
    public static WebElement subjectField;//Только после нажатия на writeNewLetterButton

    @FindBy (xpath = "//body[contains(@aria-label,'Поле')]")//Только после нажатия на writeNewLetterButton
    public static WebElement writeField;

    @FindBy (xpath = "//span[text()='Отправить']")
    public static WebElement sendLetter;

    @FindBy (xpath = "//span[text()='Сохранить черновик']")
    public static WebElement saveTheDraft;

    @FindBy (xpath = "//span[text()='knock-knockout@rambler.ru']")
    public static WebElement openDraftLetter;

    @FindBy (xpath = "//div[@data-list-view='draft-edit']")
    public static WebElement editDraftletter;


}
