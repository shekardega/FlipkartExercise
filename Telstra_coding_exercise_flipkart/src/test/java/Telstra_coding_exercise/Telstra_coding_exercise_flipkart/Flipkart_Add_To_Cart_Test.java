package Telstra_coding_exercise.Telstra_coding_exercise_flipkart;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.BaseClass;

public class Flipkart_Add_To_Cart_Test extends BaseClass {

	@Test
	public void login() throws InterruptedException {
		try {

			// login To Flipkart
			Flipkart_loginPage login = new Flipkart_loginPage();
			login.getlogin(readconfig("username"), readconfig("password"));
			assertEquals(pagetitle(), readconfig("select_page_title"));

			// Search in Homepage
			Flipkart_HomePage homepage = new Flipkart_HomePage();

			Thread.sleep(3000);
			homepage.Search(readconfig("search"));
			homepage.selectItem();

			// Select the item
			Flipkart_Add_To_Cart Selectitem = new Flipkart_Add_To_Cart();

			// verify the No.Of Windows present
			if (verify_windows().size() > 1) {

				Selectitem.selectingProduct();
				System.out.println(pagetitle());

			} else {
				Selectitem.selecting_product_with_JS_MA();
				System.out.println(pagetitle());
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
