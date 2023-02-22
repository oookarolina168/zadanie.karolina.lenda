package ZadanieZaliczeniowe1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.css.CSS2Properties;


//uwtorzona klada do zdefiniowania kroków
import java.time.Duration;

public class MyStoreObjectSteps {
    private WebDriver driver;
    private MyStoreAddresesPage AddresesPage;

    @Given("I'm on the MyStore main page")
    public void openMyStoreMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.findElement(By.cssSelector("a[title='Log in to your customer account'] span[class='hidden-sm-down']")).click();
    }

    @When("I go to login page")
    public void iGoToLoginPage() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        LoginMyStore loginMyStore = new LoginMyStore(driver);
        loginMyStore.loginAs("oookarolina168@wp.pl", "coderslab");
    }


    @And("I go to my addresses page")
    public void iGoToMyAddressesPage() {
        MyStoreAddresesPage MyStoreAddresesPage = new MyStoreAddresesPage(driver);
        MyStoreAddresesPage.myWebAddress();
    }

    @When("I add new address")
    public void iAddNewAddress() {
        MyStoreAddresesPage MyStoreAddresesPage = new MyStoreAddresesPage(driver);
        MyStoreAddresesPage.createdNewAddress();
    }

    @And("I enter new address")
    public void iEnterNerAddress(String alias, String address, String city, String zip, String country, String phone) {
        MyStoreNewAddresPage MyStoreNewAddresPage = new MyStoreNewAddresPage(driver);
        MyStoreNewAddresPage.newAddressSubmit("testerka", "coders", "Warszawa", "90-234", "United kingdom", "2782992");

    }
    @And("I can see new address")
    public void iCanSeeNewAddress(){
        Assertions.assertTrue(MyStoreAddresesPage.addressIsVisible());

    }
    /*@And("I verify created address {string}, {string}, {string}, {string}, {string}, {string}")
    public void iVerifyCreatedAddress(String alias, String address, String city, String zip, String country, String phone){
        String addressAsText = MyStoreAddresesPage.getFirstAddressAsText();
        String expectedAddress = String.join("\n", alias.toUpperCase(), address, city, zip, country, phone);
        Assertions.assertEquals(expectedAddress, addressAsText);

    }*/


}


