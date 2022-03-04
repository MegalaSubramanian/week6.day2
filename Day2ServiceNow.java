package steps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Day2ServiceNow extends Hooks{
	WebElement number, number1, search;
	String home, Home1, incidentID, incidentID2, incChange, number2;
	Actions builder = new Actions(driver);

	@Given("Click All")
	public void click_all() {
		driver.findElement(By.xpath("(//div[text() ='All'])[2]")).click();
		driver.switchTo().frame(0);
	}

	@Given("Click New")
	public void click_new() {
		driver.findElement(By.xpath("//button[text()='New']")).click();
		home = driver.getWindowHandle();
	}

	@Given("Click Caller lookup")
	public void click_caller_lookup() {
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String> window = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(window);
		String secondWindow = list.get(1);
		driver.switchTo().window(secondWindow);
	}

	@Given("Select the Caller from result")
	public void select_the_caller_from_result() {
		driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[3]/a")).click();
		driver.switchTo().window(home);
		driver.switchTo().frame(0);
	}

	@Given("Enter short description")
	public void enter_short_description() {
		driver.findElement(By.xpath("(//input[contains(@name,'incident.short_description')])[4]")).sendKeys("Testing");
	}

	@Given("Get the incident ID created")
	public void get_the_incident_ID_created() {
		number1 = driver.findElement(By.id("incident.number"));
		incidentID = number1.getAttribute("value");
		System.out.println(incidentID);
	}

	@Given("Click on the submit button")
	public void click_on_the_submit_button() {
		driver.findElement(By.xpath("//button[text() ='Submit']")).click();
	}
	@Given("Search for the incident ID Create")
	public void search_for_the_incident_id_create() throws InterruptedException {
		Thread.sleep(3000);
		search = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		builder.click(search).perform();
		search.sendKeys(incidentID, Keys.ENTER);
	}
	@Given("Search for the incident ID")
	public void search_for_the_incident_id() throws InterruptedException {
		Thread.sleep(3000);
		search = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		builder.click(search).perform();
		search.sendKeys(incChange, Keys.ENTER);
	}

	@Given("Search for the incident ID and validate")
	public void search_for_the_incident_id_and_validate() throws InterruptedException {
		Thread.sleep(3000);
		search = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		builder.click(search).perform();
		search.sendKeys(number2, Keys.ENTER);
		Thread.sleep(2000);
		incidentID2 = driver.findElement(By.xpath("(//tbody[@class='list2_body'])/tr[1]/td[3]")).getText();
		System.out.println(incidentID2);
		Assert.assertTrue(number2.equals(incidentID2));
		//SoftAssert sAssert = new SoftAssert();
		//sAssert.assertEquals(number2, incidentID2, "success");
	}

	@Given("Click Open")
	public void click_open() {
		driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
		driver.switchTo().frame(0);
	}

	@Given("Enter Inc Id in search box")
	public void enter_inc_id_in_search_box() {
		search = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		builder.click(search).perform();
		search.sendKeys("INC0000003", Keys.ENTER);
	}

	@Given("Select the Inc ID from result")
	public void select_the_inc_id_from_result() {
		driver.findElement(By.xpath("(//tbody[@class='list2_body'])/tr[1]/td[3]")).click();
	}

	@Given("Click assignment lookup")
	public void click_assignment_lookup() {
		WebElement assign = driver.findElement(By.id("lookup.incident.assignment_group"));
		builder.click(assign).perform();
		Set<String> window = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(window);
		home = list.get(0);
		String NewWindow = list.get(1);
		driver.switchTo().window(NewWindow);
	}

	@Given("Search for software option")
	public void search_for_software_option() {
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("software", Keys.ENTER);
	}

	@Given("Select the software option")
	public void select_the_software_option() {
		driver.findElement(By.xpath("//a[text()='Software']")).click();
		driver.switchTo().window(home);
		driver.switchTo().frame(0);
	}

	@Given("Input short decription")
	public void input_short_decription() {
		driver.findElement(By.id("activity-stream-textarea")).sendKeys("Testing");
	}

	@Given("Click update")
	public void click_update() {
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
	}

	@Given("Choose the inc ID")
	public void choose_the_inc_id() {
		number1 = driver.findElement(By.xpath("(//tbody[@class='list2_body'])/tr[9]/td[3]"));
		incChange = number1.getText();
		System.out.println(incChange);
		number1.click();

	}

	@Given("Click on the delete button")
	public void click_on_the_delete_button() {
		driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
	}

	@Given("Confirm deletion")
	public void confirm_deletion() {
		driver.findElement(By.id("ok_button")).click();
	}

	@Given("Choose the inc ID Update")
	public void choose_the_inc_id_Update() {
		driver.findElement(By.xpath("(//tbody[@class='list2_body'])/tr[2]/td[3]")).click();
	}

	@Given("Print selected Inc ID")
	public void print_selected_inc_id() {
		WebElement value = driver.findElement(By.id("incident.number"));
		number2 = value.getAttribute("value");
		System.out.println(number2);
	}

	@Given("Select state value")
	public void select_state_value() {
		Select dropdown = new Select((driver.findElement(By.xpath("//Select[@name='incident.state']"))));
		dropdown.selectByValue("2");
	}

	@Given("Select Urgency value")
	public void select_urgency_value() {
		Select dropdown1 = new Select((driver.findElement(By.xpath("//Select[@name='incident.urgency']"))));
		dropdown1.selectByValue("1");
	}

	@Given("Click on the update button")
	public void click_on_the_update_button() {
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
	}
}
