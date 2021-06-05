package com.reusables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reusables {

	public static RemoteWebDriver driver;
	
	private static JavascriptExecutor jse = null;
	
	protected String CompetitorScore=null;
	protected String googlesScore=null;
	protected String webpresencesScore=null;
	protected String websitesScore=null;
	protected String reputationsScore=null;
	protected String googleSummarytextScore=null;
	protected String webpresencesSummaryScore=null;
	protected String websiteSummaryScore=null;
	protected String reputationSummaryScore=null;


	

	public void EnterURL(String applicationUrl) {
		try {
			driver.get(applicationUrl);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());

		}
	}

	public void StartApplication(String browser) {
		try {

			if (browser.equalsIgnoreCase("chrome")) {

				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				options.addArguments("ignore-certificate-errors");
				options.setAcceptInsecureCerts(true);
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);

			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
				FirefoxOptions options = new FirefoxOptions();
				options.setLogLevel(FirefoxDriverLogLevel.ERROR);
				driver = new FirefoxDriver(options);
			} else {
				System.out.println("Unknown Browser");

			}
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			jse = (JavascriptExecutor) driver;

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void iType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
		} catch (WebDriverException e) {
			System.out.println(e.getStackTrace());
		}
	}

	public String igetTitle() {
		String bReturn = "";
		try {
			bReturn = driver.getTitle();
		} catch (WebDriverException e) {
			System.out.println(e.getStackTrace());
		}
		return bReturn;
	}

	public void SelectDropDownUsingText(WebElement ele, String value) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("enter blocl value" + value);
			System.out.println("ele value" + ele);

			new Select(ele).selectByVisibleText(value);
			System.out.println("selected value");

		} catch (WebDriverException e) {
			System.out.println(e.getStackTrace());

		}

	}

	public void Click(WebElement ele) {
		try {
			ele.click();
		} catch (WebDriverException e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void SelectDropDownUsingIndex(WebElement ele, int index) {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			new Select(ele).selectByIndex(index);
		} catch (WebDriverException e) {
			System.out.println(e.getStackTrace());

		}

	}

	public void ImplicitlyWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public void iExplicitWaitForElementToBeClicable(WebElement ele, long sec) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (WebDriverException e) {
			System.out.println(e.getStackTrace());
		}
	}

	public String GetCurrentURL() {
		String currentURL = "";
		try {
			currentURL = driver.getCurrentUrl();
		} catch (WebDriverException e) {
			System.out.println(e.getStackTrace());
		}
		return currentURL;
	}
	
	  public boolean VerifyCurrentURL(String expectedTitle) {
	        boolean bReturn = false;
	        try {
	            if (GetCurrentURL().contains(expectedTitle)) {
	                bReturn = true;
	            } else {
	                System.out.println("i failed to verify current url of the element: " + expectedTitle);
	            }
	        } catch (WebDriverException e) {
				System.out.println(e.getStackTrace());
	        }
	        return bReturn;
	    }

	  public String iGetAttribute(WebElement ele, String attribute) {
	        String bReturn = "";
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, 10);
	            wait.until(ExpectedConditions.visibilityOf(ele));
	            wait.until(ExpectedConditions.elementToBeClickable(ele));
	            bReturn = ele.getAttribute(attribute);
	        } catch (WebDriverException e) {
				System.out.println(e.getStackTrace());
	        }
	        return bReturn;
	    }
	  
	  public boolean iVerifyIsDisplayed(WebElement ele, String elementName) {
	        boolean bReturn = false;

	        try {
	            WebDriverWait wait = new WebDriverWait(driver, 10);
	            wait.until(ExpectedConditions.visibilityOf(ele));
	            if (ele.isDisplayed()) {
	                bReturn = true;
	                System.out.println("Element " + elementName + " displayed successfully");
	            }
	        } catch (WebDriverException e) {
	            bReturn = false;
				System.out.println(e.getStackTrace());
	        }
	        return bReturn;
	    }
	  
	    public void CompareExactText(String actualText, String expectedText) {
	        try {
	            if (actualText.equals(expectedText)) {
	                System.out.println("The expected text matches the actual text: " + expectedText);
	            } else {
	            	 System.out.println("The expected text does not match the actual text: " + expectedText);
	            }
	        } catch (WebDriverException e) {
				System.out.println(e.getStackTrace());
	        }
	    }	  
	  
}
