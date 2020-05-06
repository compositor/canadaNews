import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);

    }
    @FindBy(css = ".asset-title")
    private List<WebElement> news;



  public String getNews(){
        wait.until(ExpectedConditions.visibilityOf(news.get(0)));
        return news.get(0).getText();
    }

    public static void main(String [ ] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        driver.get("https://canada.mid.ru/novosti");

        BasePage basePage = new BasePage(driver);
        System.out.println(basePage.getNews());
        if (basePage.getNews().contains("Консульское обслуживание")){
            System.out.println("Можно записываться");
        }else System.out.println("Ждемс");

        driver.quit();
    }

}
