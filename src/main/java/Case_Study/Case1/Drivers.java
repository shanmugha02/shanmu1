	package Case_Study.Case1;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;

	public class Drivers {
		
		public static WebDriver getDriver(String browser)
		{
			if(browser.equals("selenium2firefox"))
			{
				return new FirefoxDriver();
			}
			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\shan\\driver\\chromedriver.exe");
				return new ChromeDriver();
			}
			else if(browser.equals("ie"))
			{
				System.setProperty("webdriver.ie.driver","C:\\shan\\driver\\IEDriverServer.exe");
				return new InternetExplorerDriver();
			}
			else
			{
				return null;
			}
			
		}

	}
