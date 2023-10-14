package tests.Practice;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class P03 {
    // Amazon da iPhone 15 PRO icin arama yapin
    // Arama kutusunun locator'ina ihtiyacimiz var
    // locator'larimiz artik pages class'larinda
    // Locator'lar static olmadigi icin obje olusturarak kullanabiliriz


    @Test
    public void amazonArama(){

        // arama yapmak için amazon sitesine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // arama Kutusuna aranacak mmetni girip arama yapalım
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime3")+ Keys.ENTER);
        String actualYazi = amazonPage.sonucYaziElementi.getText();
        String expectedYazi = ConfigReader.getProperty("amazonAranacakKelime3");

        Assert.assertTrue(actualYazi.contains(expectedYazi));

       // PENCEREYİ KAPATALIM
        Driver.closeDriver();
    }
}
