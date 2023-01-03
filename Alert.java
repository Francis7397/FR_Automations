import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
	    driver.findElement(By.cssSelector(".btn-danger")).click();
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
		driver.findElement(By.cssSelector(".btn-primary")).click();
		org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
		String alertMessage1 = driver.switchTo().alert().getText();
		System.out.println(alertMessage1);
		alert1.accept();
		driver.switchTo().defaultContent();
		String message = driver.findElement(By.xpath("//p[contains(text(),'You pressed Ok')]")).getText();
		System.out.println(message);
		driver.findElement(By.cssSelector(".btn-primary")).click();
		alert1.dismiss();
		String message1 = driver.findElement(By.xpath("//p[contains(text(),'You Pressed Cancel')]")).getText();
		System.out.println(message1);
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
		driver.findElement(By.cssSelector(".btn-info")).click();
		org.openqa.selenium.Alert alert2 = driver.switchTo().alert();
		String alertMessage2 = driver.switchTo().alert().getText();
		System.out.println(alertMessage2);
		alert2.sendKeys("Automation Testing user");
		alert2.accept();
		String message2 = driver.findElement(By.xpath("//p[contains(text(),'Hello Automation')]")).getText();
		System.out.println(message2);
		driver.findElement(By.cssSelector(".btn-info")).click();
		alert.dismiss();
		
		driver.quit();

		

	}

}
