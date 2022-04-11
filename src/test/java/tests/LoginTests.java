package tests;

import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLoginRegistrationSuccess()) {
            app.getUser().logout();
        }
    }

    @Test
    public void loginSuccessNew() {
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm("asdhgf@gmail.com", "Nnoa12345$");
        logger.info("Loggin with: email=asdhgf@gmail.com password=Nnoa12345$");
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoginRegistrationSuccess());
    }

    @Test
    public void loginSuccessNewModel() {
        User user = new User().withEmail("asdhgf@gmail.com").withPassword("Nnoa12345$");
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        logger.info("Loggin with:"+ user.toString());
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoginRegistrationSuccess());
    }

    @Test
    public void loginUnsuccess() {
        User user = new User().withEmail("asdhgf@gmail.com").withPassword("12345");
        WebDriver wd;
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
