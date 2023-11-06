package LoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LoginPage {

    public ChromeDriver driver;

    public LoginPage(ChromeDriver driver){
        this.driver = driver;

    }

    public void openPage(){
        driver.get("https://www.saucedemo.com/");
    }


    //metode za lociranje web elemenata


    public WebElement returnUserName() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement returnPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement returnLogin() {
        return driver.findElement(By.id("login-button"));
    }

    //metode za akcije nad web elementima


    public void setUserName(String userName){
        returnUserName().sendKeys(userName);
    }

    public void setPassword(String password){
        returnPassword().sendKeys(password);
    }

    public void clickOnLogin(){
        returnLogin().click();
    }

    public String getCurrentURL (){
       return driver.getCurrentUrl();

    }

    public String getErrorMessage(){
        WebElement getErrorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
       return getErrorMessage.getText();


    }

    public void closePage(){
        driver.quit();
    }


}

