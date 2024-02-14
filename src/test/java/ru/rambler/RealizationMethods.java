package ru.rambler;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static ru.rambler.LoginPage.*;
import static ru.rambler.UsersPage.*;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.rambler.LoginPage.*;

import static ru.rambler.Setups.*;
import static ru.rambler.UsersPage.newMailSubject;


public class RealizationMethods {

    private static final ConfigProps confProp = ConfigProps.conf;


    @Step("Прожатие кнопки 'Войти'")
    public void entryButtonClicker(){
            while (entryButton.isEnabled()){
                entryButton.click();
            }

    }

    @Step("Проверка содержимого отправленного письма на соответствие")
    public boolean sendMailContains(String mailTextmin1, String mailSubject1, String mailLoginPostAdr2) {

        String s1 = mailTextMin.getText();
        String s2 = mailSubject.getText();
        String s3 = mailLoginPostAdr.getText();
        String str1 = mailTextmin1.substring(0, 98);
        if (str1.equals(s1) && mailSubject1.equals(s2) && mailLoginPostAdr2.equals(s3)) {
            return true;
        } else {
            System.out.println(mailSubject1);
            System.out.println(s2);
            System.out.println(mailLoginPostAdr2);
            System.out.println(s3);
            Assert.fail();
            return false;
        }
    }

    @Step("Проверка содержимого нового письма на соответствие")
    public boolean newMailContains(String mailTextmin1, String mailSubject1, String mailLoginPostAdr2) {

        String s1 = newMailTextmin.getText();
        String s2 = newMailSubject.getText();
        String s3 = newMailLoginPostAdr.getText();
        String str1 = mailTextmin1.substring(0, 98);
        if (str1.equals(s1) && mailSubject1.equals(s2) && mailLoginPostAdr2.equals(s3)) {
            return true;
        } else {
            System.out.println(mailSubject1);
            System.out.println(s2);
            System.out.println(mailLoginPostAdr2);
            System.out.println(s3);
            System.out.println(str1);
            System.out.println(s1);
            Assert.fail();
            return false;
        }
    }
    @Step("Проверка содержимого черновика на соответствие")
    public boolean draftMailContainsMin(String mailTextmin1, String mailSubject1, String mailLoginPostAdr2) {

        String s1 = draftMailTextMin.getText();
        String s2 = draftMailSubjectMin.getText();
        String s3 = draftMailLoginPostAdr2.getText();
        String str1 = mailTextmin1.substring(0, 98);
        if (str1.equals(s1) && mailSubject1.equals(s2) && mailLoginPostAdr2.equals(s3)) {
            return true;
        } else {
            System.out.println(mailSubject1);
            System.out.println(s2);
            System.out.println(mailLoginPostAdr2);
            System.out.println(s3);
            System.out.println(str1);
            System.out.println(s1);
            Assert.fail();
            return false;
        }
    }

    @Step("Проверка содержимого письма на соответствие")
    public boolean openMailCont(String subject, String from, String to, String text) {
        String s1 = messageSubject.getText();
        String s2 = messageFrom.getText();
        String s3 = messageTo.getText();
        String s4 = messageText.getText();
        String str1 = text;
        if (str1.equals(s4) && subject.equals(s1) && from.equals(s2) && to.equals(s3)) {
            return true;
        } else {
            System.out.println(subject);
            System.out.println(s1);
            System.out.println(from);
            System.out.println(s2);
            System.out.println(to);
            System.out.println(s3);
            Assert.fail();
            return false;
        }
    }


    @Step("Авторизация пользователя")
    public void autorization(String login, String pass) {

        WebElement iframeAppPanel = driver.findElement(By.xpath("//iframe[contains(@src,'https://id.rambler.ru/login-20/login?')]"));

        driver.switchTo().frame(iframeAppPanel);

        loginField.click();

        loginField.sendKeys(login);

        passwordField.sendKeys(pass);

        entryButtonClicker();

        userNameMenu.isDisplayed();

        inboxMessageFolder.isDisplayed();

        sentMessageFolder.isDisplayed();

        draftsFolder.isDisplayed();

        basketFolder.isDisplayed();

        spamFolder.isDisplayed();

        //newMessage.isDisplayed();

        userNameMenu.isDisplayed();

        //newMessage.click();

    }

    @Step("Проверка изменения кнопки 'Войти'")
    @Description("Кнопка должна измениться на 1 новое письмо или х-новых писем")
    public static void checkMessageButton() {
        String s1 = toTheInbox.getText();
        String s2 = "1 новое письмо";
        try {
            if (s2.equals(s1)) {
                System.out.println("Кнопка 'Войти' изменилась на 1 новое письмо");
            } else if (!s2.equals(s1)) {
                System.out.println("Кнопка 'Войти' изменилась на " + s1);
            } else if (loginButton.isDisplayed()){
                System.out.println("Кнопка 'Войти' осталась без изменений");
            }
        }catch (org.openqa.selenium.NoSuchElementException ignored){

        }

    }

    @Step("Авторизация второго пользователя")
    public void secondAutorization(String login, String pass) {
        loginButton.click();

        WebElement iframeAppPanel = driver.findElement(By.xpath("//iframe[contains(@src,'https://id.rambler.ru/login-20/login?')]"));

        driver.switchTo().frame(iframeAppPanel);

        loginField.click();

        loginField.sendKeys(login);

        passwordField.sendKeys(pass);

        entryButtonClicker();

        checkMessageButton();

        driver.switchTo().defaultContent();

        String oldTab = driver.getWindowHandle();

        toTheInbox.click();

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());

        newTab.remove(oldTab);

        driver.switchTo().window(newTab.get(0));

    }

    @Step("Проверка активности кнопки 'Быстрый ответ'")
    @Description("Изначально кнопка должна быть не активна, пока пользователь не нажмет на поле быстрого ответа")
    public void assertQuicksendBtn() {
        String actualAttr = quicksendButton.getAttribute("disabled");
        String expectedAttr = "true";
        try {
            if (actualAttr.equals(expectedAttr)) {
                System.out.println("Кнопка отправить не активна");
            } else {
            }
        }catch (NullPointerException e){//Так как элемент содержит 2 атрибута с одним именем, сослаться на нужный атрибут, который выдает нормальные значения невозможно.Пришлось использовать try catch NullPointerException
            System.out.println("Кнопка отправить активна");
        }

    }

    @Step("Проверка получения нового письма")
    public void checkNewMessage() {

        newMessage.isDisplayed();

        newMailContains(confProp.mailExample(), confProp.topicExample(), confProp.namelogin1());

        newMessage.click();

        openMailCont(confProp.topicExample(), confProp.login1PostAdr(), confProp.login2PostAdr(), confProp.mailExample());

        assertQuicksendBtn();

        quickReplyField.click();

        assertQuicksendBtn();

    }

    @Step("Написание письма")
    public void writeMessage(String receiver, String topic, String mailText) throws InterruptedException {
        /*String accWindowId = driver.getWindowHandle();

        writeNewLetterButton.click();

        String newInboxWindow = null;

        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles)
        {
            if (handle!= accWindowId)
            {
                newInboxWindow = handle;
                break;
            }
        }

        driver.switchTo().window(newInboxWindow);*/
        driver.switchTo().defaultContent();

        writeNewLetterButton.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        receiversField.click();

        Thread.sleep(1000);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        receiversFieldPaste.sendKeys(receiver);

        subjectField.click();

        subjectField.sendKeys(topic);

        WebElement iframeMailPanel = driver.findElement(By.xpath("//iframe[contains(@title, 'Поле форматированного текста')]"));

        driver.switchTo().frame(iframeMailPanel);

        writeField.click();

        writeField.sendKeys(mailText);

        driver.switchTo().defaultContent();

        sendLetter.click();

        Thread.sleep(18000);

        sentMessageFolder.click();

        sendMailContains(confProp.mailExample(), confProp.topicExample(), confProp.login2PostAdr());

        mailTextMin.click();

        openMailCont(confProp.topicExample(), confProp.login1PostAdr(), confProp.login2PostAdr(), confProp.mailExample());

        assertQuicksendBtn();

        quickReplyField.click();

        assertQuicksendBtn();


    }

    @Step("Проверка счетчика черновиков")
    public void draftCounterAssert (String beforeSave, String afterSave)
    {
        if (beforeSave.equals(afterSave))
        {
            System.out.println("Счетчик черновиков не изменился");
        } else {
            System.out.println("Счетчик черновиков изменился с " + beforeSave + " на " + afterSave);
        }
    }

    @Step("Проверка нахождения на нужной странице")
    public void assertUrl (String expextedUlr)
    {
        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl,expextedUlr);
    }

    @Step("Ожидание окончательной загрузки страницы")
    public void waitForFinallyDownload (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
                wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
    @Step("Ожидание изменения статуса кнопки")
    public void waitForBtn(WebElement btn)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        wait.until(ExpectedConditions.visibilityOf(btn));
    }
    @Step("Сохранение черновика")
    @Description("Проверка возможности редактирования полей черновика, а так же изменение счетчика черновиков при создании нового")
    public void saveDraftLetter(String receiver, String topic, String mailText)throws InterruptedException
    {

        driver.switchTo().defaultContent();

        String beforeSave = draftCounter.getText();

        System.out.println(beforeSave);

        writeNewLetterButton.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        receiversField.click();

        Thread.sleep(1000);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        receiversFieldPaste.sendKeys(receiver);

        subjectField.click();

        subjectField.sendKeys(topic);

        WebElement iframeMailPanel = driver.findElement(By.xpath("//iframe[contains(@title, 'Поле форматированного текста')]"));

        driver.switchTo().frame(iframeMailPanel);

        writeField.click();

        writeField.sendKeys(mailText);

        driver.switchTo().defaultContent();

        saveTheDraft.click();

        Thread.sleep(1000);//ВЫНУЖДЕННАЯ МЕРА так как проблема в самом сайте. Вариации "правильных" методов есть выше. waitForFinallyDownload и waitForBtn

        String afterSave = draftCounter.getText();

        System.out.println(afterSave);

        draftCounterAssert(beforeSave,afterSave);

        assertUrl("https://mail.rambler.ru/folder/INBOX");

        draftsFolder.click();

        draftMailContainsMin(confProp.mailExample(),confProp.topicExample(),confProp.login2PostAdr());

        draftMailTextMin.click();

        openMailCont(confProp.topicExample(), confProp.login1PostAdr(), confProp.login2PostAdr(), confProp.mailExample());

        editDraftletter.isDisplayed();

        draftsFolder.click();

        editSubjectCheck(confProp.topicExample());

        draftsFolder.click();

        editTextCheck(confProp.mailExample());

        draftsFolder.click();

        editToCheck(confProp.login2PostAdr());

        draftsFolder.click();

        newDraftMessage(confProp.login2PostAdr(),confProp.topicExample(),confProp.mailExample());

        editAllFieldsCheck(confProp.topicExample(),confProp.login2PostAdr(),confProp.mailExample());

    }

    @Step("Написание нового черновика")
    public void newDraftMessage (String receiver, String topic, String mailText) throws InterruptedException {
        driver.switchTo().defaultContent();

        String beforeSave = draftCounter.getText();

        System.out.println(beforeSave);

        writeNewLetterButton.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        receiversField.click();

        Thread.sleep(1000);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        receiversFieldPaste.sendKeys(receiver);

        subjectField.click();

        subjectField.sendKeys(topic);

        WebElement iframeMailPanel = driver.findElement(By.xpath("//iframe[contains(@title, 'Поле форматированного текста')]"));

        driver.switchTo().frame(iframeMailPanel);

        writeField.click();

        writeField.sendKeys(mailText);

        driver.switchTo().defaultContent();

        saveTheDraft.click();
    }
    @Step("Проверка редактирования поля 'Тема'")
    public void editSubjectCheck(String topic) throws InterruptedException {

        draftMailTextMin.click();

        editDraftletter.click();

        subjectField.click();

        subjectField.sendKeys(Keys.BACK_SPACE);

        saveTheDraft.click();

        Thread.sleep(1000);

        draftMailTextMin.click();

        Assert.assertNotEquals(topic,messageSubject.getText());

    }

    @Step("Проверка редактирования текста письма")
    public void editTextCheck (String text) throws InterruptedException {

        draftMailTextMin.click();

        editDraftletter.click();

        WebElement iframeMailPanel = driver.findElement(By.xpath("//iframe[contains(@title, 'Поле форматированного текста')]"));

        driver.switchTo().frame(iframeMailPanel);

        writeField.click();

        writeField.clear();

        writeField.sendKeys("Проверка редактирования текста");

        driver.switchTo().defaultContent();

        saveTheDraft.click();

        Thread.sleep(1000);

        draftMailTextMin.click();

        Assert.assertNotEquals(text,messageText.getText());

    }
    @Step("Проверка редактирования поля 'Кому'")
    public void editToCheck (String login) throws InterruptedException {
        draftMailTextMin.click();

        editDraftletter.click();

        receiversField.click();

        Thread.sleep(1000);

        receiversFieldPaste.sendKeys(Keys.BACK_SPACE);

        receiversFieldPaste.sendKeys(confProp.fakeLogin());

        saveTheDraft.click();

        Thread.sleep(1000);

        draftMailTextMin.click();

        Assert.assertNotEquals(login,messageTo.getText());
    }

    @Step("Проверка редактирования всех полей письма")
    public void editAllFieldsCheck (String topic, String login, String text) throws InterruptedException {
        draftMailTextMin.click();

        editDraftletter.click();

        subjectField.click();

        subjectField.sendKeys(Keys.BACK_SPACE);

        WebElement iframeMailPanel = driver.findElement(By.xpath("//iframe[contains(@title, 'Поле форматированного текста')]"));

        driver.switchTo().frame(iframeMailPanel);

        writeField.click();

        writeField.clear();

        writeField.sendKeys("Проверка редактирования текста");

        driver.switchTo().defaultContent();

        receiversField.click();

        Thread.sleep(1000);

        receiversFieldPaste.sendKeys(Keys.BACK_SPACE);

        receiversFieldPaste.sendKeys(confProp.fakeLogin());

        saveTheDraft.click();

        Thread.sleep(1000);

        draftMailTextMin.click();

        Assert.assertNotEquals(topic,messageSubject.getText());

        Assert.assertNotEquals(topic,messageSubject.getText());

        Assert.assertNotEquals(login,messageTo.getText());

    }

}
