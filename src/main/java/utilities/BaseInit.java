package utilities;

import com.test.pages.BasePage;
import com.test.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseInit {

    public WebDriver driver;
    public Page page;
    public String URL;
    public String browserName;

    public BaseInit() throws IOException {

        Properties prop=new Properties();
        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//config.properties");
        prop.load(file);
        URL=prop.getProperty("url");
        browserName=prop.getProperty("browserName");

    }

    public WebDriver invokeBrowserAndLaunchURL()
    {
        if(browserName.equals("chrome")) {
            driver= new ChromeDriver();
        }
        else if (browserName.equals("firefox")) {
            driver= new FirefoxDriver();
        }
        driver.get(URL);

        page = new BasePage(driver);
        return driver;
    }

}
