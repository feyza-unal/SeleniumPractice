package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TC08_VerifyAllProducts extends TestBase {
    @Test
    public void test01() {
//      Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

//      Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());

//      Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        System.out.println(driver.getCurrentUrl());

//      Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProducts.isDisplayed());

//      The products list is visible
        WebElement productList = driver.findElement(By.xpath("//*[@class='features_items']"));
        Assert.assertTrue(productList.isDisplayed());

//      Click on 'View Product' of first product
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("(//i[@class='fa fa-plus-square'])[1]"))).perform();

        driver.navigate().refresh();
        driver.findElement(By.xpath("(//div[@class='choose']//li//a)[1]")).click();

//      User is landed to product detail page
        WebElement productDetPage = driver.findElement(By.xpath("//*[@class='product-information']"));
        Assert.assertTrue(productDetPage.isDisplayed());

//      Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement productName = driver.findElement(By.xpath("//*[.='Blue Top']"));
        Assert.assertTrue(productName.isDisplayed());

        WebElement productCategory = driver.findElement(By.xpath("//*[.='Category: Women > Tops']"));
        Assert.assertTrue(productCategory.isDisplayed());

        WebElement productPrice = driver.findElement(By.xpath("//*[.='Rs. 500']"));
        Assert.assertTrue(productPrice.isDisplayed());

        WebElement productAvailability = driver.findElement(By.xpath("//*[.='Availability:']"));
        Assert.assertTrue(productAvailability.isDisplayed());

        WebElement productCondition = driver.findElement(By.xpath("//*[.='Condition:']"));
        Assert.assertTrue(productCondition.isDisplayed());

        WebElement productBrand = driver.findElement(By.xpath("//*[.='Brand:']"));
        Assert.assertTrue(productBrand.isDisplayed());


    }
}
