import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class ProfilePage extends PageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public SettingsPage openSettings(){
        By settingsIconBy = By.xpath("//ul[@class='menu-main-items']/li[3]/a[1]");

        WebElement settingsButton = this.waitAndReturnElement(settingsIconBy);

        settingsButton.click();

        return new SettingsPage(this.driver);
    }          
}

