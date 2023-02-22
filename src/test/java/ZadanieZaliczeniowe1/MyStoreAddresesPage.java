package ZadanieZaliczeniowe1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyStoreAddresesPage {
    private final WebDriver driver;


    @FindBy(css = "a[id='addresses-link'] span[class='link-item']")
    private WebElement MyAddress;

    @FindBy(xpath = "//article[@id='address-31424']//address[1]")
    private static List<WebElement> addressWindow;


    public MyStoreAddresesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void myWebAddress() {
        WebElement login = driver.findElement(By.cssSelector("a[title='View my customer account'] span[class='hidden-sm-down']"));
        login.click();
        WebElement addresses = driver.findElement(By.cssSelector("a[id='addresses-link'] span[class='link-item']"));
        addresses.click();
    }

    public void createdNewAddress() {
        WebElement createNewAddress = driver.findElement(By.xpath("//span[normalize-space()='Create new address']"));
        createNewAddress.click();
    }

    public static boolean addressIsVisible() {
        return addressWindow.size() < 0;
    }
    /*public static String getFirstAddressAsText() {
        WebElement addresses = addressWindow.get(0);
        String alias = addresses.findElement(By.cssSelector("#field-alias")).getText();
        String address = addresses.findElement(By.cssSelector("#field-address1")).getText();
        String city = addresses.findElement(By.cssSelector("#field-city")).getText();
        String zip = addresses.findElement(By.cssSelector("#field-postcode")).getText();
        String country = addresses.findElement(By.cssSelector("#field-id_country")).getText();
        String phone = addresses.findElement(By.cssSelector("#field-phone")).getText();
        return String.join("\n", alias, address, city, zip, country, phone);


    }*/
}