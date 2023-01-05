package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC06_ContactUsForm extends TestBase {
    @Test
    public void test01() throws InterruptedException {

//      Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//      Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.cssSelector("html"));
        if (homePage.isDisplayed()){
            System.out.println("Home page testing PASSED");
        }else System.out.println("Home page testing FAILED");

//      Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@class='fa fa-envelope']")).click();

//      Verify 'GET IN TOUCH' is visible
        WebElement getInTouch = driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        Assert.assertTrue(getInTouch.isDisplayed());

//      Enter name, email, subject and message
        driver.findElement(By.xpath("//*[@placeholder='Name']")).
                sendKeys("feyza", Keys.TAB,
                        "fyza@gmail.com", Keys.TAB,
                        "hello", Keys.TAB,
                        "OK");

//      Upload file
        WebElement uploadFile = driver.findElement(By.xpath("//*[@name='upload_file']"));
        uploadFile.sendKeys("/Users/feyzaunal/Downloads/logo.png");
        Thread.sleep(2000);

//      Click 'Submit' button
        driver.findElement(By.xpath("//*[@data-qa='submit-button']")).click();

//      Click OK button
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

//      Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement succesText = driver.findElement(By.xpath("//*[.='Success! Your details have been submitted successfully.']"));
        Assert.assertTrue(succesText.isDisplayed());

//       Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//*[@class='fa fa-angle-double-left']")).click();
        WebElement homePage2 = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage2.isDisplayed());

    }
}
