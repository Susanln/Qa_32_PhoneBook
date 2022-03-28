package tests;

import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AddNewContacts extends TestBase{
    @BeforeSuite
    public void preConditions(){
        if(app.getUser().isLoginRegistrationSuccess()==false)
        {
            app.getUser().openLoginRegistrationForm();
            app.getUser().fillLoginRegistrationForm("asdhgf@gmail.com","Nnoa12345$");
            app.getUser().submitLogin();
            Assert.assertTrue(app.getUser().isLoginRegistrationSuccess());
        }

    }
    @Test
    public void addNewContactSuccess(){
        int index = (int)System.currentTimeMillis()/1000%3600;
        Contact contact = Contact.builder().name("Max").lastName("Kugel").phone("586"+ index + "569").email("no456a" +index +"@gmail.com")
                .address("Bobruisk").description("friend").build();
        int beforeContacts = app.getContact().getContactCount();
        app.getContact().openAddForm();
        app.getContact().fillAddContactForm(contact);
        app.getContact().saveContact();
        int afterContacts = app.getContact().getContactCount();
        Assert.assertEquals(afterContacts-1,beforeContacts);

    }

}
