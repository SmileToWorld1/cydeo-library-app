package com.cydeo.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make a static because we will use it in a static method.
     */
   // private static WebDriver driver;  // value is null by default

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Creating a private constructor, so we are closing access to the
    object of this class from outside the class
     */

    private Driver(){

    }

    /*
    Create a re-usable utility method which will return same driver instance when
    we call it.
     */
    public static WebDriver getDriver(){
        if (driverPool.get() == null){     //if (driver==null){
            /*
            We read our browserType from configuration.properties.
            Ths way, we can control which browser is opened from outside our code,
            from configuration.properties.
             */
            String browserType = ConfigurationReader.getProperty("browser");
            /*
                Depending on the browserType that will be return from configuration.properties file
                switch statement will determine the case, and open the matching browser
             */
            switch (browserType){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver()); // driver = new ChromeDriver();
                    driverPool.get().manage().window().maximize();      // driver.manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driverPool.get();    // return driver;
    }

    /*
    This method will make sure our driver value is always null after using quit() method
     */
    public static void closeDriver(){
        if (driverPool.get() != null){    // if (driver != null){
             driverPool.get().quit();  // driver.close(); // This line will terminate the existing session. Value will not even be null
             driverPool.remove();  // driver = null;
        }
    }

}