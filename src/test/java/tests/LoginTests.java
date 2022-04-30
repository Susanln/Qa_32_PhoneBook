package tests;

import manager.MyDataProvider;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getUser().isLoginRegistrationSuccess()) {
            app.getUser().logout();
        }
    }

    @Test(dataProvider = "validLoginData",dataProviderClass = MyDataProvider.class)
    public void loginSuccessNew(String email, String password) {
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        logger.info("Loggin with email: "+ email + "password: "+password);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoginRegistrationSuccess());
    }

    @Test(groups = {"web"})
    public void loginSuccessNewModel() {
        User user = new User().withEmail("asdhgf@gmail.com").withPassword("Nnoa12345$");
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        logger.info("Loggin with:"+ user.toString());
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoginRegistrationSuccess());
    }
    @Test(dataProvider = "validModelLogin", dataProviderClass = MyDataProvider.class)
    public void loginSuccessNewModel(User user) {
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoginRegistrationSuccess());
    }
    @Test(dataProvider = "validModelCSV", dataProviderClass = MyDataProvider.class)
    public void loginSuccessNewModelCSV(User user) {
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoginRegistrationSuccess());
    }

    @Test
    public void loginUnsuccess() {
        User user = new User().withEmail("asdhgf@gmail.com").withPassword("12345");
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        logger.info("Login with:" + user.toString());
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isAlertDisplayed());

        // app.getUser().findAlert();
        // Assert.assertTrue(app.getUser().isErrorDisplayed());
        Assert.assertTrue(app.getUser().isErrorWrongFormat());
    }

}
