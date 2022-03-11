package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests extends  TestBase {
    @Test
    public void loginSuccess()
    {
      WebElement login = wd.findElement(By.cssSelector("[href='/login']"));
      login.click();
      WebElement email = wd.findElement(By.xpath("//input[1]"));
      email.click();
      email.clear();
      email.sendKeys("noa@gmail.com");
      WebElement pass = wd.findElement(By.xpath("//input[2]"));
      pass.click();
      pass.clear();
      pass.sendKeys("Nnoa12345$");
      wd.findElement(By.xpath("//*[text()=' Login']")).click();

        Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size()>0);


    }
    @Test
    public void loginSuccessNew()
    {
        click(By.cssSelector("[href='/login']"));
        type(By.xpath("//input[1]"),"noa@gmail.com");
        type(By.xpath("//input[2]"),"Nnoa12345$");
        click(By.xpath("//*[text()=' Login']"));
        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));
    }
}
