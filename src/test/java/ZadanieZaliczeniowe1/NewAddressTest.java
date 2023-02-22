package ZadanieZaliczeniowe1;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/NewAddressVerification.feature", plugin = {"pretty", "html:out.html"})

public class NewAddressTest {


    @AfterTest
    public void afterTest() {
        try {
            Thread.sleep(1000);
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }
}
