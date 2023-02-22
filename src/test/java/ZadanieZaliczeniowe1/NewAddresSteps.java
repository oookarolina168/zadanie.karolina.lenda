package ZadanieZaliczeniowe1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewAddresSteps {
    private WebDriver driver;
    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("^User is logged in to CodersLab shop$")
    public void userIsLooggedInToCodersLabShop() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        LoginMyStore loginMyStore = new LoginMyStore(driver);
        loginMyStore.loginAs("oookarolina168@wp.pl", "coderslab");
        sleep();
    }

    @When("User goes to AddressPage")
    public void user_goes_to_address_page() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");
        LoginElements userLoginPage = new LoginElements(driver);
    }

    @And("The user clicks Create new address")
    public void the_user_clicks_create_new_adress() {
        driver.findElement(By.xpath("//span[normalize-space()='Create new address']")).click();
    }

    @And("^User enters alias (.+) address (.+) city (.+) zip (.+) country (.+) and phone (.+)$")
    public void user_enters_alias_address_city_zip_country_phone(String alias, String address, String city, String zip, String country, String phone) {
        driver.findElement(By.name("alias")).sendKeys(alias);
        driver.findElement(By.name("address1")).sendKeys(address);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("postcode")).sendKeys(zip);
        driver.findElement(By.name("id_country")).sendKeys(country);
        driver.findElement(By.name("phone")).sendKeys(phone);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

    }

    @Then("User sees success message with text {string}")
    public void user_sees_success_message_with_text(String msgText) {
        WebElement alert = driver.findElement(By.xpath("(//li[normalize-space()='Address successfully added!'])[1]"));
        assertTrue(alert.isDisplayed());
        assertEquals(msgText, alert.getText());
    }

    @And("User closes MyStore browser")
    public void user_closes_MyStore_browser() {
        driver.quit();
    }

}

