package Telstra_coding_exercise.Telstra_coding_exercise_flipkart;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.BaseClass;

public class Flipkart_HomePage extends BaseClass {
	// Store the Elements
	By searchBar = By.xpath("//input[@name='q']");
	By searchButton = By.xpath("//button[@class='vh79eN']");
	By boxArea = By.xpath("//div[@class='_1HmYoV _35HD7C']");

	// search for product
	public void Search(String product) {
		entertext(searchBar, product);
		click(searchButton);
	}

	// Select the Product
	public void selectItem() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// select the particular box area
		WebElement box = selectElement(boxArea);
		// select the elements in the selected box area
		List<WebElement> links = box.findElements(By.xpath("//a"));
		System.out.println(links.size());
		// selects the random element
		WebElement link = links.get(new Random().nextInt(links.size()));
		// if selected element is valid element
		if (link.isDisplayed()) {
			System.out.println(link.getText());
			if(!link.getAttribute("href").isEmpty()) {
			link.click();
			}
		}
		// else selected element is not valid
		else {
			System.out.println("link is not displayed");
		}

	}

}
