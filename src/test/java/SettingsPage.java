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


class SettingsPage extends PageBase {

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public void toggleSound(int on){
        this.toggleOption(on, "dropdownMenu-14", "settings-general-notification-sound");
    }

    public void toggleBin(int on){
        this.toggleOption(on, "dropdownMenu-12", "settings-general-logout-clear-trash");
    }

    public void togglePicturePreview(int on){
        this.toggleOption(on, "dropdownMenu-13", "settings-general-attachment-preview");
    }
         
    public void toggleOption(int on, String dropDownId, String optionId){
        By optionButtonBy = By.id(dropDownId);
        WebElement optionDropDown = this.waitAndReturnElement(optionButtonBy);
        
        optionDropDown.click();

        By toggleOptionBy = null;

        if(on == 1){
            toggleOptionBy = By.xpath("//div[@id='" + optionId + "']/ul/li[1]/a[1]");
        }else{
            toggleOptionBy = By.xpath("//div[@id='" + optionId + "']/ul/li[2]/a[1]");
        }
        WebElement toggleOptionLink = this.waitAndReturnElement(toggleOptionBy);

        toggleOptionLink.click();

        By submitButtonBy = By.xpath("//form[1]/div[8]/div[1]/button[1]");
        WebElement submitButton = waitAndReturnElement(submitButtonBy);

        submitButton.submit();

    }
    
    public SpamPage openSpamPage(){
        By spamLinkBy = By.xpath("//a[@title='Spam']");
        WebElement spamLink = this.waitAndReturnElement(spamLinkBy);

        spamLink.click();

        return new SpamPage(this.driver);

    }

}