package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openAddForm() {
        click(By.xpath("//a[@href='/add']"));
    }

    public void fillAddContactForm(Contact contact) {
        type(By.xpath("//*[@placeholder='Name']"),contact.getName());
        type(By.xpath("//*[@placeholder='Last Name']"),contact.getLastName());
        type(By.xpath("//*[@placeholder='Phone']"),contact.getPhone());
        type(By.xpath("//*[@placeholder='email']"),contact.getEmail());
        type(By.xpath("//*[@placeholder='Address']"),contact.getAddress());
        type(By.xpath("//*[@placeholder='description']"),contact.getDescription());
    }

    public void saveContact() {
        click(By.xpath("//*[text()='Save']"));
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
}
