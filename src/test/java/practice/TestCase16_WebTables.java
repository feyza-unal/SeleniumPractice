package practice;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TestCase16_WebTables extends TestBase {
    @Test
    public void test01() {

//      https://www.way2automation.com/angularjs-protractor/webtables/
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
//      tüm E-mail leri yazdırın
        List<WebElement> tumMailler = driver.findElements(By.xpath("//table//tbody//td[7]"));
        tumMailler.stream().forEach(t->System.out.println(t.getText()));

//      Tüm E-maillerin "@" işareti içerdiğini doğrulayin
        tumMailler.stream().forEach(t->Assert.assertTrue(t.getText().contains("@")));

    }
}
