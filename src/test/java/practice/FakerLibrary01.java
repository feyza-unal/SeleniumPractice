package practice;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class FakerLibrary01 extends TestBase {
    @Test
    public void fakerTest() {

//      "https://facebook.com"  Adresine gidin
//      “create new account”  butonuna basin
//      “firstName” giris kutusuna bir isim yazin
//      “surname” giris kutusuna bir soyisim yazin
//      “email” giris kutusuna bir email yazin
//      "email" tekrar girin
//      Bir sifre girin

        driver.get("https://facebook.com");
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();

        driver.findElement(By.name("firstname")).
                sendKeys(faker.name().firstName(), Keys.TAB,
                        faker.name().lastName(),Keys.TAB,
                        email);
        driver.findElement(By.name("reg_email_confirmation__")).
                sendKeys(email,Keys.TAB,
                        faker.internet().password(8,10));

//      Tarih icin gun secin, ay secin, yil secin
        int year = faker.number().numberBetween(1905,2023);
        String strYear = String.valueOf(year); //select obj ile kullanmak icin string'e cevirmem gerekti

        Select slctD = new Select(driver.findElement(By.name("birthday_day")));
        Select slctM = new Select(driver.findElement(By.name("birthday_month")));
        Select slctY = new Select(driver.findElement(By.name("birthday_year")));
        slctD.selectByIndex(faker.number().numberBetween(1,31));
        slctM.selectByIndex(faker.number().numberBetween(1,12));
        slctY.selectByVisibleText(strYear);

//      Cinsiyeti secin
//      Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement woman = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        WebElement man = driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        WebElement other = driver.findElement(By.xpath("(//*[@type='radio'])[3]"));
        woman.click();
        waitFor(3);

        Assert.assertTrue(woman.isSelected());
        Assert.assertFalse(man.isSelected());
        Assert.assertFalse(other.isSelected());

//      Sayfayi kapatin
        driver.close();



    }
}
