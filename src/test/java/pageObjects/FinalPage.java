package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.reusables.Reusables;

public class FinalPage extends Reusables {
	@FindBy(xpath = "(//div[@class='score-item summary-google_rank']/div/*[local-name()='svg' and @class='circular-chart purple medium']/*[@class='score-value'])[1]")
	private WebElement googleSection;

	@FindBy(xpath = "(//div[@class='score-item summary-website_presence']/div/*[local-name()='svg' and @class='circular-chart green medium']/*[@class='score-value'])[1]")
	private WebElement webPresence;
	
	@FindBy(css = "(//div[@class='score-item summary-website']/div/*[local-name()='svg' and @class='circular-chart green medium']/*[@class='score-value'])[1]")
	private WebElement webSite;	
	
	@FindBy(xpath = "(//div[@class='score-item summary-reputation']/div/*[local-name()='svg' and @class='circular-chart green medium']/*[@class='score-value'])[1]")
	private WebElement Reputation;

	

	public FinalPage() {

		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
	}

	public void compareScore() throws Exception {
		
		// Google Summary score
		googleSummarytextScore= googleSection.getText();

		// web Presence summary score
		webpresencesSummaryScore= webPresence.getText();
	
		// web site summary score

		websiteSummaryScore= webSite.getText();
		
		// Reputation summary score
		reputationSummaryScore= Reputation.getText();
		
		//validating Score
		CompareExactText(googlesScore, googleSummarytextScore);
		CompareExactText(webpresencesScore, webpresencesSummaryScore);
		CompareExactText(websitesScore, websiteSummaryScore);
		CompareExactText(reputationsScore, reputationSummaryScore);
		
		
		driver.close();

	}

}
