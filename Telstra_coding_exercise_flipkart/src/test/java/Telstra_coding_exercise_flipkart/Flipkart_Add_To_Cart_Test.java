package Telstra_coding_exercise_flipkart;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Telstra_coding_exercise.Telstra_coding_exercise_flipkart.Flipkart_Add_To_Cart;
import Telstra_coding_exercise.Telstra_coding_exercise_flipkart.Flipkart_HomePage;
import Telstra_coding_exercise.Telstra_coding_exercise_flipkart.Flipkart_loginPage;
import Utility.BaseClass;

/*1.execute the Flipkart_loginPage.java from this class
 *  verify the login page with valid data 
 *  execution of login page present in this class
 *  parameters userName=7989985123 and passWord=Abc123  
 *2.execute the Flipkart_HomePage.java from this class
 *  search the product using searchbar
 *  select the random item or show the empty link
 *3.execute the Flipkart_Add_To_Cart.java from this class
 *  select the product using mouse over actions
 *  elements were identified from this class to select the product 
 *  javaScript is used in this class to use scroll and to select the element*/
public class Flipkart_Add_To_Cart_Test extends BaseClass {

	@Test
	public void login() throws InterruptedException {
		try {

			// login To Flipkart
			Flipkart_loginPage login = new Flipkart_loginPage(driver);
			login.getlogin(readconfig("username"), readconfig("password"));
			assertEquals(pagetitle(), readconfig("select_page_title"));

			// Search in Homepage
			Flipkart_HomePage homepage = new Flipkart_HomePage(driver);
			homepage.Search(readconfig("search"));
			homepage.selectItem();
			// Select the item
			Flipkart_Add_To_Cart Selectitem = new Flipkart_Add_To_Cart(driver);
			// verify the No.Of Windows present
			if (verify_windows().size() > 1) {

				Selectitem.selectingProduct();

			} else {
				Selectitem.selecting_product_with_JS_MA();
				assertEquals(pagetitle(), readconfig("Title"));
			}

		} catch (IOException e) {

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
