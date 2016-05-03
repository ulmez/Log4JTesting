import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimvroomTest {
	static WebDriver driver = new FirefoxDriver();
	
	@FindBy(id = "answer1")
	WebElement answer1Element;
	
	@FindBy(id = "answer4")
	WebElement answer4Element;
	
	@FindBy(id = "answer6")
	WebElement answer6Element;
	
	@FindBy(id = "answer8")
	WebElement answer8Element;
	
	@FindBy(id = "answer10")
	WebElement answer10Element;
	
	@FindBy(id = "answer11")
	WebElement answer11Element;
	
	@FindBy(id = "answer13")
	WebElement answer13Element;
	
	@FindBy(id = "answer14")
	WebElement answer14Element;
	
	@FindBy(id = "name")
	WebElement textNameElement;
	
	@FindBy(id = "occupation")
	WebElement optionOccupationElement;
	
	@FindBy(xpath = "//*[@class='bluebox']")
	List<WebElement> blueBoxElements;
	
	@FindBy(xpath = "//*[@onclick='link_clicked();return false']")
	WebElement clickMeLinkElement;
	
	@FindBy(id = "redbox")
	WebElement redBoxElement;
	
	@FindBy(xpath = "//*[@value='wrotebook']")
	WebElement radioButtonYesWroteBookElement;
	
	@FindBy(id = "greenbox")
	WebElement greenBoxElement;
	
	@FindBy(id = "orangebox")
	WebElement orangeBoxElement;
	
	@FindBy(id = "ishere")
	WebElement isHereElement;
	
	@FindBy(id = "purplebox")
	WebElement purpleBoxElement;
	
	@FindBy(xpath = "//*[@onclick='show_new_link_after_wait();return false;']")
	WebElement buttonClickThenWaitElement;
	
	@FindBy(xpath = "//*[@onclick='click_after_wait();return false;']")
	WebElement buttonClickAfterWaitElement;
	
	@FindBy(id = "submitbutton")
	WebElement buttonSubmit;
	
	@BeforeClass
	public static void getBeforeClass() {
		driver.get("http://timvroom.com/selenium/playground/");
	}
	
	@Before
	public void getBefore() {
		PageFactory.initElements(driver, this);
	}
	
	// Test 1
	@Test
	public void pageTitleTest() {
		answer1Element.sendKeys(driver.getTitle());
	}
	
	// Test 2
	@Test
	public void insertToNameTextFieldTest() {
		textNameElement.sendKeys("Kilgore Trout");
	}
	
	// Test 3
	@Test
	public void selectOccupationTest() {
		Select ooe = new Select(optionOccupationElement);
		ooe.selectByValue("scifiauthor");
	}
	
	// Test 4
	@Test
	public void getNumberOfBlueBoxesTest() {
		//System.out.println(Integer.toString(blueBoxElements.size()));
		answer4Element.sendKeys(Integer.toString(blueBoxElements.size()));
	}
	
	// Test 5
	@Test
	public void clickMeLinkTest() {
		//System.out.println(clickMeLinkElement);
		clickMeLinkElement.click();
	}
	
	// Test 6
	@Test
	public void findRedBoxClassTest() {
		//System.out.println(redBoxElement);
		//System.out.println(redBoxElement.getAttribute("class"));
		answer6Element.sendKeys(redBoxElement.getAttribute("class"));
	}
	
	// Test 7
	@Test
	public void runJavascriptRanThisJsFunctionTest() {
		JavascriptExecutor js = null;
		if(driver instanceof JavascriptExecutor) {
			js = (JavascriptExecutor) driver;
		}
		
		js.executeScript("return ran_this_js_function();");
	}
	
	// Test 8
	@Test
	public void getJavascriptGotReturnFromJsFunctionTest() {
		JavascriptExecutor js = null;
		if(driver instanceof JavascriptExecutor) {
			js = (JavascriptExecutor) driver;
		}
		
		//System.out.println(js.executeScript("return got_return_from_js_function();"));
		answer8Element.sendKeys(js.executeScript("return got_return_from_js_function();").toString());
	}
	
	// Test 9
	@Test
	public void clickYesWroteBookRadioButtonTest() {
		//System.out.println(radioButtonYesWroteBookElement);
		radioButtonYesWroteBookElement.click();
	}
	
	// Test 10
	@Test
	public void getTextFromRedBoxTest() {
		//System.out.println(redBoxElement.getText());
		answer10Element.sendKeys(redBoxElement.getText());
	}
	
	// Test 11
	@Test
	public void getIfRedOrOrangeAreOnTopTest() {
		//System.out.println(greenBoxElement.getLocation().y);
		//System.out.println(orangeBoxElement.getLocation().y);
		int greenY = greenBoxElement.getLocation().y;
		int orangeY = orangeBoxElement.getLocation().y;
		
		if(greenY < orangeY) {
			//answer11Element.sendKeys(greenBoxElement.getText());
			answer11Element.sendKeys("green");
		} else {
			//answer11Element.sendKeys(orangeBoxElement.getText());
			answer11Element.sendKeys("orange");
		}
	}
	
	// Test 12
	@Test
	public void setBrowserWidthAndHeightTest() {
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().setSize(new Dimension(850,650));
	}
	
	// Test 13
	@Test
	public void getIsHereTest() {
		try {
			isHereElement.getLocation();
			//System.out.println(isHereElement.getLocation());
			//System.out.println("Yes");
			answer13Element.sendKeys("yes");
		} catch (NotFoundException nfe) {
			//System.out.println("No");
			answer13Element.sendKeys("no");
		}
	}
	
	// Test 14
	@Test
	public void getIsPurpleBoxVisibleTest() {
		//System.out.println(purpleBoxElement.isDisplayed());
		if(purpleBoxElement.isDisplayed()) {
			answer14Element.sendKeys("yes");
		} else {
			answer14Element.sendKeys("no");
		}
	}
	
	// Test 15
	@Test
	public void clickThenWaitLinkTest() {
		buttonClickThenWaitElement.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@onclick='click_after_wait();return false;']")));
		wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		
		buttonClickAfterWaitElement.click();
		
		Alert alertWindow = driver.switchTo().alert();
		alertWindow.accept();
		
		buttonSubmit.click();
	}
}
