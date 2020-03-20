package Titan.DealerAppraisalPT.TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import Titan.DealerAppraisalPT.config.Init;
import Titan.DealerAppraisalPT.pageObjectModel.TellUsAboutYourSelfPage;

public class TellUsAboutYourSelf extends Init{
  @Test
  public void f() throws Exception {
	  
	  WebDriver driver = Init.setup("firefox");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	  
	  driver.get("https://www.utest.com/signup/personal");
	  driver.manage().window().maximize();
	  
	  TellUsAboutYourSelfPage tellusaboutyourself = new TellUsAboutYourSelfPage(driver); 	  
	  tellusaboutyourself.submitStep1Successfully("Khuong", "Truong", "truongnguyen.khuong@gmail.com", "July", 
      	  										"27", "1981", "Male", "Vietnamese");
	  
	  Assert.assertEquals(driver.getCurrentUrl(), "https://www.utest.com/signup/address");	  
	  }
  
  @BeforeTest
  public void beforeTest() {	  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
}
