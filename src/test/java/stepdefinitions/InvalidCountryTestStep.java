package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class InvalidCountryTestStep {
    WebDriver driver;
    WebDriverWait wait;

    @Given("respondent is on survey page")
    public void respondent_is_on_survey_page() {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev.monetrewards.com/mobile_ui/#/svf/screening?l_id=231&cnt_id=15144&lp_id=177&uni_user=true&prev_btn=false");

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public WebElement waitForElementPresenceOnDOM(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
    
    @When("respondent enters age 19")
    public void respondent_enters_age_19() {
        // Wait for the age input field to appear
    	waitForElementPresenceOnDOM(By.xpath("//input[@type='number']"), 10).sendKeys("19");
//    	driver.findElement(By.xpath("//input[@type='number']")).sendKeys("19");
        
    }
    
    @When("select Gender Male")
    public void select_gender_male() {
    	waitForElementPresenceOnDOM(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c64-3 ng-star-inserted']"), 3).click();
    	waitForElementPresenceOnDOM(By.xpath("//div[@role='listbox']//span[text()=' Male ']"), 4).click();
    	
    }
    
    @When("select United States from Country dropdown")
    public void select_united_states_from_country_dropdown() {
    	By selectDropDown = By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c64-4 ng-star-inserted']");
    	By selFraLoc = By.xpath("//div[@id='cdk-overlay-1']//span[text()=' United States ']");
    	waitForElementPresenceOnDOM(selectDropDown, 3).click();
    	waitForElementPresenceOnDOM(selFraLoc, 4).click();
    }

    @When("click on Next")
    public void click_on_next() {
        // Click the button ( "Next")
    	By nextBtn = By.xpath("//span[text()='Next ']");
        waitForElementPresenceOnDOM(nextBtn, 5).click();
    }

    
    @Then("Termination message should show up")
    public void termination_message_should_show_up() {
        // Wait for the termination message
    	By terminationMsg = By.xpath("//div[@class='terminate ng-star-inserted']/div");
    	String expectedMessage = " You are not qualified for this campaign. Please try later for another survey. ";
        WebElement terminationMessage = waitForElementPresenceOnDOM(terminationMsg, 10); // Replace with actual ID
        String actualMessage = terminationMessage.getText().trim();
        System.out.println(actualMessage);
        assertEquals(actualMessage, expectedMessage.trim(), "Termination message should match.");
    }

   
}
