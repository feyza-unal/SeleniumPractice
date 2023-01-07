package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import org.openqa.selenium.interactions.Actions;

public class WindowHandle_DragDrop extends TestBase {
    @Test
    public void test01() {

//      go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

//      Fill in capitals by country
        Actions actions = new Actions(driver);

//-------------------------------- kisa cozum --------------------------------
        for (int i = 1; i < 8; i++) {
            actions.dragAndDrop(driver.findElement(By.id("box" + i)),driver.findElement(By.id( "box" + (100+i) ))).
                    release().
                    perform();

            waitFor(1);
        }

//--------------------------------uzun cozum--------------------------------

//        WebElement oslo = driver.findElement(By.id("box1"));
//        WebElement norway = driver.findElement(By.id("box101"));
//        actions.
//                dragAndDrop(oslo,norway).
//                release().
//                perform();
//
//        waitFor(1);
//
//        WebElement stockholm = driver.findElement(By.id("box2"));
//        WebElement sweden = driver.findElement(By.id("box102"));
//        actions.
//                dragAndDrop(stockholm,sweden).
//                release().
//                perform();
//
//        waitFor(1);
//
//        WebElement washington = driver.findElement(By.id("box3"));
//        WebElement unitedStates = driver.findElement(By.id("box103"));
//        actions.
//                dragAndDrop(washington,unitedStates).
//                release().
//                perform();
//
//        waitFor(1);
//
//        WebElement copenhagen = driver.findElement(By.id("box4"));
//        WebElement denmark = driver.findElement(By.id("box104"));
//        actions.
//                dragAndDrop(copenhagen,denmark).
//                release().
//                perform();
//
//        waitFor(1);
//
//        WebElement seoul = driver.findElement(By.id("box5"));
//        WebElement southKorea = driver.findElement(By.id("box105"));
//        actions.
//                dragAndDrop(seoul,southKorea).
//                release().
//                perform();
//
//        waitFor(1);
//
//        WebElement rome = driver.findElement(By.id("box6"));
//        WebElement italy = driver.findElement(By.id("box106"));
//        actions.
//                dragAndDrop(rome,italy).
//                release().
//                perform();
//
//        waitFor(1);
//
//        WebElement madrid = driver.findElement(By.id("box7"));
//        WebElement spain = driver.findElement(By.id("box107"));
//        actions.
//                dragAndDrop(madrid,spain).
//                release().
//                perform();
//
//        waitFor(1);


    }
}
