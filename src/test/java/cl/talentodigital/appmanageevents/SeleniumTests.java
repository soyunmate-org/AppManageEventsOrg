package cl.talentodigital.appmanageevents;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        // Conectar al contenedor de Selenium
        driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options);
    }

    @Test
    public void testGoogleTitle() {
        // Abrir Google y verificar el título
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        assertEquals("Google", title);
    }

    @Test
    public void testFirefox() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        assertEquals("Google", title);
        driver.quit();
    }

    @Test
    public void testEdge() throws MalformedURLException {
        EdgeOptions options = new EdgeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.get("https://www.google.com");
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
