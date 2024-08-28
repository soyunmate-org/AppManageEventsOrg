package cl.talentodigital.appmanageevents;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class SeleniumTests {

    private WebDriver driver;

    @Test
     void testGoogleTitle() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options);
        driver.get("https://www.google.com");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Google"));


        String title = driver.getTitle();
        assertEquals("Google", title);
    }

    @Test
     void testFirefox() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        WebDriver driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options);
        driver.get("https://www.google.com");

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Google"));

        String title = driver.getTitle();
        assertEquals("Google", title);
        driver.quit();
    }

    @Test
     void testEdge() throws MalformedURLException {
        EdgeOptions options = new EdgeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options);
        driver.get("https://www.google.com");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Google"));

        String title = driver.getTitle();
        assertEquals("Google", title);
        driver.quit();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
