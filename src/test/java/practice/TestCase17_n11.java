package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase17_n11 extends TestBase {
    private String n11Url = "https://www.n11.com/";
    private String n11ValidEmail = "test.123.yap@gmail.com";
    private String n11ValidPassword = "Deneme123!";
    private String element1 ="div.inputField:nth-child(1) > div:nth-child(3) > div:nth-child(1)";
    private String element2 = "div.errorMessage:nth-child(4) > div:nth-child(1)";

    @Test
    public void test01() {
//      https://www.n11.com/ ' da
        driver.get("https://www.n11.com/");

//      Decision table testing yaparak tum olasiliklar icin login page'in bize verecegi responselari test edin.

//      n11ValidEmail=test.123.yap@gmail.com

//      n11ValidPassword=Deneme123!


    }
    public void Login_N11(String email, String password, String expectedResult) {
        driver.get(n11Url);
        driver.findElement(By.xpath("//a[@class='btnSignIn']")).click();

        //mail ve password gir
        WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys(password);

        // login butonuna tikla
        driver.findElement(By.xpath("//div[@id='loginButton']")).click();

        // beklenen sonuc
        String actualResult = driver.findElement(By.xpath("//a[@class='user']")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
