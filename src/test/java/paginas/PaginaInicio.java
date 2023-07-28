package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Elementos de la página que voy a utilizar para las pruebas
	@FindBy(partialLinkText="Sign")
	WebElement lnkSignIn;
	
	@FindBy(css="#search_query_top")
	WebElement txtBuscador;
	
	// Constructor
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	// Acciones que se pueden hacer sobre los elementos de la página
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void escribirPalabraABuscar(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerBusqueda() {
		txtBuscador.sendKeys(Keys.ENTER);
	}
}
