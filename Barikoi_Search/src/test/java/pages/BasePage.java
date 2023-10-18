package pages;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Allure;
import utilities.DriverSetup;

public class BasePage extends DriverSetup{

	public WebElement getElement(By locator) {
		return getDriver().findElement(locator);
	}
	
	public void clickOnElement(By locator) {
		getElement(locator).click();
	}
	
	public void inputText(By locator, String text) {
		getElement(locator).sendKeys(text);
	}
	
	public String getElementText(By locator) {
		return getElement(locator).getText();
	}

	
	
	
}
