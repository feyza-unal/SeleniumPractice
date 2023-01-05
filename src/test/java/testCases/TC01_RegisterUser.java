package testCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TC01_RegisterUser extends TestBase {
    @Test
    public void test01() throws InterruptedException {
//      Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//      Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.cssSelector("html"));
        if (homePage.isDisplayed()){
            System.out.println("Home page testing PASSED");
        }else System.out.println("Home page testing FAILED");

        Thread.sleep(2000);

//      Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

//      Verify 'New User Signup!' is visible
        WebElement signUpText = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(signUpText.isDisplayed());

//      Enter name and email address
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).
                sendKeys("feyza", Keys.TAB,"fyz@gmail.com");

//      Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

//      Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b")).isDisplayed());

//       Fill details: Title, Name, Email, Password, Date of birth
//       Select checkbox 'Sign up for our newsletter!'
//       Select checkbox 'Receive special offers from our partners!'
//       Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        driver.findElement(By.xpath("//*[@id='id_gender2']")).click();
        driver.findElement(By.xpath("//*[@id='password']")).
                sendKeys("123456", Keys.TAB,
                        "5",Keys.TAB,
                        "June",Keys.TAB,
                        "1995",Keys.TAB,
                        Keys.SPACE,Keys.TAB,Keys.SPACE,Keys.TAB,
                        "feyza",Keys.TAB,
                        "unal",Keys.TAB,Keys.TAB,
                        "aladah mah",Keys.TAB,Keys.TAB,
                        "united",Keys.TAB,
                        "california",Keys.TAB,
                        "LA",Keys.TAB,
                        "12",Keys.TAB,
                        "555555");
//       Click 'Create Account button'
         driver.findElement(By.xpath("//*[@type='submit']")).click();
         Thread.sleep(2000);

//       Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b")).isDisplayed());

//       Click 'Continue' button
         driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        Thread.sleep(2000);

//       Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b")).isDisplayed());

//       Click 'Delete Account' button
//        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
//
////      Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
//        Assert.assertTrue(driver.findElement(By.xpath("//b")).isDisplayed());
//        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();



    }
}
