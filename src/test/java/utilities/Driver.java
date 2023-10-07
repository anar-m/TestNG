package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    /* JUnit'de WebDriver objesi TestBase'den geliyordu.

    TestNG extends ile bağlanma zorunluluğunu ortadan kaldırmak
    be testi yazanlara daha fazla kontrol imkanı vermek için
    TestBase yerine driver class'ında satitic 2 method ile
    driver oluşturma ve kapatma işlemlerini tercih etmiştir.
     */
    static WebDriver driver;
    public static WebDriver getDriver(){

        WebDriverManager.chromedriver().setup();

        if (driver == null){
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }
    public static void closeDriver(){
        if (driver != null){
            driver.close();
            driver=null;
        }
    }
}
