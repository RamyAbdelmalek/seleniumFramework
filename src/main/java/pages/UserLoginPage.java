package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase {
	


	public UserLoginPage(WebDriver driver) {
		super(driver);
	
	}

	@FindBy(name  = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement loginBTN;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6")
	public WebElement loginSuccess;

	public void login(String Username, String Password) {
		setText(username, Username);
		setText(password, Password);
		clickButton(loginBTN);

	}

}
