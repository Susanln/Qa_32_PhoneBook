package tests;
import manager.ApplicationManager;
import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends  TestBase {
    @BeforeMethod
    public void preCondition()
    {
        if(app.getUser().isLoginRegistrationSuccess())
        {
            app.getUser().logout();
        }
    }
    @Test
    public void loginSuccessNew()
    {
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm("noa@gmail.com","Nnoa12345$");
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoginRegistrationSuccess());
    }
    @Test
    public void loginSuccessNewModel()
    {
        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLoginRegistrationSuccess());
    }
    @Test
    public void loginUnsuccess(){
        User user = new User().withEmail("noa@gmail.com").withPassword("12345");
        WebDriver wd;
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();

        app.getUser().findAlert();
        Assert.assertTrue(app.getUser().isErrorDisplayed());
    }

}
