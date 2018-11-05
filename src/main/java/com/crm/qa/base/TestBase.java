package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase { // This is the PARENT CLASS

	public static WebDriver driver; // global var(we can use anywhere in any class
	public static Properties prop; // global var (")
	
	

	public TestBase() { // here we are creating 'constructor' of 'TestBase' class.
		try {
			prop = new Properties(); // used to read the file from config properties.
			FileInputStream ip = new FileInputStream("/Users/pooja/eclipse-workspace/FreeCrmTest/src/main/java/com/crm/qa/config/"
							+ "config.properties");
			
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
			String browsername= prop.getProperty("browser");
			if(browsername.equals("chrome")) {
	         System.setProperty("webdriver.chrome.driver", "/Users/pooja/Downloads/chromedriver");
			driver=new ChromeDriver();
			}
			else if(browsername.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "/Users/pooja/Downloads/geckodriver");
				driver=new FirefoxDriver();
				
			}
			driver.manage().window().maximize(); // to maximize the window
			driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            
            driver.get(prop.getProperty("url"));
			
		
	}

}
