package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase8bTest {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		String ruta = "..\\EducacionIT-64249\\Datos\\Datos_Login25Jul2023.xlsx";
		String nombreHoja = "Hoja1";
		
		return DatosExcel.leerExcel(ruta, nombreHoja);
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[5][2];
		
		datos[0][0] = "abc@gmail.com";
		datos[0][1] = "34r4wt4ewt";
		
		datos[1][0] = "def@gmail.com";
		datos[1][1] = "ew43r43wr4";
		
		datos[2][0] = "ghi@gmail.com";
		datos[2][1] = "45y5ey4e";
		
		datos[3][0] = "jkl@gmail.com";
		datos[3][1] = "45e4ryt4e";
		
		datos[4][0] = "mno@gmail.com";
		datos[4][1] = "76iu76tit";
		
		return datos;
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
}
