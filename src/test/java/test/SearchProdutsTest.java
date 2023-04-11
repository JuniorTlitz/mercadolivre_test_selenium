package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import suporte.Web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
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
    public void testSearchInfo() throws Exception {

        File logFile = new File("D:\\Prints\\log.txt");
        logFile.createNewFile();

        PrintStream printStream = new PrintStream(new FileOutputStream(logFile));
        System.setOut(printStream);

        String item = "";
        String preco = "";
        navegador.findElement(By.xpath("/html/body/header/div/div[2]/form/input")).sendKeys("ps5");
        navegador.findElement(By.xpath("/html/body/header/div/div[2]/form/button")).click();
        List<WebElement> qtdItens = navegador.findElements(By.xpath("//h2[@class='ui-search-item__title shops__item-title']"));
        int count = qtdItens.size();

        for(int i = 1; i <= count; i++){
            item = navegador.findElement(By.xpath("((//h2[@class='ui-search-item__title shops__item-title']))["+i+"]")).getText();
            preco = navegador.findElement(By.xpath("((//span[@class='price-tag-amount']))["+i+"]")).getText();

            System.out.println(item);
            System.out.println(preco.replace("\n", ""));
        }

        printStream.close();
    }
}
