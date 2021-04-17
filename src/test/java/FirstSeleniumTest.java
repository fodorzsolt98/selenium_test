import org.junit.*;
import java.util.Random;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;  


public class FirstSeleniumTest {
    public WebDriver driver;
    
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void testFreeMail() {
        MainPage mainPage = new MainPage(this.driver);
        
        ProfilePage profilePage = mainPage.login("fodorzsolttemporary", "Temporary01");

        SettingsPage settingsPage = profilePage.openSettings();
        
        String settingsPageBody = settingsPage.getBodyText();

        String[] menuPoints = {"Piszkozat", "Spam", "Kuka", "Csillagozott"};

        for(String point : menuPoints){
            Assert.assertTrue(settingsPageBody.contains(point));
        }

        Random rand = new Random();

        int option1 = rand.nextInt(2);
        int option2 = rand.nextInt(2);
        int option3 = rand.nextInt(2);

        settingsPage.toggleSound(option1);

        settingsPage.toggleBin(option2);

        settingsPage.togglePicturePreview(option3);

        SpamPage spamPage = settingsPage.openSpamPage();

        Assert.assertTrue(spamPage.getBodyText().contains("SPAM"));

        LogoutPage logoutPage = spamPage.logout();

        Assert.assertTrue(logoutPage.getTitle().contains("Newsfeed"));

        logoutPage.deleteAllCookies();

        Set<Cookie> cookieSet = logoutPage.getAllCookies();
        Assert.assertTrue(cookieSet.isEmpty());

        this.driver.navigate().back();

        mainPage = new MainPage(this.driver);

        Assert.assertTrue(mainPage.getBodyText().contains("Maradjon bejelentkezve"));
    }
    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
