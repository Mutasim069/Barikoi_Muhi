package test_case;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.BasePage;
import pages.SearchPage;
import utilities.DriverSetup;

public class SearchTest extends DriverSetup{
	
	SearchPage sc= new SearchPage();
	SoftAssert softAssert= new SoftAssert();
	
	@Test(priority = 0, description = "title check")
	public void TitleTest() {
		getDriver().get(sc.url);
		softAssert.assertEquals(sc.title, getDriver().getTitle());
	}
	
	@Test(priority = 1, description = "hide search location section")
	public void HidesearchLocation() {
		getDriver().get(sc.url);
		sc.HideSearchSection();
		softAssert.assertNotEquals("koi", sc.barikoiText);
	}
	
	@Test(priority = 2, description = "unhide search location section")
	public void UnhideSearchLocation() {
		getDriver().get(sc.url);
		sc.HideSearchSection();
		sc.UnhideSearchSection();
		softAssert.assertEquals("koi", sc.barikoiText);
	}
}
