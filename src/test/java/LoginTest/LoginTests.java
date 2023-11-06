package LoginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTests {
    @Test
    public void verifyLoginWithValidCredentials(){
        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLogin();

        //TODO assertion
        Assert.assertEquals (loginPage.getCurrentURL(), "https://www.saucedemo.com/");

        loginPage.closePage();


    }
    @Test
    public void verifyLoginWithoutUserName(){
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName(" ");

    }

}
