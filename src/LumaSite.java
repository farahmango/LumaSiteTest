import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import dev.failsafe.internal.util.Assert;

public class LumaSite {

//	private static final String invocation = null;
	WebDriver driver = new EdgeDriver();
	SoftAssert myAseert = new SoftAssert();
	Random myRandom = new Random();

	@BeforeTest
	public void Web() {

		driver.get("https://magento.softwaretestingboard.com/");

	}

	@Test(priority = 1)
	public void SignUp() throws InterruptedException {

		driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();

		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("farah");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("go");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("farahgo22@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("farahgo@123");
		driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys("farahgo@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]")).click();

		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://magento.softwaretestingboard.com/customer/account/";

		myAseert.assertEquals(actualURL, expectedURL);
		myAseert.assertAll();

		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")).click();
		Thread.sleep(7000);

	}

	@Test(priority = 2)
	public void SignIn() throws InterruptedException {
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("farahgo22@gmail.com");
		driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[3]/div[1]/input[1]")).sendKeys("farahgo@123");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[4]/div[1]/button[1]")).click();

		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://magento.softwaretestingboard.com/";

		myAseert.assertEquals(actualURL, expectedURL);
		myAseert.assertAll();
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void searchBar() throws InterruptedException {
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		String[] option = { "Jacket", "t-shirt", "jeans for men", "jeans for women", "pants" };

		Random myRandom = new Random();
		int random = myRandom.nextInt(0, 5);
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(option[random] + Keys.ENTER);
		System.out.println(option[random]);
		driver.navigate().back();

	}

	@Test(invocationCount = 3, priority = 4)
	public void addRadiantTee() throws InterruptedException {
		driver.manage().window().maximize();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1800)");

		Thread.sleep(3000);
		WebElement product_size = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[1]"));
		Thread.sleep(3000);
		List<WebElement> size = product_size.findElements(By.className("text"));
		Thread.sleep(3000);

		WebElement product_color = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/ol[1]/li[1]/div[1]/div[1]/div[3]/div[2]/div[1]"));
		Thread.sleep(3000);
		List<WebElement> color = product_color.findElements(By.className("color"));

		int randInt = myRandom.nextInt(size.size());
		int rand = myRandom.nextInt(color.size());
		Thread.sleep(3000);

		WebElement addCart = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/ol[1]/li[1]/div[1]/div[1]/div[4]/div[1]/div[1]/form[1]/button[1]"));
		size.get(randInt).click();
		color.get(rand).click();

		addCart.click();

	}

	@Test(invocationCount = 2, priority = 5)
	public void addBreatheEasyTank() throws InterruptedException {

		Thread.sleep(3000);
		WebElement product_size = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[2]/div/div/div[3]/div[1]/div"));
		Thread.sleep(3000);
		List<WebElement> size = product_size.findElements(By.className("text"));
		Thread.sleep(3000);

		WebElement product_color = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[2]/div/div/div[3]/div[2]/div"));
		Thread.sleep(3000);
		List<WebElement> color = product_color.findElements(By.className("color"));

		int randInt = myRandom.nextInt(size.size());
		int rand = myRandom.nextInt(color.size());
		Thread.sleep(3000);

		WebElement addCart = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/ol[1]/li[2]/div[1]/div[1]/div[4]/div[1]/div[1]/form[1]/button[1]"));
		size.get(randInt).click();
		color.get(rand).click();
		addCart.click();

	}

	@Test(invocationCount = 4, priority = 6)
	public void addArgusAllWeatherTank() throws InterruptedException {
		Thread.sleep(3000);
		WebElement product_size = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/ol[1]/li[3]/div[1]/div[1]/div[2]/div[1]/div[1]"));
		Thread.sleep(3000);
		List<WebElement> size = product_size.findElements(By.className("text"));
		Thread.sleep(3000);

		WebElement product_color = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/ol[1]/li[3]/div[1]/div[1]/div[2]/div[2]/div[1]"));
		Thread.sleep(3000);
		WebElement color = product_color.findElement(By.className("color"));

		int randInt = myRandom.nextInt(size.size());

		Thread.sleep(3000);

		WebElement addCart = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/ol[1]/li[3]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]"));
		size.get(randInt).click();
		color.click();
		addCart.click();
		Thread.sleep(3000);

	}

	@Test(invocationCount = 1, priority = 7)
	public void addHeroHoodie() throws InterruptedException {
		Thread.sleep(3000);
		WebElement product_size = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div/div/div[2]/div[1]/div"));
		Thread.sleep(3000);
		List<WebElement> size = product_size.findElements(By.className("text"));
		Thread.sleep(3000);

		WebElement product_color = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div/div/div[2]/div[2]/div"));
		Thread.sleep(3000);
		List<WebElement> color = product_color.findElements(By.className("color"));

		int randInt = myRandom.nextInt(size.size());
		int rand = myRandom.nextInt(color.size());

		WebElement addCart = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/ol[1]/li[4]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]"));
		size.get(randInt).click();
		color.get(rand).click();
		addCart.click();
		Thread.sleep(3000);

	}

	@Test(invocationCount = 5, priority = 8)
	public void pushItMessengerBack() throws InterruptedException {
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement elem = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/ol[1]/li[6]"));
		action.moveToElement(elem);
		action.perform();

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/div[1]/div[1]/ol[1]/li[6]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/button[1]")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 9)
	public void checkOutForm() throws InterruptedException {
		driver.navigate().to("https://magento.softwaretestingboard.com/checkout/#shipping");

		Thread.sleep(5000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/fieldset[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Street 36");
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/fieldset[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys("Building 41");
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/fieldset[1]/div[1]/div[3]/div[1]/input[1]")).sendKeys("door 6");
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[4]/div[1]/input[1]")).sendKeys("Amman");
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[7]/div[1]/input[1]")).sendKeys("95666");
		Thread.sleep(3000);

		Select dropDown = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[8]/div[1]/select[1]")));
		dropDown.selectByValue("JO");
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[9]/div[1]/input[1]")).sendKeys("0777956842");
		Thread.sleep(3000);

		WebElement nextButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[2]/div[1]/div[3]/form[1]/div[3]/div[1]/button[1]"));
		nextButton.click();

		Thread.sleep(10000);
	}

	@Test(priority = 10)

	public void checkThePrice() throws InterruptedException {

		WebElement placeHolderButton = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[2]/div[4]/ol[1]/li[3]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/button[1]"));
		placeHolderButton.click();
		Thread.sleep(5000);

		WebElement receiptNumber = driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/div/div[2]/p[1]/a"));
		receiptNumber.click();
		Thread.sleep(3000);

		List<WebElement> price = driver.findElements(By.cssSelector("body.account.sales-order-view.page-layout-2columns-left:nth-child(2) div.page-wrapper:nth-child(4) main.page-main div.columns:nth-child(3) div.column.main:nth-child(1) div.order-details-items.ordered:nth-child(3) div.table-wrapper.order-items table.data.table.table-order-items tr:nth-child(1) td.col.subtotal:nth-child(5) span.price-excluding-tax span.cart-price > span.price"));

		double sum = 0;
		for (int i = 0; i < price.size(); i++) {
			String ItemPrice = price.get(i).getText();
			String subPrice = ItemPrice.substring(1, ItemPrice.length());
			double convertPrice = Double.parseDouble(subPrice);
			sum = sum + convertPrice;
		}
		System.out.println(sum);

		double expectedTotalPrice = sum;
		Thread.sleep(3000);

		WebElement actualPrice = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div[1]/div[2]/div[2]/table/tfoot/tr[1]/td/span"));
		String actualPriceValue = actualPrice.getText();

		String convertPrice = actualPriceValue.substring(1, actualPriceValue.length());
		double actualTotalPrice = Double.parseDouble(convertPrice);
		System.out.println(actualTotalPrice);
		System.out.println(actualTotalPrice);

		myAseert.assertEquals(actualTotalPrice, expectedTotalPrice);
		myAseert.assertAll();

	}


	@AfterTest
	public void endTest() {
		driver.quit();
	}

}
