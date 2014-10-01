package uk.gov.justice.digital.courtfinder.factories;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import com.opera.core.systems.OperaDriver;

public class ConfigurationFactory {
	
	public final static String firefoxBrowser = "FIREFOX";
	public final static String chromeBrowser  = "CHROME";
	public final static String IEBrowser      = "INTERNETEXPLORER";
	public final static String safariBrowser  = "SAFARI";
	public final static String operaBrowser   = "OPERA";
	
	public final static String developmentEnvironment = "DEVELOPMENT";
	public final static String localEnvironment = "LOCAL";
	
	public static String getEnvironment(){
		if (!(System.getProperty("environment") == null) )
			   return System.getProperty("environment").toUpperCase();
		//return default if no system property set		
		return ConfigurationFactory.localEnvironment;
	}
	
	public static String getWebDriverName(){
		if (!(System.getProperty("Browser") == null) )
		   return System.getProperty("Browser").toUpperCase();
		return ConfigurationFactory.firefoxBrowser;
	}
	
	
	public static WebDriver getFireFoxWebDriver(){
		FirefoxProfile profile = new ProfilesIni().getProfile("default");
		WebDriver driver = new FirefoxDriver(profile);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	public static WebDriver getChromeWebDriver(){
	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("test-type");
	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);	
		WebDriver driver = new ChromeDriver(capabilities);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();		
		return driver;
	}
	
	public static WebDriver getOperaWebDriver(){
		WebDriver driver = new OperaDriver();	
		return driver;
	}
	
	public static WebDriver getSafariWebDriver(){
		WebDriver driver = new SafariDriver();
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	
	
	public static WebDriver getInternetExplorerWebDriver(){
		return new InternetExplorerDriver();
	}
	
	public static WebDriver getWebDriver(){
		if (ConfigurationFactory.firefoxBrowser.equalsIgnoreCase(ConfigurationFactory.getWebDriverName()))
		   return ConfigurationFactory.getFireFoxWebDriver();
		else if (ConfigurationFactory.chromeBrowser.equalsIgnoreCase(ConfigurationFactory.getWebDriverName()))
			   return ConfigurationFactory.getChromeWebDriver();
		else if (ConfigurationFactory.safariBrowser.equalsIgnoreCase(ConfigurationFactory.getWebDriverName()))
			   return ConfigurationFactory.getSafariWebDriver();
		else if (ConfigurationFactory.operaBrowser.equalsIgnoreCase(ConfigurationFactory.getWebDriverName()))
			   return ConfigurationFactory.getOperaWebDriver();
		else if (ConfigurationFactory.IEBrowser.equalsIgnoreCase(ConfigurationFactory.getWebDriverName()))
			   return ConfigurationFactory.getInternetExplorerWebDriver();	
		//return default if browser not recognised
		return ConfigurationFactory.getFireFoxWebDriver();
	}

}
