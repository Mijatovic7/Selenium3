package productsTest;

import LoginTest.Url;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyAddProductToCard {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(Url.urlLoginPage);

        //set username
        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.clear();
        inputUserName.sendKeys("standard_user");
        System.out.println(inputUserName.getAttribute("value"));

        //set password
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.clear();
        inputPassword.sendKeys("secret_sauce");

        //click on Login
        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        //nalazimo inventory_list
        WebElement inventoryList = driver.findElement(By.xpath("//div[@class='inventory_list']"));
        List<WebElement> inventorItem = inventoryList.findElements(By.xpath("//div[@class='inventory_item']"));

        for(int i = 0; i < inventorItem.size(); i++) {
            WebElement item =inventorItem.get(i);
            WebElement itemName = item.findElement(By.xpath(".//div[@class='inventory_item_name ']"));

            if (itemName.getText().equals("Sauce Labs Bolt T-Shirt")) {
                WebElement button = item.findElement(By.xpath(".//button"));
                button.click();
                System.out.println("Item added");
                break;
            }
        }
        System.out.println("");

        //lociramo korpu
        WebElement card = driver.findElement(By.xpath("//a[@class='shooping_cart_link']"));
        WebElement cartSpan = (WebElement) card.findElements(By.xpath(".//span"));
        System.out.println(cartSpan.getText());

        Assert.assertEquals("Cart number is not as expected", "1", cartSpan.getText());

        driver.quit();
    }
}
