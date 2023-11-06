package LoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLoginWithoutUserName {
    //negativan test, kucamo validan password
    public static void main (String[] args) {

        final String urlProductsPage = "https://www.saucedemo.com/inventory.html";

        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(urlProductsPage);

        //set username
        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.clear();

        //set password
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        //click on Login
        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        //validacija, potvrda da li je test prosao/pao
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        if(currentUrl.equals("https://www.saucedemo.com")){
            System.out.println("PASSED");
        }
        else{
            System.out.println("FAILED");
        }

        driver.quit();

    }
}
