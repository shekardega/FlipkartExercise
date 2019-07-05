package Telstra_coding_exercise.Telstra_coding_exercise_flipkart;

import org.openqa.selenium.By;

import Utility.BaseClass;

public class Flipkart_Add_To_Cart extends BaseClass {

	// Store the Elements
	By electronics = By.xpath("//li[1]/span[@class='_1QZ6fC _3Lgyp8']");
	By camera = By.xpath("//a[@title='Camera']");
	By selectcamera = By.xpath("//a[@title='Canon EOS 6D Mark II DSLR Camera (Body Only)']");
	By addtocart = By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']");
	By account = By.xpath("//div[@class='_2aUbKa']");
	By logout = By.xpath("//li[10]/a[@class='_2k68Dy']");
	By backToTop = By.xpath("//span[text()='Back to top']");

	// Select Product
	public void selectingProduct() throws InterruptedException {

		switchtowindow(parentWindow());
		click(addtocart);
		Thread.sleep(3000);
		Mouse_Over_Actions(selectElement(account));
		click(logout);
	}

	// Selecting the product with help of JavaScript And Mouse Over Action
	public void selecting_product_with_JS_MA() throws InterruptedException {

		Thread.sleep(3000);
		Mouse_Over_Actions(selectElement(electronics));
		Thread.sleep(3000);
		Mouse_Over_Actions(selectElement(camera));
		click(camera);
		Scroll_To_element(selectElement(selectcamera));
		switchtowindow(parentWindow());
		click(addtocart);
		Thread.sleep(3000);
		Mouse_Over_Actions(selectElement(account));
		click(logout);
	}

}
