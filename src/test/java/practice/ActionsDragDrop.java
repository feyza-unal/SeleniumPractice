package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsDragDrop extends TestBase {
    @Test
    public void iframeTest() {
//      "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

//      "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverOverFirst = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        actions.
                moveToElement(hoverOverFirst).
                perform();

        waitFor(2);

//      "Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();
        waitFor(2);

//      Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

//      Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

//      "Click and hold" kutusuna basili tutun
        WebElement clickHoldButton = driver.findElement(By.id("click-box"));
        actions.
                clickAndHold(clickHoldButton). //basili tut
                release(). //birak
                perform();

        waitFor(2);

//      "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickHoldButton.getText());

//      "Double click me" butonunu cift tiklayin
        WebElement doubleClickButton = driver.findElement(By.id("double-click"));
        String colorBeforeClick = doubleClickButton.getCssValue("background-color");//rgba(254, 196, 45, 1)

        actions.
                doubleClick(doubleClickButton).
                perform();

        waitFor(2);

//      "Double click me" butonunun renk değiştridiğini doğrulayın
        String colorAfterClick = doubleClickButton.getCssValue("background-color");//rgba(147, 203, 90, 1)
        Assert.assertNotEquals(colorBeforeClick, colorAfterClick);

    }
}
