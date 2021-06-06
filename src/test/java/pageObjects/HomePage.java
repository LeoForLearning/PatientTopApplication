
package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.reusables.Reusables;

public class HomePage extends Reusables {

	@FindBy(css = "#practicename")
	private WebElement practiceNameTextBox;

	@FindBy(xpath = "//span[@class='pac-item-query']")
	private WebElement practiceNameDropDown;

	@FindBy(css = "#practicename")
	private WebElement address;
	
	@FindBy(css = "#specialty")
	private WebElement speciality;
	
	@FindBy(css = ".v-list-item__title")
	private WebElement specialityDropDown;
	
	@FindBy(css = "#diagnose-submit")
	private WebElement compareButton;
	
	
	
	
	public String env = System.getProperty("ENV");


	public HomePage() {
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
	}

	public void startApplication(String browser) {

		StartApplication(browser);
	}

	public void enterUrl() throws InterruptedException {
 
		EnterURL(env);
		WaitForPageLoad(driver)
	}

	public void enterPractiseName(String name) throws InterruptedException {

		iType(practiceNameTextBox, name);
		Thread.sleep(500);
		Click(practiceNameDropDown);
	}
	
	public void selectPractiseName(String name) throws InterruptedException {

		Click(practiceNameDropDown);
	}
	
	public void validateAddressField() {
		iGetAttribute(address, "");
	}
	
	public void enterSpecialityDropdown(String data) throws InterruptedException {
		ImplicitlyWait(10);	
		iType(speciality, data);
		Thread.sleep(500);
		Click(specialityDropDown);
		
	}
	
	public void clickButton() throws InterruptedException {
		Click(compareButton);
		
	}
}
