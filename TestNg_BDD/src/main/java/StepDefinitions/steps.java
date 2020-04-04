package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import io.cucumber.java.en.When;
import pageObjects.AddressConfPage;
import pageObjects.ChoosePaymentPage;
import pageObjects.MainPage;
import pageObjects.OrderSummaryPage;
import pageObjects.ShippingPage;
import pageObjects.ShoppingCartSummary;
import pageObjects.SingInPage;
import TestCase.BaseClass;

/*public class steps {

	WebDriver driver;
	 
	
	@Given("^login to URL$")
	public void login_to_URL() throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://automationpractice.com/");
	}
	
	@Then("^close browser$")
	public void close_browser() throws Throwable 
	{
		driver.quit();
	}

}*/

public class steps extends BaseClass {

	
	
@Given("^user Launch Chrome browser$")
public void user_Launch_Chrome_browser() {
	
   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
   driver = new ChromeDriver();
   driver.manage().window().maximize();
   
   mp = new MainPage(driver);
}

@When("^User opens URL$")
public void user_opens_URL() {
	driver.get(BaseURL);
  
}

@When("^user clicks SignIn link$")
public void user_clicks_SignIn_link() {
    mp.clkSignIn();
}


@Then ("^close browser$")
public void close_browser()
{
driver.quit();    
}

//@When("User enters Email as {string} and Password as {string}")

@When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
public void user_enters_Email_as_and_Password_as(String Email, String pwd) throws Throwable {
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 sp =new SingInPage(driver);
 sp.setEmail(Email);
 sp.setPassword(pwd);
}



@When("^Click on Login$")
public void click_on_Login() throws Throwable {
  sp.clkLoginIn();
}



/****************************************************************************/

@Then("^Page Title should be \"([^\"]*)\"$")
public void page_Title_should_be(String PageTitle) throws Throwable {
	
	//if(driver.getPageSource().contains("Welcome to your account. Here you can manage all of your personal information and orders.") & driver.getTitle()==PageTitle)
/*	if(driver.getTitle().trim()==PageTitle.trim())
	{
		Assert.assertTrue(true);
		logger.info("Expected message displayed");
	}
	else
	{
		Assert.assertTrue(false);
		logger.info("Expected message not displayed");
	}*/
 Assert.assertEquals(driver.getTitle(), PageTitle);

}

@Then("^Success message should display \"([^\"]*)\"$")
public void success_message_should_display(String SucsMsg) throws Throwable {
	
	String pageSource = driver.getPageSource();
	Assert.assertTrue(driver.getPageSource().contains(SucsMsg));

}

@When("^User click on Sign out link$")
public void user_click_on_Sign_out_link() throws Throwable {
  sp.clkSignOut();
}

@Then("^Error message should display \"([^\"]*)\"$")
public void error_message_should_display(String ErrMessage) throws Throwable {
	//if(sp.ErrMsg().getText().contains(Message))
	if(driver.getPageSource().contains(ErrMessage))
	{
		Assert.assertTrue(true);
		//logger.info("Expected Error message displayed");
	}
	else
	{
		Assert.assertTrue(false);
		//logger.info("Expected Error not message displayed");
	}
}


@Then("^User click on Home button$")
public void user_click_on_Home_button() throws Throwable {
  sp.clkHome();
}

@Then("^Add a product to the cart$")
public void add_a_product_to_the_cart() throws Throwable {
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//WebDriverWait wait=new WebDriverWait(driver, 20);
//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='homefeatured']/li[2]/div/div[2]/div[2]/a[1]/span")));  
mp.clkAddTshirt1();
}

@Then("^Click Proceed to Checkout button from Popup$")
public void click_Proceed_to_Checkout_button_from_Popup() throws Throwable {
	
 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 mp.clkProceedChkout();
}

@Then("^Message should display \"([^\"]*)\"$")
public void message_should_display(String Message) throws Throwable {
	if(driver.getPageSource().contains(Message))
	{
		Assert.assertTrue(true);
		//logger.info("Expected Error message displayed");
	}
	else
	{
		Assert.assertTrue(false);
		//logger.info("Expected Error not message displayed");
	}
}

@Then("^Click Proceed to Checkout button from Shopping Cart Summary page$")
public void click_Proceed_to_Checkout_button_from_Shopping_Cart_Summary_page() throws Throwable {
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 ShpSumP = new ShoppingCartSummary(driver);
	 ShpSumP.ClkPageProceedChkout();
	 
}

@Then("^Click Proceed to Checkout button from Addresses page$")
public void click_Proceed_to_Checkout_button_from_Addresses_page() throws Throwable {
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	AddCnfPg= new AddressConfPage(driver);
	AddCnfPg.ClkConfProceedChkout();
}

@Then("^Click Agree Terms and conditions checkbox$")
public void click_Agree_Terms_and_conditions_checkbox() throws Throwable {
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  ShpPg =new ShippingPage(driver);
  ShpPg.ChckTearmsCndn();
 
  
}

@Then("^Click Proceed to Checkout button from Shipping page$")
public void click_Proceed_to_Checkout_button_from_Shipping_page() throws Throwable {
	 ShpPg.ClkShpProceedChkout();
}

@Then("^Click Payby wire from Payment page$")
public void click_Payby_wire_from_Payment_page() throws Throwable {
  ChosPayPg = new ChoosePaymentPage(driver);
  ChosPayPg.ClkPayByWire();
}

@Then("^Click confirm order button from Order Summary page$")
public void click_confirm_order_button_from_Order_Summary_page() throws Throwable {
	OrdSumPg = new OrderSummaryPage(driver);
	OrdSumPg.ClkConfirmOrder();
	
}



	
}

