package Telstra_coding_exercise.Telstra_coding_exercise_flipkart;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.BaseClass;

public class Flipkart_loginPage_test extends BaseClass {
	@Test
	public void login() {
		try {
			// login To Flipkart
			Flipkart_loginPage login = new Flipkart_loginPage();
			login.getlogin(readconfig("username"), readconfig("password"));
			assertEquals(pagetitle(), readconfig("select_page_title"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		// OpenBrowser
		openbrowser(readconfig("browser"));
		// OpenApplication
		openapplication(readconfig("url"));
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (!result.isSuccess()) {
			Screenshot(this.getClass().getName());
		}
		// QuitBrowser
		Quitbrowser();
	}
}
