package machinetest1;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionalTest {
	public static void main(String[] args) throws AWTException, IOException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.dealsdray.com/");
		driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.className("MuiButton-root")).click();
		driver.findElement(By.className("MuiIcon-fontSizeSmall")).click();
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		driver.findElement(By.className("MuiButton-root")).click();
		driver.findElement(By.className("MuiOutlinedInput-input")).sendKeys("C:\\Users\\shaik\\OneDrive\\Documents\\demo-data.xlsx");
        driver.findElement(By.xpath("//button[text()='Import']")).click();
        driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        TakesScreenshot ts=(TakesScreenshot)driver;
	    File src=ts.getScreenshotAs(OutputType.FILE);
	    File trg=new File("./Screenshot/FunctionalTest.png");
	    FileUtils.copyFile(src, trg);
	    driver.close();
	    
        
	}

}
