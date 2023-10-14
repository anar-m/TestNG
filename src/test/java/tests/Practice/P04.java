package tests.Practice;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class P04 {
    //1- https://www.qualitydemy.com/ anasayfasina gidin
    //2- login linkine basin
    // 3- Kullanici email'i olarak valid email girin
    // 4- Kullanici sifresi olarak valid sifre girin
    // 5- Login butonuna basarak login olu
    // 6- Basarili olarak giris yapilabildigini test edin

    @Test
    public void QualityDemy(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage=new QualitydemyPage();

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliEmail"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qualitydemyPage.loginButonu.click();

        Assert.assertFalse(qualitydemyPage.basariliGirisElementi.isDisplayed(),"Başarılı olarak giriş yapılmıştır.");

    }
}
