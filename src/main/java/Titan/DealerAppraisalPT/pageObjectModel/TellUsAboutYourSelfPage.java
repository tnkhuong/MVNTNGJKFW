package Titan.DealerAppraisalPT.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Titan.DealerAppraisalPT.Utilities.Utils;

public class TellUsAboutYourSelfPage {

	WebDriver driver;
	
	@FindBy(id="firstName")
    public WebElement txtFirstName;
	
	@FindBy(id="lastName")
    public WebElement txtLastName;
	
	@FindBy(id="email")
    public WebElement txtEmail;
	
	@FindBy(id="birthMonth")
    public WebElement drdBirthMonth;
	
	@FindBy(id="birthDay")
    public WebElement drdBirthDay;
	
	@FindBy(id="birthYear")
    public WebElement drdBirthYear;
	
	@FindBy(id="genderCode")
    public WebElement drdGender;
	
	@FindBy(xpath="//div[@id = 'languages']//input[@type='search']")
    public WebElement txtLanguages;
	
	@FindBy(xpath="//a[@aria-label = 'Next step - define your location']")
    public WebElement btnNextStep;
	
	public TellUsAboutYourSelfPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void setFirstName(String firstnamevalue)
	{
		System.out.println("Enter First Name:" + firstnamevalue);
		txtFirstName.sendKeys(firstnamevalue);
	}
	
	public void setLastName(String lastnamevalue)
	{
		System.out.println("Enter Last Name:" + lastnamevalue);
		txtLastName.sendKeys(lastnamevalue);
	}
	
	public void setEmail(String emalvalue)
	{			
		if (Utils.isValid(emalvalue))
		{		
			System.out.println("Enter Email:" + emalvalue);		
			txtEmail.sendKeys(emalvalue);
		}
		else
		{
			System.out.println("Email is invalid format.");	
		}
	}
	
	public void setMonth(String monthvalue) 
	{
		System.out.println("Enter birth Month:" + monthvalue);
		drdBirthMonth.click();
		String monthinput = "//div[@id = 'birthMonth']/descendant::input[@type='search']";
		WebElement txtbirthmonth = driver.findElement(By.xpath(monthinput));	
		
		txtbirthmonth.sendKeys(monthvalue + Keys.ENTER);
	}
	
	public void setDay(String dayvalue) 
	{
		System.out.println("Enter birth Day:" + dayvalue);
		drdBirthDay.click();
		String dayinput = "//div[@id = 'birthDay']/descendant::input[@type='search']";
		WebElement txtbirthday = driver.findElement(By.xpath(dayinput));	
		
		txtbirthday.sendKeys(dayvalue + Keys.ENTER);
	}
	
	public void setYear(String yearvalue) 
	{
		System.out.println("Enter birth Year:" + yearvalue);
		drdBirthYear.click();
		String yearinput = "//div[@id = 'birthYear']/descendant::input[@type='search']";
		WebElement txtbirthyear = driver.findElement(By.xpath(yearinput));	
		
		txtbirthyear.sendKeys(yearvalue + Keys.ENTER);
	}
	
	public void setGender(String gendervalue) 
	{
		System.out.println("Select Gender:" + gendervalue);
		drdGender.click();		
		
		String gender = "//div[text() = 'Female']";		
		if (gendervalue.toLowerCase().equals("male"))
		{
			gender = "//div[text() = 'Male']";
				
		}
		WebElement txtgender = driver.findElement(By.xpath(gender));	
		txtgender.click();
	}
	
	public void setLanguages(String languagesvalue) 
	{
		System.out.println("Enter Languages:" + languagesvalue);
		txtLanguages.sendKeys(languagesvalue + Keys.ENTER);
	}
	
	public void clickNextStep()
	{
		System.out.println("Click on Next Step button:");
		btnNextStep.click();
	}

	public void submitStep1Successfully(String firstname, String lastname, String email, 
										String month, String day, String year,
										String gender, String languages)
	{
		setFirstName(firstname);
		setLastName(lastname);
		setEmail(email);
		setMonth(month);
		setDay(day);
		setYear(year);
		setGender(gender);
		setLanguages(languages);
		clickNextStep();
	}
	
	
}
