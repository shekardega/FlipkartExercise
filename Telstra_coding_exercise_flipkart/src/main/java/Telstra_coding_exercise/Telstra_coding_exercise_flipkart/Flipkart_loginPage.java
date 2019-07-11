package Telstra_coding_exercise.Telstra_coding_exercise_flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*verify the login page with valid data 
 * all the elements of login page present in this class
 * parameters userName=7989985123 and passWord=Abc123  */

import Utility.BaseClass;

public class Flipkart_loginPage extends BaseClass {

	// Store the Elements
	@FindBy(xpath = "//input[@class='_2zrpKA _1dBPDZ']")
	WebElement username;
	@FindBy(xpath = "//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	WebElement password;
	@FindBy(xpath = "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement loginbutton;

	// Store the elements in Pagefactory
	public Flipkart_loginPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// login with Valid data
	public void getlogin(String user, String pwd) {
		entertext(username, user);
		entertext(password, pwd);
		click(loginbutton);
	}

}
