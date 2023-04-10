package pages.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageTest {
    private WebDriver navegador;
    public HomePageTest(WebDriver navegador){this.navegador = navegador;}
    public BtnSearch typeSearch(String search){
        navegador.findElement(By.id("cb1-edit")).sendKeys(search);
        return new BtnSearch(navegador);
    }


}
