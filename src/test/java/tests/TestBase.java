package tests;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp (){
        app.init();
    }
    @AfterSuite
    public void tearDown(){
       app.stop();
    }
    @BeforeMethod
    public void startMethods(Method method)
    {
        logger.info("Start test---->"+method.getName());
    }
    @AfterMethod
    public void finishMethod()
    {
        logger.info("****************************************************************************************************");
    }



}
