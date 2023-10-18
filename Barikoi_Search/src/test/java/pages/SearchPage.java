package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{
	
	
	//Locators//
	public String url= "https://barikoi.com/search";
	public String title= "Barikoi | Full-Stack Location Platform";
	public By searchBox= By.xpath("//input[contains(@placeholder,'Search Location.')]");
	public By searchBTN= By.xpath("//button[contains(@class,'search-icon btn')]");
	public By hideBTN= By.xpath("//*[local-name()='svg' and @data-icon='angle-left']/*[local-name()='path']");
	public By unhideBTN= By.xpath("//*[local-name()='svg' and @data-icon='angle-right']/*[local-name()='path']");
	public By barikoiText= By.xpath("//span[contains(text(),'koi')]");
	
	
	//Methods//
	
	public void SearchPlaces() {
		inputText(searchBox, "Barikoi");
		clickOnElement(searchBTN);
	}
	
	public void HideSearchSection() {
		clickOnElement(hideBTN);
	}
	
	public void UnhideSearchSection() {
		clickOnElement(unhideBTN);
	}
}
