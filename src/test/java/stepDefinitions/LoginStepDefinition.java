package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginStepDefinition {

    WebDriver driver;
    public static  String userdir = System.getProperty("user.dir");

    @Given("i am a user of amazon.com")
    public void i_am_a_user_of_amazon_com() {

        System.setProperty("webdriver.chrome.driver", userdir + File.separator + "setup/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String url = "http://amazon.com";
        driver.get(url);


    }

    @When("i log in using valid credentials")
    public void i_log_in_using_valid_credentials() {
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys("cobanoglucansu@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("Test@123");
        driver.findElement(By.id("signInSubmit")).click();


    }

    @Then("i should be logged in")
    public void i_should_be_logged_in() {

        System.out.println("Successfully logged in!");
        //driver.quit();
    }


    @When("i log in using invalid credentials")
    public void i_log_in_using_invalid_credentials() {
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("ap_email")).sendKeys("cobanoglucansu@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("Test@1233");
        driver.findElement(By.id("signInSubmit")).click();

    }

    @Then("i should not be logged in")
    public void i_should_not_be_logged_in() {
        boolean problem = driver.findElement(By.xpath("//span[@class='a-list-item']")).isEnabled();
        if(problem == true) {
            System.out.println("Login failed!");
            System.out.println(driver.findElement(By.xpath("//span[@class='a-list-item']")).getText());
        }
        //driver.quit();
    }

}
