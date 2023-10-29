package ru.rambler;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import static ru.rambler.Setups.*;
import org.openqa.selenium.support.PageFactory;

public class Retry implements IRetryAnalyzer {
    private int actualRetry = 0;
    private static final int MAX_RETRY = 3;
    @Override
    public boolean retry(ITestResult result) {
        if (actualRetry < MAX_RETRY) {
            actualRetry++;
            return true;
        } else {
            driver.quit();
            return false;
        }
    }
}
