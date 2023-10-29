package ru.rambler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static ru.rambler.LoginPage.*;
import static ru.rambler.UsersPage.*;

import org.testng.Assert;
import ru.rambler.LoginPage.*;
import static ru.rambler.Setups.*;
import static ru.rambler.UsersPage.newMailSubject;


public class RealizationMethods {

    private static final ConfigProps confProp = ConfigProps.conf;

    public boolean sendMailContains (String mailTextmin1,String mailSubject1, String mailLoginPostAdr2){

        String s1 = mailTextMin.getText();
        String s2 = mailSubject.getText();
        String s3 = mailLoginPostAdr.getText();
        String str1 = mailTextmin1.substring(0, 98);
        if (str1.equals(s1) && mailSubject1.equals(s2) && mailLoginPostAdr2.equals(s3)){
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
    public boolean newMailContains (String mailTextmin1,String mailSubject1, String mailLoginPostAdr2){

        String s1 = newMailTextmin.getText();
        String s2 = newMailSubject.getText();
        String s3 = newMailLoginPostAdr.getText();
        String str1 = mailTextmin1.substring(0, 98);
        if (str1.equals(s1) && mailSubject1.equals(s2) && mailLoginPostAdr2.equals(s3)){
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
    public boolean openMailCont (String subject, String from,String to, String text){
        String s1 = messageSubject.getText();
        String s2 = messageFrom.getText();
        String s3 = messageTo.getText();
        String s4 = messageText.getText();
        String str1 = text;
        if (str1.equals(s4) && subject.equals(s1) && from.equals(s2) && to.equals(s3)){
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


    public void autorization (String login, String pass)
    {

        WebElement iframeAppPanel = driver.findElement(By.xpath("//iframe[contains(@src,'https://id.rambler.ru/login-20/login?')]"));

        driver.switchTo().frame(iframeAppPanel);

        loginField.click();

        loginField.sendKeys(login);

        passwordField.sendKeys(pass);

        entryButton.click();

        entryButton.click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        entryButton.click();

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
    public static void checkMessageButton ()
    {
        String s1 = toTheInbox.getText();
        String s2 = "1 новое письмо";
        if (s2.equals(s1)) {
            System.out.println("Кнопка 'Войти' изменилась на 1 новое письмо");
        } else if (!s2.equals(s1)){
            System.out.println("Кнопка 'Войти' изменилась на ");
            System.out.print(s1);
        } else if (entryButton.isDisplayed()){
            System.out.println("Кнопка 'Войти' осталась без изменений");
        }

    }
    public void secondAutorization (String login, String pass)
    {
        loginButton.click();

        WebElement iframeAppPanel = driver.findElement(By.xpath("//iframe[contains(@src,'https://id.rambler.ru/login-20/login?')]"));

        driver.switchTo().frame(iframeAppPanel);

        loginField.click();

        loginField.sendKeys(login);

        passwordField.sendKeys(pass);

        entryButton.click();

        entryButton.click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        //entryButton.click();

        driver.switchTo().defaultContent();

        checkMessageButton();

        String oldTab = driver.getWindowHandle();

        toTheInbox.click();

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());

        newTab.remove(oldTab);

        driver.switchTo().window(newTab.get(0));

    }
    public void checkNewMessage ()
    {

        newMessage.isDisplayed();

        newMailContains(confProp.mailExample(), confProp.topicExample(), confProp.namelogin1());

        newMessage.click();

        openMailCont(confProp.topicExample(), confProp.login1PostAdr(), confProp.login2PostAdr(), confProp.mailExample());


    }

    public void writeMessage (String receiver, String topic, String mailText) throws InterruptedException
    {
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

        Thread.sleep(2000);

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

        sendMailContains(confProp.mailExample(),confProp.topicExample(),confProp.login2PostAdr());

        mailTextMin.click();

        openMailCont(confProp.topicExample(), confProp.login1PostAdr(),confProp.login2PostAdr(),confProp.mailExample());

        String attr = quicksendButton.getAttribute("disabled");

        System.out.println(attr);




    }
}
