package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class TestCase11 extends TestBase {
    @Test
    public void test01() {
//      https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

//      Browseri tam sayfa yapin
        driver.manage().window().fullscreen();

//      Sayfayi "refresh" yapin
        driver.navigate().refresh();

//      Sayfa basliginin "Spend less" ifadesi icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Spend less"));

//      Gift Cards sekmesine basin
        driver.findElement(By.linkText("Gift Cards")).click();

//      Birthday butonuna basin
        driver.findElement(By.xpath("(//*[@alt='Birthday'])[2]")).click();

//      Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("//*[@alt='Amazon.com eGift Card']")).click();

//       Gift card details'den 25 $'i secin
        driver.findElement(By.xpath("//button[@value='25']")).click();

//      -Urun ucretinin 25$ oldugunu test edin
        String price = driver.findElement(By.xpath("//*[@class='a-color-price a-text-bold']")).getText();
        Assert.assertEquals("$25.00",price);


    }
}
