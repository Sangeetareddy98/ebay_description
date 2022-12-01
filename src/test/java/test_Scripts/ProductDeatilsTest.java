package test_Scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.ReadExcel;
import pom_scripts.Ebay;

public class ProductDeatilsTest extends Base_Test {

	@Test()
	public void validateProductDetails() {
		Ebay eb=new Ebay(driver);
		ReadExcel re=new ReadExcel();
		
		//search textfield
		eb.Click_searchTf();
        eb.enterValue(re.getData("Sheet1", 0, 0));
		eb.clickSearchButton();
		eb.clickonImage();
		eb.handleWindows();
		eb.clickonReadLink();
		eb.clickonSeeDetails();
		eb.clickonShipping();
		Assert.assertTrue(eb.ValidatePrice());
		eb.clickonFeedback();
		eb.clickonSa();
		eb.selectDropDown();
		eb.Quantity(re .getData("Sheet1", 0, 1));
		eb.buyIt();
		//eb.guest();
		eb.selectDropDown1();
		eb.AddToCart();
		
		
	
	
	
	}

	@DataProvider(name = "testdata")
	public Object[][] getTestData() throws IOException {
		Object[][] testdata = ReadExcel.getMultipleData("Sheet1");
		return testdata;

	}

}
