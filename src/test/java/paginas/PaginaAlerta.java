package paginas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaAlerta {
	@FindBy(css="#alertButton")
	WebElement btnNotificacion;
	
	@FindBy(id="timerAlertButton")
	WebElement btnDemora;
	
	@FindBy(xpath="//button[@id='confirmButton']")
	WebElement btnConfirmacion;
	
	@FindBy(id="promtButton")
	WebElement btnEscribir;
	
	public PaginaAlerta(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clicEnNotificacion() {
		btnNotificacion.click();
	}
	
	public void clicEnDemora() {
		btnDemora.click();
	}
	
	public void clicEnConfirmacion() {
		btnConfirmacion.click();
	}
	
	public void clicEnEscribir() {
		btnEscribir.click();
	}
	
	public Alert obtenerAlerta(WebDriver driver) {
		return driver.switchTo().alert();
	}
}
