package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Interview01 extends TestBase {
    @Test
    public void test01() {
//      Go to "https://www.amazon.com.tr"
        driver.get("https://www.amazon.com.tr");
        waitFor(2);
        driver.findElement(By.id("sp-cc-accept")).click(); //cookies

//      Search iPhone13 512
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13 512"+ Keys.ENTER);
        //waitFor(2);

//      Check that the results are listed
        String actualText = driver.findElement(By.xpath("//*[@class='a-size-medium']")).getText();
        Assert.assertTrue(actualText.contains("gösteriliyor"));

//      Click iPhone13 at the top of the list
        List<WebElement> resultList = driver.findElements(By.xpath("//*[@class='s-image']"));
        resultList.get(0).click();

//      Log the following values for each size (.Size information .Price .Color .Stock status)

        List<WebElement> sizeList = driver.findElements(By.xpath("//*[@class='a-text-left a-size-base']"));

            for (int i=0; i<sizeList.size(); i++){
                sizeList.get(i).click();
                String size = driver.findElement(By.xpath("(//*[@class='selection'])[1]")).getText();
                String color = driver.findElement(By.xpath("(//*[@class='selection'])[2]")).getText();
                String title = driver.findElement(By.xpath("//*[@class='a-size-large product-title-word-break']")).getText();
                String price = driver.findElement(By.xpath("(//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay'])[1]")).getText();
                String stockStatus = driver.findElement(By.xpath("//*[@class='a-size-medium a-color-success']")).getText();
                waitFor(2);
                System.out.println("\n"+title+
                            "\nSize : "+size+
                            "\nColor : "+color+
                            "\nPrice : "+price+
                            "\nStock Status : "+stockStatus);

            }

    }
}

// String color = driver.findElement(By.xpath("//*[@id='inline-twister-expanded-dimension-text-color_name']")).getText();

//        String size512 = driver.findElement(By.xpath("//*[@id='size_name_2-announce']")).getText();
//        String size256 = driver.findElement(By.xpath("//*[@id='size_name_1']")).getText();
//        String size128 = driver.findElement(By.xpath("//*[@id='size_name_0-announce']")).getText();

//        System.out.println("\n\n"+title+"\nSize : "+size512+"\nColor : "+color+"\nPrice : "+price+"\nStock Status : "+stockStatus);
//        driver.findElement(By.xpath("//*[@id='size_name_1']")).click();
//        System.out.println("\n\n"+title+"\nSize : "+size256+"\nColor : "+color+"\nPrice : "+price+"\nStock Status : "+stockStatus);
//        driver.findElement(By.xpath("//*[@id='size_name_0']")).click();
//        System.out.println("\n\n"+title+"\nSize : "+size128+"\nColor : "+color+"\nPrice : "+price+"\nStock Status : "+stockStatus);


//        String title = driver.findElement(By.id("productTitle")).getText();
//        String price = driver.findElement(By.xpath("(//*[@class='a-offscreen'])[1]")).getText();
//        String stockStatus = driver.findElement(By.xpath("//*[@class='a-size-medium a-color-success']")).getText();