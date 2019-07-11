package Telstra_coding_exercise.Telstra_coding_exercise_flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*select the product using mouse over actions
 *elements were identified from this class to select the product 
 *javaScript is used in this class to use scroll and to select the element*/

import Utility.BaseClass;

public class Flipkart_Add_To_Cart extends BaseClass {

	// Store the Elements
	@FindBy(xpath = "//li[1]/span[@class='_1QZ6fC _3Lgyp8']")
	WebElement electronics;
	@FindBy(xpath = "//a[@title='Camera']")
	WebElement camera;
	@FindBy(xpath = "//a[@title='Canon EOS 6D Mark II DSLR Camera (Body Only)']")
	WebElement selectcamera;
	@FindBy(xpath = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement addtocart;
	@FindBy(xpath = "//div[@class='_2aUbKa']")
	WebElement account;
	@FindBy(xpath = "//li[10]/a[@class='_2k68Dy']")
	WebElement logout;
	@FindBy(xpath = "//span[text()='Back to top']")
	WebElement backToTop;

	// Store the elements in Pagefactory
	public Flipkart_Add_To_Cart(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	
	// Select Product
		public void selectingProduct() throws InterruptedException {

			switchtowindow(parentWindow());
			click(addtocart);
			
			Mouse_Over_Actions(account);
			click(logout);
		}

	// Selecting the product with help of JavaScript And Mouse Over Action
	public void selecting_product_with_JS_MA() throws InterruptedException {

		Mouse_Over_Actions(electronics);
		Mouse_Over_Actions(camera);
		click(camera);
		Scroll_To_element(selectcamera);
		switchtowindow(parentWindow());
		click(addtocart);
		Mouse_Over_Actions(account);
		click(logout);
	}

}
