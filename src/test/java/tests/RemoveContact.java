package tests;

import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preConditions()
    {
        if (app.getContact().isLoginRegistrationSuccess()==false) {
            new LoginTests().loginSuccessNewModel();
        }
        else app.getContact().click(By.xpath("//*[@href='/contacts']"));
        if(app.getContact().isContactsSum()<=1)
        {
            for(int i=0;i<5;i++)
            {
                new AddNewContacts().addNewContact();
                app.getContact().pause(500);
            }
        }
    }
//    @Test
//    public void removeOneContactByNumber(){
//        app.getContact().removeOneContactByNumber("586-546569");
//        Assert.assertFalse(app.getContact().isContactNotFound("586-546569"));
//    }
    @Test(groups = {"web"})
    public void removeOneContact(){
        Assert.assertEquals(app.getContact().removeOneContact(),1);
    }
    @Test
    public void removeAllContact(){
        app.getContact().removeAllContacts();
        Assert.assertFalse(app.getContact().isContactsNotFound());
    }
    @Test
    public void removeAllContactT(){
        app.getContact().removeAllContactsT();
        Assert.assertFalse(app.getContact().isContactsNotFound());
    }

}
