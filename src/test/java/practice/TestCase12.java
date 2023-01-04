package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TestCase12 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//      https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

//      arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

//      "Samsung headphones" ile arama yapalim
        searchBox.sendKeys("headphones", Keys.ENTER);

//      Bulunan sonuc sayisini yazdiralim
        String text = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String result = text.split(" ")[3];
        System.out.println(result);


//      Ilk urunu tiklayalim
        driver.findElement(By.xpath("//*[@class='s-image']")).click();
        Thread.sleep(2000);

//      Sayfadaki tum basliklari yazdiralim
        List<WebElement> titles =  driver.findElements(By.xpath("//h1"));
        for (WebElement w : titles) {
            System.out.println(w.getText());
        }
    }
}
