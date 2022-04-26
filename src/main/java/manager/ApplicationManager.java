package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EventListener;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver wd;
  //  WebDriver wd;
    UserHelper user;
    ContactHelper contact;
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);

    public void init(){
        wd=new EventFiringWebDriver( new ChromeDriver());
        logger.info("All tests start in 'ChromeDriver'");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        user = new UserHelper(wd);
        contact = new ContactHelper(wd);
        wd.register(new MyListener());
    }
    public void stop(){
        wd.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }
}
