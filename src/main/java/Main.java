import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    /*Domaći:
Otići na http://www.strela.co.rs/, kliknuti na dugme Prodavnica u headeru, izabrati opciju Lukovi - Bows iz leve
navigacije, potom kliknuti na luk koji se zove Samick Sage, i onda proveriti da ime tog luka na njegovoj stranici
zaista sadrži reč Samick.*/
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mila-\\Desktop\\EXE file\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(50));


        driver.navigate().to("http://www.strela.co.rs/");
        String expectedUrl = driver.getCurrentUrl();

        if (!expectedUrl.equals("http://www.strela.co.rs/")) {
            System.out.println("Me: ( ˘ ɜ˘) ♬♪♫   clicks play.. it's loading!");
            System.out.println("The servers:  Σ(°△°|||)︴ Another one!! There's too many of them!!! (￢_￢)  (↼_↼)  ... (╯°益°)╯彡┻━┻ ");
            System.out.println("The site: [ ± _ ± ]  (Sad violin music in the background)");
            System.out.println("Me: (ﾉಥ益ಥ)ﾉ NOOOOOO!! Oh..cruel fates! (Faints theatrically)");
            System.out.println("The end!");
        }
        // prodavnica xpath    //*[@id="ctl00_RadMenu1"]/ul/li[2]/a/span/strong

        driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]/a/span/strong")).click();

        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]")).click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img")));

        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img")).click();

        String title = driver.findElement(By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel")).getText();

        if (title.contains("Samick")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        driver.close();


    }
}
