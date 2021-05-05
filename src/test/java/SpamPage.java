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


class SpamPage extends PageBase {

    public SpamPage(WebDriver driver) {
        super(driver);
    }

    public BinPage openBinPage(){
        By spamLinkBy = By.xpath("//a[@title='Kuka']");
        WebElement spamLink = this.waitAndReturnElement(spamLinkBy);

        spamLink.click();

        return new BinPage(this.driver);

    }

}