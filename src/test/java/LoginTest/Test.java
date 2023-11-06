package LoginTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
      //pozitivan test,
    public static void main (String[] args) {

       final String urlProductsPage = "https://www.saucedemo.com/inventory.html";
       final String urlLoginPage = "https://www.saucedemo.com";

        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        //set username
       WebElement inputUserName = driver.findElement(By.id("user-name"));
       inputUserName.sendKeys("standard_user");

       //set password
       WebElement inputPassword = driver.findElement(By.id("password"));
       inputPassword.sendKeys("secret_sauce");

       //click on Login
        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        //validacija, potvrda da li je test prosao/pao
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        //junit
        Assert.assertEquals(currentUrl, urlProductsPage );

        if(currentUrl.equals(urlProductsPage)){
            System.out.println("PASSED");
        }
        else{
            System.out.println("FAILED");
        }

        driver.quit();

    }
}
