package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    /*
        TestNG'de Page Class'ları
        sürekli kullandığımız bir sayfa/webSitesi'ndeki
        locate'leri ve
        ilgili sayfada kullanılacak login gibi basit method'ları içerir

        TestNG PageClass'larındaki locate'lere erişim için
        Test Class'larında page Class'ından obje oluşturulmasını benimsemiştir.
     */

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYaziElementi;

    @FindBy(xpath = "(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")
    public WebElement ilkUrunElementi;

    @FindBy(xpath = "//span[@class='a-size-large product-title-word-break']")
    public WebElement ilkUrunIsimElementi;


}
