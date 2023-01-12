package testCases;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TC11_CartPage extends TestBase {
    @Test
    public void test01() {
//      Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//      Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//body")).isDisplayed());

//      Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

//      Scroll down to footer
        Actions actions = new Actions(driver);
        WebElement footerElement = driver.findElement(By.xpath("//footer"));
        actions.scrollToElement(footerElement).perform();
        waitFor(2);

//      Verify text 'SUBSCRIPTION'
        Assert.assertTrue(driver.findElement(By.xpath("//footer//h2")).isDisplayed());

//      Enter email address in input and click arrow button
        Faker faker = new Faker();
        driver.findElement(By.id("susbscribe_email")).sendKeys(faker.internet().emailAddress());
        waitFor(2);
        driver.findElement(By.id("subscribe")).click();

//      Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='alert-success alert']")).isDisplayed());
        waitFor(2);
    }
}
