package Base.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Page1 {
    public static void main(String [] args) throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "src/main/java/Drivers/chromedriver.exe");
/*
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.utep.edu");
        driver.quit();
*/
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WINDOWS);
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("start-maximized");
        options.merge(cap);
        String HubUrl = "http://192.168.56.1:4444/wd/hub";
        WebDriver driver = new RemoteWebDriver(new URL(HubUrl), options);
        driver.get("https://www.utep.edu/");
        System.out.println("Title is "+driver.getTitle());
        driver.close();
        driver.quit();
    }
}
