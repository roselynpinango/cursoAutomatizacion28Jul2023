package Edit.EducacionIT_64249;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Clase4Test {
	String url = "http://www.automationpractice.pl";
	
	@Test
	public void registrarUsuario() {
		// Paso 1: Definir qué navegador vamos a utilizar
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// Paso 2: Abrir la página de prueba
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Paso 3: Hacer clic en 'Sign In'
		WebElement lnkSignIn = driver.findElement(By.partialLinkText("Sign"));
		lnkSignIn.click();
		
		//String email = "correo" + Math.random() + "@gmail.com";
		
		Faker faker = new Faker();
		String email = faker.internet().emailAddress();
		
		// Paso 4: Escribir el correo y hacer clic en 'Create An Account'
		WebElement txtEmail = driver.findElement(By.name("email_create"));
		txtEmail.sendKeys(email);
		
		WebElement btnCreate = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
		btnCreate.click();
		
		// Espera
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		// Paso 5: Completar el formulario
		WebElement radTitle = driver.findElement(By.id("id_gender1"));
		radTitle.click(); // Radio button (Mr.)
		
		String firstName = faker.name().firstName();
		
		WebElement txtFirstName = driver.findElement(By.cssSelector("#customer_firstname"));
		txtFirstName.sendKeys(firstName);
		
		String lastName = faker.name().lastName();
		
		WebElement txtLastName = driver.findElement(By.name("customer_lastname"));
		txtLastName.sendKeys(lastName);
		
		WebElement txtModifiedEmail = driver.findElement(By.xpath("//input[@id='email']"));
		txtModifiedEmail.clear(); // Borra el contenido actual del campo
		txtModifiedEmail.sendKeys(email); // Escribo el nuevo valor del campo
		
		WebElement txtPassword = driver.findElement(By.cssSelector("#passwd"));
		txtPassword.sendKeys("1q2w3e4r5t");
		
		Select selDays = new Select(driver.findElement(By.cssSelector("#days")));
		selDays.selectByVisibleText("18  ");
		
		Select selMonths = new Select(driver.findElement(By.id("months")));
		selMonths.selectByValue("6");
		
		Select selYears = new Select(driver.findElement(By.name("years")));
		selYears.selectByIndex(30);
		
		WebElement chkNews = driver.findElement(By.xpath("//input[@id='newsletter']"));
		chkNews.click();
		
		// Paso 6: Hacer clic en 'Register'
		WebElement btnRegister = driver.findElement(By.id("submitAccount"));
		btnRegister.click();
	}
}
