import org.junit.Test;

public class NewsTest extends BaseTest {

    private BasePage basePage;

    @Test

    public void testNews()  {
        basePage = new BasePage(driver);
        System.out.println(basePage.getNews());
        if (basePage.getNews().contains("Консульское обслуживание")){
            System.out.println("Можно записываться");
        }else System.out.println("Ждем");
    }
}
