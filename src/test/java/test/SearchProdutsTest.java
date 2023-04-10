package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import suporte.Web;

import java.util.List;

public class SearchProdutsTest {
    private WebDriver navegador;
    @Before
    public void setUp(){
        navegador = Web.createChrome();
    }
    @After
    public void tearDown(){
        navegador.quit();
    }
    @Test
    public void testSearchInfo(){
        //new HomePageTest(navegador).typeSearch("ps5").clickSearch();

        navegador.findElement(By.xpath("/html/body/header/div/div[2]/form/input")).sendKeys("ps5");
        navegador.findElement(By.xpath("/html/body/header/div/div[2]/form/button")).click();

        List<WebElement> aElements = navegador.findElements(By.xpath("//*[@id=\"root-app\"]/div/div[2]/section/ol[1]/li[2]/div/div/div[2]/div/div[2]/a"));
        // Interar através dos links
        for(WebElement link : aElements){
            // clica no link
            link.click();
            // Coleta as informaçoes
            // /html/body/main/div[2]/div[3]/div[1]/div[1]/div/div[3]/div/section/div[3]/div/div/div/div[1]/div[1]/table/tbody/tr[3]/td/span
            WebElement modeloSearch = navegador.findElement(By.xpath("/html/body/main/div[2]/div[3]/div[1]/div[1]/div/div[3]/div/section/div[3]/div/div/div/div[1]/div[1]/table/tbody/tr[3]/td/span"));
            if(modeloSearch.getText().equals("PlayStation 5")){
                WebElement priceSearch = navegador.findElement(By.xpath("/html/body/main/div[2]/div[3]/div[1]/div[1]/div/div[1]/div[2]/div[2]/div[1]/span/span[3]"));
                System.out.println(priceSearch);
            } else {
                // Retorna á pagina anterior
                navegador.navigate().back();
            }
        }
    }
}
