package onlineshop;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Case_Study.Case1.Drivers;
//import junit.framework.Assert;

public class Online_Shopping {
	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest logger;
  @Test(priority=1)
  public void Registration() throws InterruptedException {
	  logger = extent.createTest("Registration Test");
	  driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
	  driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("sange081011");
	  driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("priya");
	  driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("ramya1");
	  driver.findElement(By.xpath("//*[@id='password']")).sendKeys("saru");
	  driver.findElement(By.xpath("//*[@id='pass_confirmation']")).sendKeys("saru");
	  driver.findElement(By.xpath("//input[@value='Male']")).click();
	  driver.findElement(By.xpath("//*[@id='emailAddress']")).sendKeys("saru0501@gmail.com");
	  driver.findElement(By.xpath("//*[@id='mobileNumber']")).sendKeys("9514586352");
	  driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[9]/div/div/img")).click();
	  
	  WebElement mnth=driver.findElement(By.xpath("// select[@data-handler='selectMonth']"));
	  Select s=new Select(mnth);
	  s.selectByValue("4");
	  
	  WebElement year = driver.findElement(By.xpath("// select[@data-handler='selectYear']"));
	  Select a = new Select(year);
	  a.selectByValue("1998");
	  
	  WebElement date=driver.findElement(By.xpath("// table[@class='ui-datepicker-calendar']"));
	  date.findElement(By.linkText("5")).click();
	  
	  driver.findElement(By.xpath("//*[@id='address']")).sendKeys("anna nagar,chennai-28");
	  WebElement que=driver.findElement(By.xpath("//*[@id='securityQuestion']"));
	  Select f=new Select(que);
	  f.selectByVisibleText("What is your Nick Name?");
	  driver.findElement(By.xpath("//*[@id='answer']")).sendKeys("moni");
	  driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[13]/div/input[1]")).click();
	  Thread.sleep(3000);
	  Assert.assertEquals("shan",driver.getTitle());
	  logger.log(Status.INFO,MarkupHelper.createLabel("Wrong Page", ExtentColor.PINK));
  }
  @Test(priority=2)
  public void login() throws InterruptedException
  {
	  logger = extent.createTest("Login Test");
	  driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("sange081011");
	  driver.findElement(By.xpath("//*[@id='password']")).sendKeys("saru");
	  driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	  Thread.sleep(3000);
	  logger.log(Status.INFO,MarkupHelper.createLabel("Login Success!!!", ExtentColor.GREEN));
  }
  @Test(priority=3)
  public void add_to_cart() throws InterruptedException
  {
	  logger = extent.createTest("Add_To_Cart Test");
	  driver.findElement(By.xpath("//*[@id='myInput']")).sendKeys("Carpet");
	  driver.findElement(By.xpath("/html/body/div[1]/form/input")).click();
	  driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	  driver.findElement(By.xpath("//*[@id='header']/div[1]/div/div/div[2]/div/a[2]")).click();
	  Assert.assertEquals(driver.getTitle(), "View Cart");
	  driver.findElement(By.xpath("//*[@id='cart']/tfoot/tr[2]/td[5]/a")).click();
	  driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
	  Thread.sleep(3000);
	  logger.log(Status.INFO, MarkupHelper.createLabel("Product Added", ExtentColor.GREEN));
  }
  @Test(priority=4)
  public void payment() throws InterruptedException
  {
	  logger = extent.createTest("Payment Test");
	  driver.findElement(By.xpath("//*[@id='swit']/div[1]/div/label/i")).click();
	  driver.findElement(By.xpath("//*[@id='btn']")).click();
	  driver.findElement(By.xpath("//*[@id='horizontalTab']/div[2]/div/div/div/div/form/input[1]")).sendKeys("123456");
	  driver.findElement(By.xpath("//*[@id='horizontalTab']/div[2]/div/div/div/div/form/input[2]")).sendKeys("Pass@456");
	  driver.findElement(By.xpath("//*[@id='horizontalTab']/div[2]/div/div/div/div/form/div/div[3]/input")).click();
	  driver.findElement(By.xpath("//*[@id='horizontalTab']/div[2]/div/div/div/div/form/input")).sendKeys("Trans@456");
	  driver.findElement(By.xpath("//*[@id='horizontalTab']/div[2]/div/div/div/div/form/div/div[2]/input")).click();
	  Assert.assertEquals(driver.getTitle(), "Order Details");
	  driver.findElement(By.xpath("/html/body/header/div/div/ul/b/a[2]")).click();
	  Thread.sleep(3000);
	  logger.log(Status.INFO, MarkupHelper.createLabel("Amount Paid and Logged_Out", ExtentColor.GREEN));
	  
  }
  @BeforeTest
  public void beforeTest() {
	  
	  driver=Drivers.getDriver("chrome");
	  driver.manage().window().maximize();
	  driver.get("http://10.232.237.143:443/TestMeApp");
	  htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent.reports/gyh.html");
	  extent= new ExtentReports();
	  logger=extent.createTest("Start report");
	  extent.attachReporter(htmlreporter);
	  extent.setSystemInfo("Host Name", "GFT NexGen Testing Stream");
	  extent.setSystemInfo("Environment","Automation Testing - Selenium");
	  extent.setSystemInfo("User Name","Shanmugha");
	  htmlreporter.config().setDocumentTitle("Html reports for TestMeApp");
	  htmlreporter.config().setReportName("Reports appear here");
	  htmlreporter.config().setTheme(Theme.STANDARD);
  }
  @AfterMethod
  public void getResultAfterMethod(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE)
		{   logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName() + "Test case fail", ExtentColor.RED));
			TakesScreenshot snapshot=(TakesScreenshot)driver;
			File src=snapshot.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
			String path=System.getProperty("user.dir")+"extent.reports/snapshot" +result.getName()+ ".png";
			FileUtils.copyFile(src,new File(path));
			logger.addScreenCaptureFromPath(path,result.getName());
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"-Test Case Failed",ExtentColor.RED));
		}
		else if(result.getStatus()==ITestResult.SKIP){
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"-Test Case Skipped",  ExtentColor.ORANGE));
			
			
		}
	}

  @AfterTest
  public void afterTest() {
	  
	  logger = extent.createTest("End report");
	  extent.flush();
	  driver.close();
  }

}
