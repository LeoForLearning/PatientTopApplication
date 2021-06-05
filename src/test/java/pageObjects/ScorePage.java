package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.reusables.Reusables;

public class ScorePage extends Reusables {

	@FindBy(xpath = "//div[@class='panel-right reverse']/h2")
	private WebElement competitorsText;

	@FindBy(xpath = "(//*[local-name()='svg' and @score_color='green']/*[@class='score-value'])[1]")
	private WebElement competitorsScore;
	
	@FindBy(css = "[alt='Google ranking']")
	private WebElement GoogleLink;	
	
	@FindBy(xpath = "(//h2[contains(text(),'Google rank')])[1]")
	private WebElement googleText;

	@FindBy(xpath = "(//*[local-name()='svg' and @class='circular-chart purple mini']/*[@class='score-value'])[1]")
	private WebElement googleScore;

	@FindBy(xpath = "(//span[@class='btn btn-nav btn-nav-next'])[1]")
	private WebElement buttonNext;

	@FindBy(xpath = "(//h2[contains(text(),'Web presence')])[1]")
	private WebElement webPresencText;

	@FindBy(xpath = "(//li[@class='row your-practice']//div[3]//*[local-name()='svg' and @class='circular-chart green mini']/*[@class='score-value'])[2]")
	private WebElement webPresenceScore;

	@FindBy(xpath = "(//h2[contains(text(),'Website')])[1]")
	private WebElement websiteText;

	@FindBy(xpath = "(//li[@class='row your-practice']//div[3]//*[local-name()='svg' and @class='circular-chart green mini']/*[@class='score-value'])[2]")
	private WebElement websiteScore;

	@FindBy(xpath = "(//h2[contains(text(),'Reputation')])[1]")
	private WebElement ReputationText;

	@FindBy(xpath = "(//li[@class='row your-practice']//div[3]//*[local-name()='svg' and @class='circular-chart green mini']/*[@class='score-value'])[1]")
	private WebElement ReputationScore;
	

	public ScorePage() {

		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
	}

	public void validateScore() throws Exception {

		// Competitors Text
		iVerifyIsDisplayed(competitorsText, "Competitors");
		CompetitorScore= competitorsScore.getText();
		
		Thread.sleep(500);
		Click(GoogleLink);
		
		// Google Text
		iVerifyIsDisplayed(googleText, "Google Rank");
		googlesScore= googleScore.getText();
		
		Thread.sleep(500);
		Click(buttonNext);
		
		// web Presence Text
		iVerifyIsDisplayed(webPresencText, "Web Presence");
		webpresencesScore= webPresenceScore.getText();
		
		Thread.sleep(500);
		Click(buttonNext);
		
		// web site Text
		iVerifyIsDisplayed(websiteText, "Website");
		websitesScore= websiteScore.getText();
		
		Thread.sleep(500);
		Click(buttonNext);
		
		// Reputation Text
		iVerifyIsDisplayed(ReputationText, "Reputation");
		reputationsScore= ReputationScore.getText();
	
		Thread.sleep(500);
		Click(buttonNext);
		
	}

	

	

}