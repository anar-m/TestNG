package tests.day15_testNGFrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C02_dependOnMethods {

    // üç tane test  methodu oluşturun
    // 1- amazontest : amazon anasayfaya gidip Url'in amazon içerdiğini test edin
    // 2- nutellatest : Nutella için arama yapıp arama sonuçlarının Nutella içerdiğini test edin
    // 3- ilkUrunTest: ilk ürünü click yapıp, ürün isminde Nutella içerdiğini test edin

    /*
           DependsOnMethods priority'den farklıdır.

           DependsOnMethods hangi method'un önce çalışacağına karar vermez
           Sadece yazıldığı test çalışmadan önce bağlandığı testin
           çalıştığından ve PASSED olduğundan emin olmak ister

           Bağlı olduğu test çalışmaz veya çalışır ama PASSED olmazsa
           DependsOnMethods'un yazıldığı test IGNORE olur.

           DependsOnMethods yazıldığı method tek başına çlıştırılmak istenirse
           önce bağlı olduğu testin çalıştığından ve Passed  olması gerektiğinden
           kendince önce bağlı olduğu test method'un çalışmasını sağlar

           Ama bu bağlantı birden fazla method'u çalıştırmaz.

           priority kullanılarak bir method'un önce çalışması istense de
           o method önceliği bağlı olduğu method'a devreder
           bağlı olduğu method da başka method'a bağlıysa önce onu çalıştırır.

     */

    @Test
    public void amazonTest(){
        Driver.getDriver().get("https://www.amazon.com");

        String expectedUrlIcerik = "amazon";
        String actualIcerik = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualIcerik.contains(expectedUrlIcerik));
    }

    @Test (dependsOnMethods = "amazonTest")
    public void nutellaTest(){

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucyazielementi = Driver.getDriver().findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedIcerik = "Nutella";
        String actualSonucYazisi = sonucyazielementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }

        @Test (dependsOnMethods = "nutellaTest")
        public void ilkUrunTesti(){
        Driver.getDriver().findElement(By.xpath("(//*[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        WebElement urunIsimElementi = Driver.getDriver().findElement(By.xpath("//span[@id='productTitle']"));

        String expectedIcerik = "Nutella";
        String actualurunIsmi = urunIsimElementi.getText();

        Assert.assertTrue(actualurunIsmi.contains(expectedIcerik));

        Driver.closeDriver();

    }
}
