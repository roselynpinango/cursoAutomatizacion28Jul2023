package Edit.EducacionIT_64249;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileEmulationTest {
	@Test
	public void testMobileEmulation() {
		Map<String, Object> deviceMetrics = new HashMap<>();
	    deviceMetrics.put("width", 375);
	    deviceMetrics.put("height", 667);
	    deviceMetrics.put("pixelRatio", 2.0);

	    Map<String, Object> mobileEmulation = new HashMap<>();
	    mobileEmulation.put("deviceMetrics", deviceMetrics);
	    mobileEmulation.put("userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.34 (KHTML, like Gecko) Version/11.0 Mobile/15A5341f Safari/604.1");

	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
	    
	    WebDriverManager.chromedriver().setup(); // Inicializa el navegador Chrome
	    
	    WebDriver driver = new ChromeDriver(chromeOptions);
	    driver.get("http://automationpractice.pl");
	    driver.manage().window().maximize();
	    
	    // Pasos para ir a Contactanos
	 	driver.findElement(By.linkText("Contact us")).click();
	 		
	 	Select lista = new Select(driver.findElement(By.id("id_contact")));
	 	lista.selectByVisibleText("Webmaster");
	 		
	 	driver.findElement(By.name("from")).sendKeys("correob@mailinator.com");
	 	driver.findElement(By.id("message")).sendKeys("Comentarios del Contacto");
	 		
	 	// Subir un archivo - Escribir en el campo deshabilitado donde va el nombre del archivo
	 	driver.findElement(By.id("fileUpload")).sendKeys("C:\\addIntegerData.txt");
	 		
	 	driver.findElement(By.cssSelector("#submitMessage")).click();
	}
}
