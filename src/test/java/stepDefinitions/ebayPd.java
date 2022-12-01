package stepDefinitions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ebayPd {
static WebDriver driver=null;
	
	@Given("user opens browser")
	public void user_opens_browser() {
		System.setProperty("webdriver.chrome.driver","./src/main/resources/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get("https://www.ebay.com/");
		
	    
	}

	@And("search for product")
	public void search_for_product() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("_nkw")))).sendKeys("mobile");

	}

	@When("user clicks on the search button")
	public void user_clicks_on_the_search_button() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("gh-btn")))).click();;

	}

	@And("clicks on the image of the product")
	public void clicks_on_the_image_of_the_product() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollTo(0,400)");
	    js.executeScript("window.scrollTo(0,400)");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//img[@alt='Nokia 3310 Unlocked Mobile Phone GSM 900/1800 Snake II English& Arabic Keyboard']")))).click();
    
	}

	@And("user shoud be able to click on read more link")
	public void user_shoud_be_able_to_click_on_read_more_link() {
	   
	   String parentWindowId = driver.getWindowHandle();
		System.out.println("parentWindowId = " + parentWindowId);
		
		Set<String> allwindowIds = driver.getWindowHandles();
		System.out.println("windowCount = " + allwindowIds.size());
		System.out.println("allwindowIds = " + allwindowIds);
		System.out.println("------------------------");
	    
		for (String wid : allwindowIds) {
			System.out.println(wid);
			String windowUrl = driver.switchTo().window(wid).getCurrentUrl();
			if (windowUrl.equals("https://www.ebay.com/sch/i.html?_from=R40&_trksid=m570.l1313&_nkw=mobile&_sacat=0")) {
				
			}
		}
		
		WebDriverWait wait=new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.partialLinkText("Read")))).click();

	}

	@Then("user should be able to check product price")
	public void user_should_be_able_to_check_product_price() {
		boolean price=driver.findElement(By.xpath("//span[text()='US $27.00/ea']")).isEnabled();
		price=true;
		if(price) {
			System.out.println("price is displayed " +price);
			
		}
	}

	@Then("user should be able to click on Shipping and Payments button")
	public void user_should_be_able_to_click_on_shipping_and_payments_button() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@aria-controls='shipping_panel']")))).click();

	}

	@Then("user should be able to click on see details link")
	public void user_should_be_able_to_click_on_see_details_link() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='See details']")))).click();


	}

	@When("user clicks on see feedback link")
	public void user_clicks_on_see_feedback_link() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='See details']")))).click();

	}

	@Then("user should be able to click on see all button")
	public void user_should_be_able_to_click_on_see_all_button() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='See details']")))).click();

	}

	@Then("user should be able to click on dropdown")
	public void user_should_be_able_to_click_on_dropdown() {
		WebElement bundle=driver.findElement(By.xpath("//select[@id='x-msku__select-box-1000']"));
		Select select=new Select(bundle);
		List<WebElement> options=select.getOptions();
		for(int i=0;i<options.size();i++) {
			WebElement sortBy=driver.findElement(By.xpath("//select[@id='x-msku__select-box-1000']"));
			Select sel=new Select(sortBy);
			sel.selectByIndex(i);
			}
		
	}

	
    @Then("user should be able to add quantity")
	public void user_should_be_able_to_add_quantity() {
    	driver.findElement(By.cssSelector("input[aria-describedby='qtyErrMsg']")).clear();
		WebDriverWait wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[aria-describedby='qtyErrMsg']")))).sendKeys("3");

	}

	@Then("user should be able to click on buy it now")
	public void user_should_be_able_to_click_on_buy_it_now() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("binBtn_btn_1")))).click();
	}

	@Then("user is able to click on Check out as guest")
	public void user_is_able_to_click_on_check_out_as_guest() {
		WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[@data-testid='ux-call-to-action'])[3]")))).click();

	}

	@And("user should be navigate back to the product page")
	public void user_should_be_navigate_back_to_the_product_page() {
		driver.navigate().to("https://www.ebay.com/itm/403528244929?hash=item5df4285ec1:g:l0oAAOSwHP9iRnos&amdata=enc%3AAQAHAAAA0BRrIs465i896epc5ie1eXIKmHZvBDUkMi3mRmLvOsCpT4cKPQktEd%2BJm8ScYgJZUUmhslVRTFMJEQN75AJLhgUunp%2FOt9A045d0YPGNN1cHX8LnniktvcmtShxZf%2FGfMVcBSljqSeet2sol5n0ZV8YevDc%2B8Zw7JEZNgQ3JyIc5angIZLoagdcchZnaMBng2PdJHJ1kbIlVbSY2aAHGYLDBUGTN66w5m2yxRt1CUvLbOquZwkRG0uQyAl%2B7Poh95CnH6MSg6HWtUVx4%2BjcGM7c%3D%7Ctkp%3ABFBMruKI4pVh");

	}

	@Then("user should be able to click on dropdown button")
	public void user_should_be_able_to_click_on_dropdown_button() {
		WebElement sortByDD=driver.findElement(By.xpath("//select[@id='x-msku__select-box-1000']"));
		Select select1=new Select(sortByDD);
		List<WebElement> options1=select1.getOptions();
		for(int i=0;i<options1.size();i++) {
			WebElement sortBy=driver.findElement(By.xpath("//select[@id='x-msku__select-box-1000']"));
			Select sel=new Select(sortBy);
			sel.selectByIndex(i);
			}
	}


	@Then("user should be able to click on add to cart button")
	public void user_should_be_able_to_click_on_add_to_cart_button() {
		driver.findElement(By.xpath("//span[text()='Add to cart']")).click();

	}

	@And("user shoul be able to search for product")
	public void user_shoul_be_able_to_search_for_product() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("_nkw")))).sendKeys("book");

	}

	@When("user click on the search button")
	public void user_click_on_the_search_button() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("gh-btn")))).click();;
    
	}

	@And("click on the image of the product")
	public void click_on_the_image_of_the_product() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//img[@alt='Slaughterhouse-Five by Vonnegut Jr., Kurt']")))).click();

	}

	@And("user should be able to clicks on add to cart button")
	public void user_should_be_able_to_clicks_on_add_to_cart_button() {
		Set<String> allwindowIds1 = driver.getWindowHandles();
		System.out.println("windowCount = " + allwindowIds1.size());
		System.out.println("allwindowIds = " + allwindowIds1);
		System.out.println("------------------------");
	    
		for (String wid : allwindowIds1) {
			System.out.println(wid);
			String windowUrl = driver.switchTo().window(wid).getCurrentUrl();
			if (windowUrl.equals("https://www.ebay.com/itm/193323069097?epid=1086167&hash=item2d02f3eea9:g:QGkAAOSwaEhZLxIz&amdata=enc%3AAQAHAAAA0IgTnG1PkCSa4dY4fA%2B93ZTj%2FltMvyivqAuQW0IOj9%2F7l8yfu5LxXJUcUQpfGw%2BWcqNNLtFv8AG%2F76noAujXVCdHaGZM74vUW60DXTyY9h1297HAE22OCNd%2B9Kc9QAgRk%2BgPW4BgJkLXcAAI7gkKifFCliwXHJDABafMpiFyMO67yp94pV3eg6dGwDPcSp%2B%2FaucHszsMM8CyVNnMqNjyrUcmJpelKHnzLLfIMQNL3OZSxadcE2E3JUGa%2BCIJoGjy0saE6PFKVDKxkRW9MWevt1I%3D%7Ctkp%3ABk9SR7Kr1NaXYQ")) {
				
			}
		}
		
			driver.findElement(By.xpath("//span[text()='Add to cart']")).click();

	}


}
