package Telstra_coding_exercise.Telstra_coding_exercise_flipkart;

import org.openqa.selenium.By;

import Utility.BaseClass;

public class Flipkart_loginPage extends BaseClass {

	// Store the Elements
	By username = By.xpath("//input[@class='_2zrpKA _1dBPDZ']");
	By password = By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']");
	By loginbutton = By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']");

	// login with Valid data
	public void getlogin(String user, String pwd) {
		entertext(username, user);
		entertext(password, pwd);
		click(loginbutton);
	}

}
