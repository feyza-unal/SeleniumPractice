package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HomeWork extends TestBase {
    @Test
    public void test01() {
//      -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

//       -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        WebElement mavi = driver.findElement(By.xpath("(//*[@class='ui-slider-range ui-corner-all ui-widget-header ui-slider-range-min'])[3]"));
        actions.clickAndHold(mavi).sendKeys("")
        .release().perform();
        //.moveByOffset(-255,0)
        waitFor(10);
    }
}
