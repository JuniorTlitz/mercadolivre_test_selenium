package test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

        // Palavras-chave a serem buscadas
        String[] palavrasChave = {"PS5", "PlayStation 5", "Playstation 5"};

        // Search Ps5 and click
        driver.findElement(By.xpath("/html/body/header/div/div[2]/form/input")).sendKeys("ps5");
        driver.findElement(By.xpath("/html/body/header/div/div[2]/form/button")).click();

        // Localizar todos os elementos ol na página pelo seu seletor CSS
        List<WebElement> olElements = driver.findElements(By.tagName("ol"));

        // Iterar através dos elementos ol
        for (WebElement olElement : olElements) {
            // Localizar todos os itens de lista (li) dentro do elemento ol
            List<WebElement> liElements = olElement.findElements(By.tagName("li"));

            // Iterar através dos itens de lista
            for (WebElement liElement : liElements) {
                // Verificar se o texto do item de lista contém alguma das palavras-chave
                String txtLi = liElement.getText();
                for (String palavraChave : palavrasChave) {
                    if (txtLi.contains(palavraChave)) {
                        // Se o texto do item de lista contém a palavra-chave, clicar no link
                        liElement.findElement(By.tagName("a"));
                        liElement.click();

                        // Aguardar a página ser carregada
                        // (substitua a espera fixa abaixo pela espera adequada ao seu cenário)
                        Thread.sleep(5000);

                        // Coletar informações de modelo e preço da página aberta
                        String modelo = driver.findElement(By.xpath("/html/body/main/div/div[2]/section/ol[1]/li[1]/div/div/div[2]/div/div[1]/a")).getText();
                        String preco = driver.findElement(By.xpath("/html/body/main/div/div[2]/section/ol[1]/li[1]/div/div/div[2]/div/div[2]/div/div/div/span[1]/span[1]")).getText();

                        // Exibir as informações coletadas
                        System.out.println("Modelo: " + modelo);
                        System.out.println("Preço: " + preco);

                        // Retornar para a página anterior
                        driver.navigate().back();
                        break;
                    }
                }
            }
        }

        // Fechar o navegador
        driver.quit();
    }
}
