package pom_scripts;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import generic.Base_Test;

public class Ebay extends BasePage{
	public Ebay(WebDriver driver) {
		super(driver);
	}
	//For searching Textfield
	@FindBy(name="_nkw")
	WebElement Searchtf;
	public void Click_searchTf() 
	{
		clickAction(Searchtf);
	}
	
	//passing values
	@FindBy(name="_nkw")
	WebElement searchValue;
	public void enterValue(String value)
	{
		enter_value(searchValue,value);
	}
	
	
	
	//clicking on search button
	@FindBy(id="gh-btn")
	WebElement search;
	public void clickSearchButton() {
		clickAction(search);
	}
	
	//clicking on product
	@FindBy(xpath="//img[@alt='Nokia 3310 Unlocked Mobile Phone GSM 900/1800 Snake II English& Arabic Keyboard']")
	WebElement image;
	public void clickonImage()
	{
		clickAction(image);
		
	}
	
	//window handling
	public void handleWindows()  {
		String parentWindowId = Base_Test.getDriver().getWindowHandle();
		System.out.println("parentWindowId = " + parentWindowId);
		
		Set<String> allwindowIds = Base_Test.getDriver().getWindowHandles();
		System.out.println("windowCount = " + allwindowIds.size());
		System.out.println("allwindowIds = " + allwindowIds);
		System.out.println("------------------------");
	    
		for (String wid : allwindowIds) {
			System.out.println(wid);
			String windowUrl = Base_Test.getDriver().switchTo().window(wid).getCurrentUrl();
			if (windowUrl.equals("https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=mobile&_sacat=0")) {
				
			}
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//clicking on read link
	@FindBy(partialLinkText="Read")
	WebElement read;
	public void clickonReadLink()
	{
		clickAction(read);
	}
	
	//clicking on see details
	@FindBy(xpath="//span[text()='See details']")
	WebElement seeDetails;
	public void clickonSeeDetails()
	{	
		clickAction(seeDetails);
	}
	
	
	
	//clicking on shipping and payment details
	@FindBy(xpath="//a[@aria-controls='shipping_panel']")
	WebElement shippingDetails;
	public void clickonShipping()
	{
		clickAction(shippingDetails);
	}
	
	//checking price
	@FindBy(xpath="//span[text()='US $27.00/ea']")
	WebElement price;
	public boolean ValidatePrice()
	{
		return isEnabled(price);
	}
	
	//clicking on seefeedback
	@FindBy(id="byrfdbk_atf_lnk_sm")
	WebElement seeFeedback;
	public void clickonFeedback()
	{
		clickAction(seeFeedback);
	}
	
	//clicking on see all feedback
	@FindBy(linkText="See all")
	WebElement seeAll;
	public void clickonSa()
	{
		clickAction(seeAll);
		Base_Test.getDriver().navigate().to("https://www.ebay.com/itm/403528244929?hash=item5df4285ec1:g:l0oAAOSwHP9iRnos&amdata=enc%3AAQAHAAAA0BRrIs465i896epc5ie1eXIKmHZvBDUkMi3mRmLvOsCpT4cKPQktEd%2BJm8ScYgJZUUmhslVRTFMJEQN75AJLhgUunp%2FOt9A045d0YPGNN1cHX8LnniktvcmtShxZf%2FGfMVcBSljqSeet2sol5n0ZV8YevDc%2B8Zw7JEZNgQ3JyIc5angIZLoagdcchZnaMBng2PdJHJ1kbIlVbSY2aAHGYLDBUGTN66w5m2yxRt1CUvLbOquZwkRG0uQyAl%2B7Poh95CnH6MSg6HWtUVx4%2BjcGM7c%3D%7Ctkp%3ABFBMruKI4pVh");

	}
	
	//navigate
	
	//dropdown  
	
	@FindBy(xpath="//select[@id='x-msku__select-box-1000']")
	WebElement bundle;
	public void selectDropDown() {
		Select select=new Select(bundle);
		List<WebElement> options=select.getOptions();
		for(int i=0;i<options.size();i++) {
			WebElement sortBy=Base_Test.getDriver().findElement(By.xpath("//select[@id='x-msku__select-box-1000']"));
			Select sel=new Select(sortBy);
			sel.selectByIndex(i);
			}
	}
	
	
	//clicking on quantity and sending value 
	@FindBy(xpath="//input[@aria-describedby='qtyErrMsg']")
	WebElement quantity;
	public void Quantity(String value)
	{
		clickAction(quantity);
		quantity.clear();
		enter_value(quantity,value);
		
	}
	
		
	//clcicking on buy it now
	@FindBy(id="binBtn_btn_1")
	WebElement buyIt;
	public void buyIt() 
	{
		clickAction(buyIt);
		Base_Test.getDriver().navigate().to("https://www.ebay.com/itm/403528244929?hash=item5df4285ec1:g:l0oAAOSwHP9iRnos&amdata=enc%3AAQAHAAAA0BRrIs465i896epc5ie1eXIKmHZvBDUkMi3mRmLvOsCpT4cKPQktEd%2BJm8ScYgJZUUmhslVRTFMJEQN75AJLhgUunp%2FOt9A045d0YPGNN1cHX8LnniktvcmtShxZf%2FGfMVcBSljqSeet2sol5n0ZV8YevDc%2B8Zw7JEZNgQ3JyIc5angIZLoagdcchZnaMBng2PdJHJ1kbIlVbSY2aAHGYLDBUGTN66w5m2yxRt1CUvLbOquZwkRG0uQyAl%2B7Poh95CnH6MSg6HWtUVx4%2BjcGM7c%3D%7Ctkp%3ABFBMruKI4pVh");

	}
	
	//clicking on as guest
	/*@FindBy(xpath="//a[@data-testid='ux-call-to-action'])[3]")
	WebElement guest;
	public void guest() 
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickAction(guest);
		
	}*/
	
	//clicking on  dropdown
	@FindBy(xpath="//select[@id='x-msku__select-box-1000']")
	WebElement bundle1;
	public void selectDropDown1()
	{
		clickAction(bundle1);
	}
	
	//clicking on add to cart
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement cart;
	public void AddToCart()
	{
		clickAction(cart);
	}
	
	
	
	
	
	

}
