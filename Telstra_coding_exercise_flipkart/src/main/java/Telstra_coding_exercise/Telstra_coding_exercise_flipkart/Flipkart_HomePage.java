package Telstra_coding_exercise.Telstra_coding_exercise_flipkart;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.BaseClass;

/* execute the Flipkart_HomePage.java from this class
*  search the product using searchbar
*  select the random item or show the empty link*/
public class Flipkart_HomePage extends BaseClass 
{

	// Store the Elements
	@FindBy(xpath = "//input[@name='q']")
	WebElement searchBar;
	@FindBy(xpath = "//button[@class='vh79eN']")
	WebElement searchButton;
	@FindBy(xpath = "//div[@class='_1HmYoV _35HD7C']")
	WebElement boxArea;
	By links = By.xpath("//a");

	// Store the elements in Pagefactory
	public Flipkart_HomePage(WebDriver driver) 
	{

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	

	// search for product
	public void Search(String product) 
	{
		int count=0;
		while (count < 4) 
		{
			   try 
			   {
				   
			    //If exception generated that means It Is not able to find element then catch block will handle It.
				   entertext(searchBar, product);
					click(searchButton);  
					break;
			   }
			   catch (StaleElementReferenceException e) 
			   {
			    e.toString();
			    System.out.println("Trying to recover from a stale element :" + e.getMessage());
			    count = count + 1;
			   }
			   
		}
		

	}

	// Select the Product
	public void selectItem() throws InterruptedException 
	{
		// select the particular box area
		// select the elements in the selected box area
		listOfElements(boxArea, links);
		System.out.println(listOfElements(boxArea, links).size());
		// selects the random element
		WebElement link = listOfElements(boxArea, links)
				.get(new Random().nextInt(listOfElements(boxArea, links).size()));
		// if selected element is valid element
		if (link.isDisplayed()) 
		{
			System.out.println(link.getText());
			
			if (!link.getAttribute("href").isEmpty()) 
			{
				link.click();
			}
		}
		// else selected element is not valid
		else 
		{
			System.out.println("link is not displayed");
		}

	}

}
