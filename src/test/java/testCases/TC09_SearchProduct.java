package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TC09_SearchProduct extends TestBase {
    @Test
    public void test01() {
//      Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//      Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());

//      Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        waitFor(2);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[text()=' Products']")).click(); //reklam yuzunden tekrar tikladim

//      Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());

//      Enter product name in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("winter top");
        driver.findElement(By.id("submit_search")).click();

//      Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue( driver.findElement(By.xpath("//h2[text()='Searched Products']")).isDisplayed());

//      Verify all the products related to search are visible
        List<WebElement> searchedProducts = driver.findElements(By.xpath("//*[@class='productinfo text-center']//p"));
        for (WebElement w : searchedProducts){
            Assert.assertTrue(w.isDisplayed());
        }
        waitFor(2);
    }
}
