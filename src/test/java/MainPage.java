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


class MainPage extends PageBase {
    
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("http://www.freemail.hu");
    }    
    
    public ProfilePage login(String username, String password) {
        By usernameBy = By.id("username");
        By passwordBy = By.id("password");

        WebElement usernameField = this.waitAndReturnElement(usernameBy);
        WebElement passwordField = this.waitAndReturnElement(passwordBy);

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        By loginBy = By.name("loginBtn");

        WebElement loginButton = this.waitAndReturnElement(loginBy);

        loginButton.click();

        return new ProfilePage(this.driver);

    }
    
}
