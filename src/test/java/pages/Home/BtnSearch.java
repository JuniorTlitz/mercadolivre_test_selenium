package pages.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BtnSearch {
    private WebDriver navegador;
    public BtnSearch(WebDriver navegador){
        this.navegador = navegador;
    }
    public void clickSearch(){
        navegador.findElement(By.xpath("/html/body/header/div/div[2]/form/button")).click();
    }
}
