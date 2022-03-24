package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void preCondition()
    {
        if(app.getUser().isLoginRegistrationSuccess())
        {
            app.getUser().logout();
        }
    }
    @Test
    public void registrationSuccess() {
        int index = (int)System.currentTimeMillis()/1000%3600;
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm("no456a" +index +"@gmail.com","Nnoa12345$");
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isLoginRegistrationSuccess());


    }
    @Test
    public void registrationSuccessModel() {
        int index = (int)System.currentTimeMillis()/1000%3600;
        User user = new User().withEmail("no456b" +index +"@gmail.com").withPassword("Nnoa12345$");
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isLoginRegistrationSuccess());


    }
}
