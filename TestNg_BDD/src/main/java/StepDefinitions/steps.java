package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import cucumber.api.java.After;
import cucumber.api.java.Before;
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

public class steps extends BaseClass  {
	public static Logger logger;
	
	//@Parameters("browser")
	@Before
	public void setup() throws Exception {
		try {

			logger = Logger.getLogger("TestNG_BDD");
			//logger = Logger.getLogger(BaseClass.class);
			PropertyConfigurator.configure("C:\\Users\\Johny\\git\\TestNg_Cucumber\\TestNg_BDD\\Log4j.properties");

		/*	if (br.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
				driver = new ChromeDriver();

			}

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(BaseURL);
			driver.manage().window().maximize();*/

		} catch (Exception ex) {
			// log.info("Exception occured", ex);
			throw (ex);

		}

	}

	
@Given("^user Launch Chrome browser$")
public void user_Launch_Chrome_browser() {
  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
   driver = new ChromeDriver();
   driver.manage().window().maximize();
   
   mp = new MainPage(driver);
}

@When("^User opens URL$")

public void user_opens_URL() throws Exception {
try
{
	driver.get(BaseURL);
	logger.debug("URL Lauched");
}catch (Exception e)
{
	logger.info("Error message is :"+e);
}

}




@When("^user clicks SignIn link$")
public void user_clicks_SignIn_link() {
    mp.clkSignIn();
   logger.info("User clicked SignIn Link");
}


@Then ("^close browser$")
public void close_browser()
{
driver.quit();    
//logger.info("Browser Closed");
}

//@When("User enters Email as {string} and Password as {string}")

@When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
public void user_enters_Email_as_and_Password_as(String Email, String pwd) throws Throwable {
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 sp =new SingInPage(driver);
 sp.setEmail(Email);
 sp.setPassword(pwd);
logger.info("User entered Email and Password");
}



@When("^Click on Login$")
public void click_on_Login() throws Throwable {
  sp.clkLoginIn();
 logger.info("Login button clicked");
}



/****************************************************************************/

@Then("^Page Title should be \"([^\"]*)\"$")
public void page_Title_should_be(String PageTitle) throws Throwable {
	
	//if(driver.getPageSource().contains("Welcome to your account. Here you can manage all of your personal information and orders.") & driver.getTitle()==PageTitle)
/*	if(driver.getTitle().trim()==PageTitle.trim())
	{
		Assert.assertTrue(true);
		//logger.info("Expected message displayed");
	}
	else
	{
		Assert.assertTrue(false);
		//logger.info("Expected message not displayed");
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
 logger.info("User clicked Signout button");
}

@Then("^Error message should display \"([^\"]*)\"$")
public void error_message_should_display(String ErrMessage) throws Throwable {
	//if(sp.ErrMsg().getText().contains(Message))
	if(driver.getPageSource().contains(ErrMessage))
	{
		Assert.assertTrue(true);
		logger.info("Expected Error message displayed");
	}
	else
	{
		Assert.assertTrue(false);
		logger.info("Expected Error not message displayed");
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
logger.info("Product added to the cart");
}

@Then("^Click Proceed to Checkout button from Popup$")
public void click_Proceed_to_Checkout_button_from_Popup() throws Throwable {
	
 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 mp.clkProceedChkout();
logger.info("Proceed to checkout button is clicked");
}

@Then("^Message should display \"([^\"]*)\"$")
public void message_should_display(String Message) throws Throwable {
	if(driver.getPageSource().contains(Message))
	{
		Assert.assertTrue(true);
		logger.info("Expected Error message displayed");
	}
	else
	{
		Assert.assertTrue(false);
		logger.info("Expected Error not message displayed");
	}
}

@Then("^Click Proceed to Checkout button from Shopping Cart Summary page$")
public void click_Proceed_to_Checkout_button_from_Shopping_Cart_Summary_page() throws Throwable {
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 ShpSumP = new ShoppingCartSummary(driver);
	 ShpSumP.ClkPageProceedChkout();
	logger.info("Proceed to checkout button is clicked from Shopping cart summary page");
	 
}

@Then("^Click Proceed to Checkout button from Addresses page$")
public void click_Proceed_to_Checkout_button_from_Addresses_page() throws Throwable {
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	AddCnfPg= new AddressConfPage(driver);
	AddCnfPg.ClkConfProceedChkout();
	logger.info("Proceed to checkout button is clicked from Address page");
}

@Then("^Click Agree Terms and conditions checkbox$")
public void click_Agree_Terms_and_conditions_checkbox() throws Throwable {
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  ShpPg =new ShippingPage(driver);
  ShpPg.ChckTearmsCndn();
 logger.info("Agree Terms and conditions clicked");
  
}

@Then("^Click Proceed to Checkout button from Shipping page$")
public void click_Proceed_to_Checkout_button_from_Shipping_page() throws Throwable {
	 ShpPg.ClkShpProceedChkout();
	logger.info("Proceed to checkout button is clicked from Shipping page");
}

@Then("^Click Payby wire from Payment page$")
public void click_Payby_wire_from_Payment_page() throws Throwable {
  ChosPayPg = new ChoosePaymentPage(driver);
  ChosPayPg.ClkPayByWire();
 logger.info("Pay by wire is clicked from Payment page");
}

@Then("^Click confirm order button from Order Summary page$")
public void click_confirm_order_button_from_Order_Summary_page() throws Throwable {
	OrdSumPg = new OrderSummaryPage(driver);
	OrdSumPg.ClkConfirmOrder();
	logger.info("Confirm order button is clicked from the Summary page");	
}

@After
public void tearDown() {
	driver.quit();
}



}


	


