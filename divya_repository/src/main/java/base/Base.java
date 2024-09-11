package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import resources.staticResource.Global_Static;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public void loadPropertiesFile() throws IOException {
        FileInputStream f = new FileInputStream("src/main/java/config/config.properties");
         Global_Static.prop = new Properties();
        Global_Static.prop.load(f);
    }

    public void selectBrowser(String browser) {
        if (browser.equals("Chrome") || browser.equals("chrome"))
            Global_Static.driver= new ChromeDriver();
        if (browser.equals("Firefox") || browser.equals("firefox"))
            Global_Static.driver = new FirefoxDriver();
        if (browser.equals("Edge") || browser.equals("edge"))
            Global_Static.driver = new EdgeDriver();
    }

    public void launchBrowser() throws IOException {
        loadPropertiesFile();
        selectBrowser(Global_Static.prop.getProperty("browser"));
        Global_Static.driver.manage().window().maximize();
        Global_Static. driver.get(Global_Static.prop.getProperty("Applicationurl"));

    }
}