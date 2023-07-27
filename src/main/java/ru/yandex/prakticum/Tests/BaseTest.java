package ru.yandex.prakticum.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.yandex.prakticum.PageObject.MainPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setup() {

        String browser = "Google";

        if (browser == "Google"){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        } else if (browser == "FireFox"){
            System.setProperty("webdriver.gecko.driver", "C:\\WebDriverMozilla\\bin\\geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

    }
    //Закрываем браузер
    @After
    public void teardown() {
        driver.quit();
    }
}
