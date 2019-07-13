package Telstra_coding_exercise_flipkart;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Telstra_coding_exercise.Telstra_coding_exercise_flipkart.Flipkart_HomePage;
import Telstra_coding_exercise.Telstra_coding_exercise_flipkart.Flipkart_loginPage;
import Utility.BaseClass;
/* execute the Flipkart_HomePage.java from this class
*  search the product using searchbar
*  select the random item or show the empty link*/
public class Flipkart_homepage_test extends BaseClass 
{

	@Test
	public void login() throws InterruptedException 
	{
		try 
		{
			// login To Flipkart
			Flipkart_loginPage login = new Flipkart_loginPage(driver);
			login.getlogin(readconfig("username"), readconfig("password"));
			assertEquals(pagetitle(), readconfig("select_page_title"));

			// Search in Homepage
			Flipkart_HomePage homepage = new Flipkart_HomePage(driver);
			homepage.Search(readconfig("search"));
			homepage.selectItem();

		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod() throws IOException 
	{
		// OpenBrowser
		openbrowser(readconfig("browser"));
		// OpenApplication
		openapplication(readconfig("url"));
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException 
	{
		if (!result.isSuccess()) 
		{
			Screenshot(this.getClass().getName());
		}
		// QuitBrowser
		Quitbrowser();
	}
}
