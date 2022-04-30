package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    @BeforeMethod(alwaysRun = true)
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
        logger.info("Registration with: Login=no456a" +index +"@gmail.com"+ "password=Nnoa12345$" );
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isLoginRegistrationSuccess());


    }
    @Test(groups = {"web"})
    public void registrationSuccessModel() {
        int index = (int)System.currentTimeMillis()/1000%3600;
        User user = new User().withEmail("no456b" +index +"@gmail.com").withPassword("Nnoa12345$");
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        logger.info("Registration with:"+ user.toString());
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isLoginRegistrationSuccess());


    }
}
