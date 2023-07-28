package pruebas;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaAlerta;

public class Clase8Test {
	String url = "https://demoqa.com/alerts";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito"); 
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void alertaNotificacion() {
		PaginaAlerta alerta = new PaginaAlerta(driver);
		alerta.clicEnNotificacion();
		
		alerta.obtenerAlerta(driver).accept();
	}
	
	@Test
	public void alertaConDemora() {
		PaginaAlerta alerta = new PaginaAlerta(driver);
		alerta.clicEnDemora();
		
		// Introducir una espera
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		
		alerta.obtenerAlerta(driver).accept();
	}
}
