import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;


    @BeforeClass
    public static void setUp() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sergeisysoev/Automation/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        driver.get("https://canada.mid.ru/novosti");

    }
    @AfterClass
    public static void finish(){driver.quit();}



}
