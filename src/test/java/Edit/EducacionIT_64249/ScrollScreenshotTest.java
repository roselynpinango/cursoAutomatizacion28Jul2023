package Edit.EducacionIT_64249;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;

public class ScrollScreenshotTest {
	WebDriver driver;
	
	@Test
	public void scrollScreenshotTest() throws Exception {
		driver = new FirefoxDriver();
		driver.get("http://www.bbc.com");       
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(s.getImage(),"PNG",new File("..\\EducacionIT-64249\\Evidencias\\fullPageScreenshot.png"));
		
        System.out.println("Termine el script!");
        
		driver.close();
	}
	
}
