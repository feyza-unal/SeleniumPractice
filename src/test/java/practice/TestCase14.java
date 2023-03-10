package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class TestCase14 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//      https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

//      Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropDown = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select selectDropDown = new Select(dropDown);
        selectDropDown.selectByIndex(1);
        Thread.sleep(2000);

//      Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        selectDropDown.selectByValue("2");
        Thread.sleep(2000);

//      Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        selectDropDown.selectByVisibleText("Option 1");
        Thread.sleep(2000);

//      Tüm dropdown değerleri(value) yazdırın
        List<WebElement> allValues = driver.findElements(By.xpath("//*[@id='dropdown']"));
        for (WebElement w : allValues){
            System.out.println(w.getText());
        }

//       Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True , degilse False yazdırın
        int boyut = allValues.size();
        if (boyut == 4) System.out.println("True");
        else System.out.println("False");

        Thread.sleep(2000);
    }
}
