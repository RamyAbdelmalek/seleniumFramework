package pages;


import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;


public class DashboardPage extends PageBase{

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	String user = "User1";
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")
	WebElement adminBtn;
	
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
	WebElement eRecords; 
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
	WebElement addBtn;
	
	@FindBy(xpath= "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")
	WebElement role;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]")
	WebElement admin;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[1]/div[1]")
	WebElement status;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]")
	WebElement enabled;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")
	WebElement employee;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]")
	WebElement ename;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")
	WebElement uname;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")
	WebElement pass;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")
	WebElement cPass;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")
	WebElement save;
	
	@FindBy(className = "oxd-table-body")
	WebElement usersTable;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
	WebElement searchField;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
	WebElement searchBtn;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div/button[1]/i")
	WebElement delete;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
	WebElement confirm;
	
	
	public void clickAdmin() {
		
		// Clicking on Admin tab
		clickButton(adminBtn);
	}
	
	
	
	public void addUser() throws InterruptedException  {
		
		// Checking records before adding user and increment it by 1 to assert it later
		String sRecords = eRecords.getText();
		String sRecordsBeforeAdd = ((String) sRecords).replaceAll("[^0-9]","");
		int recordsToAssert = Integer.parseInt(sRecordsBeforeAdd) +1 ;
		
		// Adding new user
		clickButton(addBtn);
		clickButton(role);
		clickButton(admin);
		clickButton(status);
		clickButton(enabled);
		clickButton(employee);
		setText(employee, "a");
		Thread.sleep(3000);
		clickButton(ename);
		setText(uname, user);
		setText(pass, "user123");
		setText(cPass, "user123");
		clickButton(save);
		
		// Verifying that records increased by 1 
		String xRecords = eRecords.getText();
		String sRecordsAfterAdd = ((String) xRecords).replaceAll("[^0-9]","");
		int finalRecords = Integer.parseInt(sRecordsAfterAdd) ;
		Assert.assertEquals(recordsToAssert, finalRecords);
		
	}
	
	public void checkUserAdded() {
		
		// Assert Users contains added user
		Assert.assertTrue(usersTable.getText().contains(user));
	
	}


	public void deleteUser() {
		// Checking records before deleting user and subtract 1 to assert it later
		String sRecords = eRecords.getText();
		String sRecordsBeforeAdd = ((String) sRecords).replaceAll("[^0-9]","");
		int recordsToAssert = Integer.parseInt(sRecordsBeforeAdd) -1 ;
		
		// Deleting added user
		setText(searchField, user);
		clickButton(searchBtn);
		clickButton(delete);
		clickButton(confirm);
		
		// Navigating to user management page to check records
		clickButton(adminBtn);
		
		// Verifying that records decreased by 1 
		String xRecords = eRecords.getText();
		String sRecordsAfterAdd = ((String) xRecords).replaceAll("[^0-9]","");
		int finalRecords = Integer.parseInt(sRecordsAfterAdd) ;
		Assert.assertEquals(recordsToAssert, finalRecords);
		
	}
	
	public void checkUserDeleted() {
		
		// Assert Users contains added user
		Assert.assertFalse(usersTable.getText().contains(user));
	}
	


	

	}
	

