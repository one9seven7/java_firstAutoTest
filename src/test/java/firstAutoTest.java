import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firstAutoTest {

    @Test
    public void firstAutoTest() {

        System.setProperty("webdriver.chrome.driver", "c:/drivers/chrome/chromedriver100.exe");
        //System.setProperty("webdriver.firefox.driver","c:/drivers/firefox/xxxxxxxxxxxxx");
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        //driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        WebElement znalezionyInputHasla = driver.findElement(By.id("password"));
        znalezionyInputHasla.sendKeys("SuperSecretPassword!");

        driver.findElement(By.className("radius")).click();

        Assertions.assertEquals("https://the-internet.herokuapp.com/secure", driver.getCurrentUrl());

        driver.close();

    }

    @Test
    public void secondAutoTest(){
        System.setProperty("webdriver.chrome.driver", "c:/drivers/chrome/chromedriver100.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        driver.findElement(By.name("username")).sendKeys("tomsmith1");

        WebElement znalezionyInputHasla = driver.findElement(By.id("password"));
        znalezionyInputHasla.sendKeys("SuperSecretPassword!");

        driver.findElement(By.className("radius")).click();

        Assertions.assertEquals("Your username is invalid!\n" + "×",driver.findElement(By.id("flash")).getText());

        driver.close();

    }

}
