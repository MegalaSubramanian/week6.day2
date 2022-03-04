package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2TestLeaf extends Baseclass{
	String leadID;
	List<String> allhandles2;
	List<String> allhandles;
	
	//@Given("Click on Leads link")
	//public void leadslink() throws InterruptedException {
		//Thread.sleep(5000);
		//driver.findElement(By.linkText("Leads")).click();
	//}	
	@Given("Click on Create Leads button")
	public void click_on_create_leads_button() throws InterruptedException {
	Thread.sleep(3000);
		driver.findElement(By.linkText("Create Lead")).click();
	}

			@Given("Enter CompanyName as {string}")
	public void enter_company_name_as(String companyname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyname);
	}

	@Given("Enter FirstName as {string}")
	public void enter_first_name_as(String firstname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstname);
	}

	@Given("Enter LastName as {string}")
	public void enter_last_name_as(String lastname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastname);
	}

	@Given("Click on Create Lead button")
	public void click_on_create_lead_button() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Given("Click on Find Leads button")
	public void click_on_find_leads_button() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@Given("Click on the phone tab")
	public void click_on_the_phone_tab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@Given("Enter the phone number as {int}")
	public void enter_the_phone_number_as(int phonenumber) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(""+phonenumber);
	}

	@Given("Click on Find the Leads button")
	public void click_on_the_find_leads_button() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@Given("Save the Lead ID as leadId")
	public void Save_the_Lead_ID_as_leadId() throws InterruptedException {
		Thread.sleep(2000);
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();
	}
	@Given("Click on the Lead ID for Merge from the result")
	public void clickleadIDMerge() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(allhandles2.get(0));
	}
	
	@Given("Click on the Lead ID from the result")
	public void Click_on_the_Lead_ID_from_the_result() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@Given("Click on the Delete Lead button")
	public void click_on_the_delete_lead_button() {
		driver.findElement(By.linkText("Delete")).click();
	}

	@Given("Click on Find Leads")
	public void click_on_find_leads() {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@Given("Enter the leadID in Lead ID tab")
	public void enter_the_lead_id_in_lead_id_tab() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	}

	@Then("Validate the result")
	public void validate_the_result() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
	}

	@Given("Click on the Duplicate Lead button")
	public void click_on_the_duplicate_lead_button() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}

	@Given("Click on the Edit button")
	public void click_on_the_edit_lead_button() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@Given("Change the Company name as {string}")
	public void change_the_company_name_as(String company) {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(company);
	}

	@Given("Click on Merge Leads button")
	public void click_on_merge_leads_button() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.linkText("Merge Leads")).click();
	}

	@Given("Click on the lookup against From Lead")
	public void click_on_the_lookup_against_from_lead() {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
	}

	@Given("Enter the FirstName for Merge1 as {string}")
	public void enter_the_first_name_for_merge1_as(String merge1) {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(merge1);
	}

	@Given("Click on the Search button")
	public void click_on_the_search_button() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@Given("Save the Lead ID as {string}")
	public void save_the_lead_id_as(String string) throws InterruptedException {
		Thread.sleep(1000);
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	}
	@Given("Click on the lookup against To Lead")
	public void click_on_the_lookup_against_to_lead() {
		driver.switchTo().window(allhandles.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> allWindows2 = driver.getWindowHandles();
		allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
	}

	@Given("Enter the FirstName for Merge2 as {string}")
	public void enter_the_first_name_for_merge2_as(String merge2) {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(merge2);
	}

	@Given("Click on the Merge button")
	public void click_on_the_merge_button() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
	}

	@Given("Click ok on the alert")
	public void click_ok_on_the_alert() {
		driver.switchTo().alert().accept();
	}

	@Given("Search for the saved {string}")
	public void search_for_the_saved(String string) {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@Then("Validate if text is displayed")
	public void validate_if_is_displayed() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
	}
}
