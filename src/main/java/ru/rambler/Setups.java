package ru.rambler;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    @AfterClass
    public static void turnOff() {
        driver.quit();
    }
}
