package tests;

import manager.MyDataProvider;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AddNewContacts extends TestBase{
    @BeforeSuite(alwaysRun = true)
    public void preConditions(){
        if(app.getUser().isLoginRegistrationSuccess()==false)
        {
            new LoginTests().loginSuccessNewModel();
        }logger.info("Logged with:asdhgf@gmail.com,Nnoa12345$" );

    }
    @Test(groups = {"web","reg","quick"})
    public void addNewContactSuccess(){
        int index = (int)System.currentTimeMillis()/1000%3600;
        Contact contact = Contact.builder().name("Max").lastName("Kugel").phone("586"+ index + "569").email("no456a" +index +"@gmail.com")
                .address("Bobruisk").description("friend").build();
        System.out.println(contact.getName());

        int beforeContacts = app.getContact().getContactCount();
        app.getContact().openAddForm();
        app.getContact().fillAddContactForm(contact);
        logger.info("Fill addContact form:" + contact.toString());
        app.getContact().saveContact();
        int afterContacts = app.getContact().getContactCount();
       // Assert.assertEquals(afterContacts-1,beforeContacts);
        Assert.assertTrue(app.getContact().isContactByName(contact.getName()));
        Assert.assertTrue(app.getContact().isContactByPhone(contact.getPhone()));
    }
    @Test
    public void addNewContact(){
        int index = (int)System.currentTimeMillis()/1000%3600;
        Contact contact = Contact.builder().name("Max").lastName("Kugel").phone("586"+ index + "569").email("no456a" +index +"@gmail.com")
                .address("Bobruisk").description("friend").build();
        app.getContact().openAddForm();
        app.getContact().fillAddContactForm(contact);
        logger.info("Fill addContact form:" + contact.toString());
        app.getContact().saveContact();

    }
    @Test(dataProvider = "validDataContact",dataProviderClass = MyDataProvider.class)
    public void addNewContactDataProviderCSV(Contact contact){
        int index = (int)System.currentTimeMillis()/1000%3600;
        contact.setEmail("no456a" +index +"@gmail.com");
        contact.setPhone("586"+ index + "569");


        app.getContact().openAddForm();
        app.getContact().fillAddContactForm(contact);
        logger.info("Fill addContact form:" + contact.toString());
        app.getContact().saveContact();
        Assert.assertTrue(app.getContact().isContactByName(contact.getName()));
        Assert.assertTrue(app.getContact().isContactByPhone(contact.getPhone()));
    }
}
