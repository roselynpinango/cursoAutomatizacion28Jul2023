package Edit.EducacionIT_64249;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Clase5Test {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	String directorioEvidencias = "..\\EducacionIT-64249\\Evidencias\\";
	String nombreDocumento = "Documento de Evidencias - AutomationPractice.docx";
	File pantalla;
	
	@BeforeSuite
	public void abrirNavegador() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(description="CP01 - Ir a Contactanos",priority=10)
	public void irAContactanos() throws InvalidFormatException, IOException, InterruptedException {
		// Capturar Evidencias
		CapturaEvidencia.escribirTituloEnDocumento(
				directorioEvidencias + nombreDocumento,
				"Documento de Evidencias - Contact us",
				20);
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreDocumento,
				"Paso 1: Pantalla Principal");
		
		// Hacer clic en Contact us
		WebElement lnkContact = driver.findElement(By.linkText("Contact us"));
		lnkContact.click();
		
		// Capturar Evidencias
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreDocumento,
				"Paso 2: Luego de hacer clic en Contact us");
		
		// Completar el formulario de contacto
		Select listSubject = new Select(driver.findElement(By.cssSelector("#id_contact")));
		listSubject.selectByVisibleText("Webmaster");
		
		WebElement txtEmail = driver.findElement(By.id("email"));
		txtEmail.sendKeys("correo01@gmail.com");
		
		WebElement txtOrder = driver.findElement(By.xpath("//input[@id='id_order']"));
		txtOrder.sendKeys("123-ABC");
		
		WebElement filAdjunto = driver.findElement(By.name("fileUpload"));
		filAdjunto.sendKeys("C:\\addIntegerData.txt");
		
		WebElement txtMessage = driver.findElement(By.tagName("textarea"));
		txtMessage.sendKeys("Mensaje de Contacto del Cliente");
		
		// Capturar Evidencias
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreDocumento,
				"Paso 3: Luego de Completar el Formulario");
		
		// Hacer clic en Send
		WebElement btnSend = driver.findElement(By.xpath("//button[@id='submitMessage']"));
		btnSend.click();
		
		// Capturar Evidencias
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreDocumento,
				"Paso 4: Luego de enviar el formulario de Contacto");
	}
	
	@Test(description="CP02 - Buscar Palabra",priority=1)
	public void buscarPalabra() throws IOException {
		// Capturar Evidencia: Pantalla Inicial
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(directorioEvidencias + "01_PantallaInicial.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Capturar Evidencia: Palabra a Buscar
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(directorioEvidencias + "02_PalabraABuscar.jpg"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Capturar Evidencia: Resultados de la Búsqueda
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(directorioEvidencias + "03_ResultadoBusqueda.jpg"));
		
		// Validar que el titulo de la pagina / URL de la página cambió
		// TestNG > Assertions
		String tituloEsperado = "Search - My Shop";
		String tituloActual = driver.getTitle(); // Devuelve el titulo de la pagina en este momento
		
		String urlEsperada = "http://www.automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		String urlActual = driver.getCurrentUrl(); // Devuelve la URL actual 
		
		Assert.assertEquals(tituloActual, tituloEsperado, "ERROR-01: El titulo de la página no cambió"); // Compara si dos valores son iguales: Resultado Esperado y Resultado Obtenido
		Assert.assertEquals(urlActual, urlEsperada);
	
		/* Assert no vinculante, no bloquea la ejecución del script
		Assertion soft = new SoftAssert();
		soft.assertEquals(tituloActual, tituloEsperado);
		*/
		
		/*
		Assert.assertNotEquals("A", "B"); // Valida que los dos valores no sean iguales
		Assert.assertTrue(1 == 1); 
		Assert.assertFalse(2 == 3);
		Assert.assertNull(null); // null significa no definido
		Assert.assertNotNull(urlActual);
		Assert.assertTrue(cantidadProductos > 0);
		*/ 
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
	}
}
