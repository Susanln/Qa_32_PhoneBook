package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        click(By.cssSelector("[href='/login']"));
        logger.info("Login/Reg form opened");
    }

    public void fillLoginRegistrationForm(String login, String password) {
        type(By.xpath("//input[1]"),login);
        type(By.xpath("//input[2]"),password);
        logger.info("Fields log/reg form filled");
    }
    public void fillLoginRegistrationForm(User user) {
        type(By.xpath("//input[1]"),user.getEmail());
        type(By.xpath("//input[2]"),user.getPassword());
        logger.info("Fields log/reg form filled");
    }

    public void submitLogin() {
        click(By.xpath("//*[text()=' Login']"));
        logger.info("Logged");
    }


    public boolean isLoginRegistrationSuccess() {
                return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[2]"));
        logger.info("Registered");
    }

    public void logout() {
        click(By.xpath("//*[text()='Sign Out']"));
        logger.info("Logged out");
    }

    public void findAlert() {
        WebDriverWait wait = new WebDriverWait(wd, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = wd.switchTo().alert();
        alert.accept();
    }
    public boolean isErrorDisplayed() {
        Boolean er = new WebDriverWait(wd, 5).until(ExpectedConditions.textToBePresentInElement
                (wd.findElement(By.cssSelector("[class='login_login__3EHKB'] :first-child")), "Login Failed with code 400"));

        return er;
    }

    public boolean isAlertDisplayed() {
        Alert alert = new WebDriverWait(wd, 5).until(ExpectedConditions.alertIsPresent());
        if(alert==null)
        {
            logger.info("Alert 'not displayed'");
            return false;
        }else{
            logger.info("Alert 'displayed'");
            return true;
        }

    }
    public boolean isErrorWrongFormat() {
        Alert alert = new WebDriverWait(wd, 5).until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert();
        String error = alert.getText();
        alert.accept();
        return  error.contains("Wrong email or password format");
    }
}
