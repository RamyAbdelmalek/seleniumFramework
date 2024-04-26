package steps;

import org.testng.Assert;

import com.github.javafaker.Faker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.UserLoginPage;
import tests.TestBase;

public class AdminPrivileges extends TestBase {

	UserLoginPage loginObject;
	DashboardPage dashboardObject;
	Faker fakeData = new Faker();
	String fakeUser = fakeData.name().username();

	@Given("Admin can Login with his credentials")
	public void admin_can_login_with_his_credentials() {
		loginObject = new UserLoginPage(driver);
		loginObject.login("Admin", "admin123");
	}
	@Then("The dashboard displayed successfully")
	public void the_dashboard_displayed_successfully() {
		Assert.assertTrue(loginObject.loginSuccess.getText().contains("Dashboard"));
	}

	@When("Admin open user management page")
	public void admin_open_user_management_page() {
		dashboardObject = new DashboardPage(driver);
	    dashboardObject.clickAdmin();
	 
	}
	@And("He add new user")
	public void he_add_new_user() throws InterruptedException {
		dashboardObject = new DashboardPage(driver);
		 dashboardObject.addUser();
		
		 
	}
	@Then("User will be added successfully")
	public void user_will_be_added_successfully() {
		dashboardObject = new DashboardPage(driver);
		dashboardObject.checkUserAdded();
	
	}
	
	@Given("Admin want to delete added user")
	public void admin__want_to_delete_added_user() {
		dashboardObject = new DashboardPage(driver);
		dashboardObject.deleteUser();
	}
	
	
	@Then("User will be removed successfully")
	public void user_will_be_removed_successfully() {
		dashboardObject = new DashboardPage(driver);
		dashboardObject.checkUserDeleted();
	}
	
}
