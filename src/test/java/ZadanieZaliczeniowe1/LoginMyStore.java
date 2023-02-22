package ZadanieZaliczeniowe1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginMyStore {
    private final WebDriver driver;

    public LoginMyStore(WebDriver driver) {
        this.driver=driver;
    }
    public void loginAs(String email, String password) {
        WebElement loginInput = driver.findElement(By.xpath("//input[@id='field-email']"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='field-password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement signInButton = driver.findElement(By.xpath("//button[@id='submit-login']"));
        signInButton.click();
    }
    public String getLoggedUsername() {
        WebElement userName = driver.findElement(By.xpath("//a[@class='account']"));
        return userName.getText();
    }
}
