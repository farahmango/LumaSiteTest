import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class reorderItems {

	WebDriver driver = new EdgeDriver();
	SoftAssert myAseert = new SoftAssert();
	Random myRandom = new Random();

	@BeforeTest
	public void web() {

		driver.get("https://magento.softwaretestingboard.com/");

	}

	@Test()
	public void reorder() throws InterruptedException {
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("farahgo22@gmail.com");
		driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/input[1]")).sendKeys("farahgo@123");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[4]/div[1]/button[1]")).click();
		Thread.sleep(3000);

		driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/");
		Thread.sleep(3000);

		WebElement orderButton = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[2]/div/div[2]/ul/li[2]/a"));
		orderButton.click();
		Thread.sleep(3000);
			for(int i =0 ;i < 5 ; i++) {
				Thread.sleep(3000);
		WebElement reOrderButton  = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[6]/a[2]"));
		reOrderButton.click();
		Thread.sleep(3000);
		WebElement proceedCheck = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]"));
		proceedCheck.click();
		Thread.sleep(3000);
		WebElement nextButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[2]/div[1]/div[3]/form[1]/div[3]/div[1]/button[1]"));
		nextButton.click();
		Thread.sleep(3000);
		
		WebElement placeOrder = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[3]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/button[1]"));
		placeOrder.click();
		Thread.sleep(3000);

		driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/");
		Thread.sleep(3000);

		WebElement myorderButton = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[2]/div/div[2]/ul/li[2]/a"));
		myorderButton.click();
		
			}
			double convertPrice = 0.0 ;
			List <WebElement> price = driver.findElements(By.className("price"));
			for (int i =0 ; i< price.size(); i++) {
				
				String Price = price.get(i).getText();
				String subPrice = Price.substring(1, Price.length());
				 convertPrice = Double.parseDouble(subPrice);
				
			}
			System.out.println(convertPrice);
			double actualPrice = convertPrice;
			
			WebElement  expectedPrice = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[4]/span[1]"));
			
			String expectedPriceText = expectedPrice.getText();
			String subPrice = expectedPriceText.substring(1, expectedPriceText.length());
			double expectPrice = Double.parseDouble(subPrice);
			System.out.println(expectPrice);
			
			myAseert.assertEquals(expectPrice, actualPrice);
			myAseert.assertAll();
		Thread.sleep(3000);		
	}

	@AfterTest
	public void endTest() {
		driver.quit();
	}
	
}
