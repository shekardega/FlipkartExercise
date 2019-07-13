package Utility;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/*base class is used as parent class to all the other class present in the package
 * all the reusable methods present in this class */
public class BaseClass 
{
	public static WebDriver driver;

	// OPenBrowser
	public void openbrowser(String browser) 
	{
		if (browser.contains("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",
					"..\\Telstra_coding_exercise_flipkart\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.contains("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",
					"..\\Telstra_coding_exercise_flipkart\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}
	
	// OpenApplication
	public void openapplication(String url) throws IOException 
	{
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

	}
	public WebDriverWait explicitwait(int i) 
	{
		WebDriverWait wait =new WebDriverWait(driver, i);
		return wait;
		
	}

	// For Multiple Elements
	public List<WebElement> listOfElements(WebElement element,By by) 
	{
		List<WebElement> elements = element.findElements(by);
		return elements;
	}

	// For Single Elemet
	public WebElement selectElement(By object) 
	{
		WebElement element = driver.findElement(object);
		return element;
	}

	// SendKeys To TextBox
	public void entertext(WebElement element, String text) 
	{

		element.clear();
		element.sendKeys(text);
		
	}

	// Get current Single Window
	public String parentWindow() 
	{
		String parent = driver.getWindowHandle();
		return parent;
	}

	// Get All The Multiple Windows
	public Set<String> verify_windows()
	{
		Set<String> windows = driver.getWindowHandles();
		return windows;
	}

	// SwitchToWindow
	public void switchtowindow(String parent)
	{
		Set<String> windows = driver.getWindowHandles();
		for (String child : windows)
		{
			if (!parent.equals(child)) 
			{
				driver.switchTo().window(child);
				break;
			}
		}
	}

	// Scroll To Element
	public void Scroll_To_element(WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		js.executeScript("arguments[0].click()", element);
	}

	// Mouse Actions
	public void Mouse_Over_Actions(WebElement element) 
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	// To Click Element
	public void click(WebElement element)
	{
		element.click();
	}

	// Get page Title
	public String pagetitle() 
	{
		return driver.getTitle().trim();
	}

	// SelectByVisibleText
	public void selectvalue(By by, String fro) 
	{
		Select dropdown = new Select(driver.findElement(by));
		dropdown.selectByVisibleText(fro);

	}

	// selectByIndex
	public void selectbyindex(By by, int i) 
	{
		Select dropdown = new Select(driver.findElement(by));
		dropdown.selectByIndex(i);
	}

	// TakesScreenshot
	public void Screenshot(String name) throws IOException 
	{
		TakesScreenshot image = (TakesScreenshot) driver;
		File files = image.getScreenshotAs(OutputType.FILE);
		Files.copy(files, new File("..\\Telstra_coding_exercise_flipkart\\screenshots\\" + name + ".png"));
	}

	// ReadConfig File
	public String readconfig(String key) throws IOException 
	{

		FileInputStream file = new FileInputStream("..\\Telstra_coding_exercise_flipkart\\testdata\\Config.properties");
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		return value.trim();

	}

	// Quit Browser
	public void Quitbrowser() 
	{
		driver.quit();
	}
}
