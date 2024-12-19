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

public class ValidCountryTestStep {
	WebDriver driver;
    WebDriverWait wait;
    
    public WebElement waitForElementPresenceOnDOM(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
    
    @When("select Australia from Country dropdown")

    public void select_united_states_from_country_dropdown() {
    	By selectDropDown = By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c64-4 ng-star-inserted']");
    	By selFraLoc = By.xpath("//div[@id='cdk-overlay-1']//span[text()=' Australia ']");
    	waitForElementPresenceOnDOM(selectDropDown, 3).click();
    	waitForElementPresenceOnDOM(selFraLoc, 4).click();
    }
    
    @Then("respondent should redirect to Welcome Page")
    public void respondent_should_redirect_to_Welcome_Page() {
        // Wait for the termination message
    	By welMessage = By.xpath("//div[@class='SetpText']/p");
    	String expectedMessage = "You have been selected to participate in an important study focusing on social media platforms and entertainment. Please be assured that the purpose of this survey is strictly to gather information and will not be used to sell you anything in the future. All of your answers will remain completely confidential and will only be viewed in aggregate with the answers from all who are selected to participate. We also ask that you keep any information, materials, or video that you may see confidential, and not share it with others in any way. We appreciate your time and thank you in advance for participating.";
        WebElement WelcomeMessage = waitForElementPresenceOnDOM(welMessage, 10); // Replace with actual ID
        String actualMessage = WelcomeMessage.getText().trim();
        System.out.println(actualMessage);
        assertEquals(actualMessage, expectedMessage.trim(), "Welcome Message should come");
    }

   
}
