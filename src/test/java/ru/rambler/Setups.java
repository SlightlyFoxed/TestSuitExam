package ru.rambler;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


import java.util.concurrent.TimeUnit;

public class Setups {
    public static LoginPage loginPage;
    public static WebDriver driver;
    public static UsersPage usersPage;
    @BeforeClass
    public static void settings() {

        System.setProperty("webdriver.chrome.driver", "D:\\Tools\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);

        usersPage = new UsersPage(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://mail.rambler.ru/folder/INBOX");



    }
    @AfterClass ()
    @Step("Выключение")
    public static void turnOff() {
        driver.quit();
    }


}
