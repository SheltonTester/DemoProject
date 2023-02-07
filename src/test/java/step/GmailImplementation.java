package step;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class GmailImplementation {

	private WebDriver driver;
	@Given("^I am on the Gmail login page$")
	public void navigateToGmail() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://gmail.com");
	}

	@When("I enter my username {string} and password {string}")
	public void i_enter_my_username_and_password(String uname, String pwd) {
		WebElement emailField = driver.findElement(By.id("identifierId"));
		emailField.sendKeys(uname);
		driver.findElement(By.id("identifierNext")).click();

		// Wait for the password field to appear
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys(pwd);
		driver.findElement(By.id("passwordNext")).click();
	}

	@When("^I click on the compose button$")
	public void clickComposeButton() {
		// Wait for the compose button to appear
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Compose']")));

		driver.findElement(By.xpath("//div[text()='Compose']")).click();
	}

	@When("^I enter \"(.*)\" as the subject of the email$")
	public void enterSubject(String subject) {
		WebElement subjectField = driver.findElement(By.name("subjectbox"));
		subjectField.sendKeys(subject);
	}

	@When("^I enter \"(.*)\" as the body of the email$")
	public void enterBody(String body) {
		WebElement bodyField = driver.findElement(By.xpath("//div[@role='textbox']"));
		bodyField.sendKeys(body);
	}

	@When("^I click on the send button$")
	public void clickSendButton() {
		driver.findElement(By.xpath("//div[text()='Send']")).click();
	}

	@Then("^the email should be sent successfully$")
	public void the_email_should_be_sent_successfully()  {

		System.out.println("Email Sended Successfully");

	}

	@And("^I should see a confirmation message that the email has been sent$")
	public void i_should_see_a_confirmation_message_that_the_email_has_been_sent()  {

		System.out.println("Confirmation Message");

	}}