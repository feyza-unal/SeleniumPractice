package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class TestCase13 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//      https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

//      Sayfa basliginin "Google" ifadesi icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Google"));

//      Arama cubuguna "Nutella" yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

//      Bulunan sonuc sayisini yazdirin
        String text = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        String result = text.split(" ")[1].replaceAll("\\D","");
        System.out.println(result);

//      sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        Integer resultInt = Integer.valueOf(result);
        int onMilyon = 10000000;
        Assert.assertTrue(resultInt > onMilyon);

        Thread.sleep(2000);
    }
}
