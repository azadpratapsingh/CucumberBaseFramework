package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
	public WebDriver driver;
	public WebDriver WebDriverManager() throws IOException {
		FileInputStream fis=new FileInputStream("C:\\UdemySeleniumCertificate\\CucmberFramework1\\src\\test\\resources\\global.properties");
		Properties props=new Properties();
		props.load(fis);
		String url=props.getProperty("QAUrl");
		if(driver==null) {
			if(props.getProperty("BROWSER").equalsIgnoreCase("edge")) {
		System.setProperty("webdriver.edge.driver","C:\\UdemySeleniumCertificate\\CucmberFramework1\\src\\test\\resources\\msedgedriver.exe");
		driver=new EdgeDriver();
			}
		driver.get(url);
		}
		return driver;
	}
}
