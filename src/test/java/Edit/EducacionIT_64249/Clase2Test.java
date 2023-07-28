package Edit.EducacionIT_64249;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Clase2Test {
	// Comentario de una línea
	
	/*
	 * Comentario de 
	 * más de una línea
	 */
	
	// 1) Variables: Valores de uso común (String, int, etc...)
	String url = "http://www.automationpractice.pl";
	
	// 2) Métodos: conjunto de pasos de un caso de prueba
	@Test
	public void buscarProductoFirefox() {
		// Paso 1: Definir qué navegador quiero usar
		WebDriver navegador = new FirefoxDriver();
		
		// Paso 2: Abrir el navegador en la página de prueba
		navegador.get(url);
		
		// Maximizar la ventana
		navegador.manage().window().maximize();
		
		// Limpiar las cookies
		navegador.manage().deleteAllCookies();
		
		// Paso 3: Escribir el producto a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Paso 4: Hacer la búsqueda (simular que presionamos ENTER)
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Paso 5: Cerrar el navegador
	}
	
	@Test
	public void buscarProductoChrome() {
		// Paso 1: Definir qué navegador quiero usar
		WebDriverManager.chromedriver().setup();
		WebDriver navegador = new ChromeDriver();
		
		// Paso 2: Abrir el navegador en la página de prueba
		navegador.get(url);
		
		// Paso 3: Escribir el producto a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Paso 4: Hacer la búsqueda (simular que presionamos ENTER)
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Paso 5: Cerrar el navegador
		navegador.close();
	}
}
