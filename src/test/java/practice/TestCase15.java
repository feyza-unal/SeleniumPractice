package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class TestCase15 extends TestBase {

    @Test
    public void test01() {
//      amazon gidin
        driver.get("https://www.amazon.com");

//      Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select dDmenu = new Select(dropdown);
        List<WebElement> menuList = dDmenu.getOptions();
        menuList.stream().forEach(t-> System.out.println(t.getText()));

//      dropdown menude 40 eleman olduğunu doğrulayın
        int menuSize = menuList.size();
        System.out.println(menuSize);
        Assert.assertNotEquals(40,menuSize);
    }

    @Test
    public void test02() {
        driver.get("https://www.amazon.com");
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select dDmenu = new Select(dropdown);

//      dropdown menuden elektronik bölümü seçin
        dDmenu.selectByVisibleText("Electronics");

//      arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

//      sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String actualResult = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(actualResult.contains("iphone"));

//      ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("//*[@data-image-index='2']")).click();
        waitFor(3);

    }

    @Test
    public void test03() {
//      yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.com");
        
//      dropdown’dan bebek bölümüne secin
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select slctDropDown = new Select(dropdown);
        slctDropDown.selectByVisibleText("Baby");

//      bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puseti"+Keys.ENTER);

//      sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']")).
                getText().
                contains("bebek puseti"));

//      üçüncü ürüne relative locater kullanarak tıklayin
        List<WebElement> sonuclar = driver.findElements(By.xpath("//*[@class='s-image']"));
        sonuclar.get(2).click();

//      title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        Assert.assertTrue(driver.findElement(By.id("productTitle")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='delightPricingBadge_feature_div']")).isDisplayed());
        waitFor(3);
    }

}
