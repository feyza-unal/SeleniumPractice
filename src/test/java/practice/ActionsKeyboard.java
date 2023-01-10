package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsKeyboard extends TestBase {
    @Test
    public void keyboardActionsTest() {
//      https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

//      video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();


//      videoyu izlemek icin Play tusuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@id='movie_player']")).click();

        waitFor(3);

//      videoyu calistirdiginizi test edin
        WebElement controlButtons = driver.findElement(By.xpath("//*[@class='ytp-left-controls']"));
        Assert.assertTrue(controlButtons.isDisplayed());

    }
}
