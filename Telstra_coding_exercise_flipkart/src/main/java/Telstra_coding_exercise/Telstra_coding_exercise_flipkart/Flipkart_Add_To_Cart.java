package Telstra_coding_exercise.Telstra_coding_exercise_flipkart;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*select the product using mouse over actions
 *elements were identified from this class to select the product 
 *javaScript is used in this class to use scroll and to select the element*/

import Utility.BaseClass;

public class Flipkart_Add_To_Cart extends BaseClass 
{

	// Store the Elements
	@FindBy(xpath = "//li[1]//span[text()='Electronics']")
	WebElement electronics;
	@FindBy(xpath = "//a[@title='Camera']")
	WebElement camera;
	@FindBy(xpath = "//div[@class='_1GRhLX RkmWDR']")
	WebElement selectCamera;
	@FindBy(xpath = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement addtocart;
	@FindBy(xpath = "//div[@class='_2aUbKa']")
	WebElement account;
	@FindBy(xpath = "//li[10]/a[@class='_2k68Dy']")
	WebElement logout;
	@FindBy(xpath = "//span[text()='Back to top']")
	WebElement backToTop;
	By links = By.xpath("//a");
	String cameras;

	// Store the elements in Pagefactory
	public Flipkart_Add_To_Cart(WebDriver driver) 
	{

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Select Product
	public void selectingProduct() throws InterruptedException 
	{

		switchtowindow(parentWindow());
		if (explicitwait(30).until(ExpectedConditions.elementToBeClickable(addtocart)).isEnabled()) 
		{
			click(addtocart);
		}

		click(account);
		click(logout);
	}

	// Selecting the product with help of JavaScript And Mouse Over Action
	public void selecting_product_with_JS_MA() throws InterruptedException {

		for (int i = 0; i < 4; i++) 
		{
			try 
			{
				// explicitwait(30).until(ExpectedConditions.elementToBeSelected(electronics));

				click(electronics);
				click(camera);
				break;

			} 
			catch (ElementNotInteractableException e)
			{

			}
		}
		listOfElements(selectCamera, links);

		System.out.println(listOfElements(selectCamera, links).size());
		// selects the random element
		WebElement link = listOfElements(selectCamera, links)
				.get(new Random().nextInt(listOfElements(selectCamera, links).size()));
		// if selected element is valid element
		if (link.isDisplayed()) 
		{
			System.out.println(link.getText());
			if (!link.getAttribute("href").isEmpty()) 
			{
				link.click();
				cameras = "found";
			}
		}
		// else selected element is not valid
		else 
		{
			cameras = "not_found";
			System.out.println("link is not displayed");
		}

		if (cameras.equals("found"))
		{
			for (int i = 0; i < 4; i++)
			{
				try
				{
					if (verify_windows().size() > 1) 
					{
						switchtowindow(parentWindow());
						click(addtocart);
						click(account);
						click(logout);
						break;
					}
				} 
				catch (ElementNotInteractableException e) 
				{

				}
			}
		}
		else
		{
			System.out.println("selected link is not displayed(or)enabled");
		}
	}

}
