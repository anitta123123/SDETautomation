import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample {
	
	public static  WebDriver driver;
	public static FileInputStream ip;
	public static Properties prop;
	
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver//chromedriver.exe");
		driver= new ChromeDriver();
		
		
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+"//Configuration//config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop= new Properties();
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		System.out.println(prop.getProperty("url"));
	}
	
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}


	public Sample(WebDriver driver){
		PageFactory.initElements(driver, this);
		System.out.println("constructorcompleted ");
	}
	
	@FindBy(xpath="//li[@class='dropdown']//a[contains(text(),'Selenium') and @class='dropdown-toggle' ]")
	WebElement Seleniumlink;
		
	@FindBy(xpath="//a[text()='Login']")
	WebElement login;
	
	
	@FindBy(xpath="//a[text()='Bank Project']")
	WebElement bankDemoLink;
	
	String seleniumName="//li[@class='dropdown']//a[contains(text(),'Selenium') and @class='dropdown-toggle' ]";
	
	@FindBy(id="email")
	WebElement userText;
	
	@FindBy(id="passwd")
	WebElement userPaswrd;
	
	@FindBy(id="SubmitLogin")
	WebElement loginButton;
	
	@FindBy(xpath="//h3[text()='Successfully Logged in...']")
	WebElement homeText;
	
	public void loginAction(String name, String pswrd) throws InterruptedException  {
		System.out.println("inside loginpage "+driver);
		//Utilities.ElementIsAvailable(driver,seleniumName);
		Thread.sleep(3000);
		System.out.println("anitta");			
		//Utilities.loginFromSeleniumAction(driver, Seleniumlink, login);
		
		
		Actions action= new Actions(driver);
		System.out.println("acitons"+driver);
		Thread.sleep(3000);
		action.moveToElement(Seleniumlink).click().build().perform();
		
		System.out.println("acitons123"+Seleniumlink);
		//ElementIsAvailable(driver, loginElement);
		Thread.sleep(3000);
		login.click();
		System.out.println("evelyn");	
		userText.sendKeys(name);
		userPaswrd.sendKeys(pswrd);
		loginButton.click();
		
		Assert.assertEquals(homeText.getText(), "Successfully Logged in...", "the login failed");	
		
		
		
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		System.out.println(prop.getProperty("password"));
		
				
		loginAction(prop.getProperty("username"), prop.getProperty("password"));
	}

}
