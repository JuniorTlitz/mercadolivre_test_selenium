package suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {
    public static void takeScreenShot(WebDriver driver, String file){
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenShot, new File(file));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
