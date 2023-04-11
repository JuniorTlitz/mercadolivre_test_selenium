package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import suporte.Web;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchTest {
    @Test
    public void SearchPs5Test() throws InterruptedException {
        // Configurar o caminho do driver do Selenium
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

        // Instanciar o driver do Selenium
        WebDriver driver = new ChromeDriver();

        // Navegar para a página da web
        driver.get("https://www.mercadolivre.com.br/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //h2[@class='ui-search-item__title shops__item-title']

        driver.findElement(By.xpath("/html/body/header/div/div[2]/form/input")).sendKeys("ps5");
        driver.findElement(By.xpath("/html/body/header/div/div[2]/form/button")).click();

        // Palavras-chave a serem buscadas
        String[] palavrasChave = {"PS5", "PlayStation 5", "Playstation 5"};

        List<WebElement> h2Elements = driver.findElements(By.xpath("//h2[@class='ui-search-item__title shops__item-title']"));
        List<WebElement> spanElements = driver.findElements(By.xpath("//span[@class='price-tag-amount']"));

//        List<WebElement> spanSymbolElements = driver.findElements(By.xpath("//span[@class='price-tag-symbol']"));
//        List<WebElement> spanPriceElements = driver.findElements(By.xpath("//span[@class='price-tag-fraction']"));

//        for(WebElement h2Element : h2Elements){
//
//            String textoLi = h2Element.getText();
//
//        }

        for(WebElement h2Element : h2Elements){
            System.out.println(h2Element.getText());
            for(WebElement spanElement : spanElements){
                System.out.println(spanElement.getText().replace("\n", ""));
                break;
            }
        }

        driver.quit();
    }
}
