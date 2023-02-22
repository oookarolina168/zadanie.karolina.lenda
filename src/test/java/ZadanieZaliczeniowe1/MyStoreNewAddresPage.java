package ZadanieZaliczeniowe1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyStoreNewAddresPage {
    private final WebDriver driver;

    @FindBy(css = "#field-alias")
    private WebElement aliasInput;

    @FindBy(css = "#field-address1")
    private WebElement addressInput;

    @FindBy(css = "#field-city")
    private WebElement cityInput;

    @FindBy(css = "#field-postcode")
    private WebElement zipInput;

    @FindBy(css = "#field-id_country")
    private WebElement countrySelect;

    @FindBy(css="#field-phone")
    private WebElement phoneInput;


    @FindBy(css = "button[class='btn btn-primary form-control-submit float-xs-right']")
    private WebElement saveButton;

    public MyStoreNewAddresPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void newAddressSubmit(String alias, String address, String city, String zip, String country, String phone) {
       Select dropdown = new Select((this.countrySelect));
       dropdown.selectByVisibleText(country);

        this.aliasInput.clear();
        this.aliasInput.sendKeys(alias);
        addressInput.clear();
        addressInput.sendKeys(address);
        cityInput.clear();
        cityInput.sendKeys(city);
        zipInput.clear();
        zipInput.sendKeys(zip);
        countrySelect.clear();
        countrySelect.sendKeys(country);
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        WebElement submitAddress= driver.findElement(By.xpath("button[class='btn btn-primary form-control-submit float-xs-right']"));
        submitAddress.click();

    }
}
