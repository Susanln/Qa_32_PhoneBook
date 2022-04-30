package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ContactHelper extends HelperBase{
    WebDriverWait wait= new WebDriverWait(wd,10);

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openAddForm() {
        click(By.xpath("//a[@href='/add']"));
        logger.info("Add contacts form opened");
    }

    public void fillAddContactForm(Contact contact) {
        type(By.xpath("//*[@placeholder='Name']"),contact.getName());
        type(By.xpath("//*[@placeholder='Last Name']"),contact.getLastName());
        type(By.xpath("//*[@placeholder='Phone']"),contact.getPhone());
        type(By.xpath("//*[@placeholder='email']"),contact.getEmail());
        type(By.xpath("//*[@placeholder='Address']"),contact.getAddress());
        type(By.xpath("//*[@placeholder='description']"),contact.getDescription());
        logger.info("Fields contacts filled");
    }

    public void saveContact() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Save']"))).click();
        logger.info("Contact added");
    }

    public int getContactCount() {
        return wd.findElements(By.cssSelector("[class='contact-page_leftdiv__yhyke'] div")).size();
    }

    public boolean isContactByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for(WebElement e: list)
        {
            if(e.getText().equals(name))
            {
                return true;
            }
        }
        return false;
    }
    public boolean isContactByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for(WebElement e: list)
        {
            if(e.getText().equals(phone))
            {
                return true;
            }
        }
        return false;
    }

    public void removeOneContactByNumber(String number) {
        click(By.xpath("//*[text()='"+ number+"']/ancestor::div[1]"));
        pause(500);
        click(By.xpath("//*[text()='Remove']"));
        pause(500);
    }

    public boolean isContactNotFound(String number) {
       return isElementPresent(By.xpath("//*[text()='"+ number+"']/ancestor::div[1]"));
    }

    public void removeAllContacts() {
        List<WebElement> list = wd.findElements(By.xpath("//*[@class='contact-item_card__2SOIM']"));
       for(int i = 0; i<list.size(); i++)
       {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='contact-item_card__2SOIM']"))).click();
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Remove']"))).click();
          pause(500);
       }
    }

    public boolean isContactsNotFound() {
       return isElementPresent(By.xpath("//*[@class='contact-item_card__2SOIM']"));
    }

    public int isContactsSum() {
        List<WebElement> list = new ArrayList<>();
        list= wd.findElements(By.xpath("//*[@class='contact-item_card__2SOIM']"));
        return list.size();
    }

    public int removeOneContact() {
        int countBefore = countOfContacts();
        if(!isCountListEmpty()){
            click(By.xpath("//*[@class='contact-item_card__2SOIM']"));
            click(By.xpath("//*[text()='Remove']"));
            pause(500);
        }
       int countAfter = countOfContacts();
        return countBefore-countAfter;
    }

    private boolean isCountListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void removeAllContactsT() {
        while( wd.findElements(By.xpath("//*[@class='contact-item_card__2SOIM']")).size()!=0) {
            click(By.xpath("//*[@class='contact-item_card__2SOIM']"));
            click(By.xpath("//*[text()='Remove']"));
            pause(500);
        }
    }
}
