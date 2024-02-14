package demo;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

//	WebDriver driver = new ChromeDriver();
	
	public void locator() throws InterruptedException {		
        System.setProperty("webdriver.chrome.driver", "/home/nagesh/eclipse-workspace/Practice/driver/chromedriver-linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.get("https://devlogin.inuxu.net/AdgebraUI/loginAsPartnerORAccount.do");
		WebElement username= driver.findElement(By.id("login-username"));
		username.sendKeys("nagesh@inuxu.media");
		
		WebElement password = driver.findElement(By.id("login-password"));
		password.sendKeys("Mjollnir@12");
		
		WebElement loginbtn = driver.findElement(By.id("btn-signIn"));
		loginbtn.click();

		String tittle = driver.getTitle();
		System.out.println(tittle);
		
		driver.findElement(By.id("LoginAsform")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Thread.sleep(1000);
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		String dTittle = driver.getTitle();
		System.out.println(dTittle);		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String cururl = driver.getCurrentUrl();
		System.out.println(cururl);
		String acturl = "https://devlogin.inuxu.net/AdgebraUI/loginAsPartnerORAccount.do";
		
		if (cururl.equals(acturl)==true) {
			System.out.println("url match cool");
		
		}
		
		else {
			System.out.println("sorry url diffenent");
		}
		
        WebElement footer = driver.findElement(By.tagName("footer"));
        int deltaY = footer.getRect().y;
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();
        

        
        driver.quit();
		
	}

	public void seleniumIframe() {		
		System.setProperty("webdriver.chrome.driver", "/home/nagesh/eclipse-workspace/Practice/driver/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        new Actions(driver)
                .scrollToElement(iframe)
                .perform();

        
        
        driver.quit();

		
	}
	
	public void shouldScrollFromElementByGivenAmount() throws InterruptedException {
		System.setProperty("webdriver.chrome.drive","/home/nagesh/eclipse-workspace/Practice/driver/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
		
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		WheelInput.ScrollOrigin screollOrigin = WheelInput.ScrollOrigin.fromElement(iframe);
		new Actions(driver)
		.scrollFromOrigin(screollOrigin, 0, 200)
		.perform();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.switchTo().frame(iframe);
		
		driver.findElement(By.name("scroll_checkbox")).click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}
	
	public void shouldScrollFromElementByGivenAmountWithOffset() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/nagesh/eclipse-workspace/Practice/driver/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
		
		WebElement footer = driver.findElement(By.tagName("footer"));
		Thread.sleep(2000);
		WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(footer, 0, -50);
		Thread.sleep(2000);
		new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 100).perform();
		Thread.sleep(2000);
		
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		
		driver.findElement(By.name("scroll_checkbox")).click();
		Thread.sleep(2000);
		
		driver.quit();

	}
	
	public void shouldScrollFromViewportByGivenAmountFromOrigin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/nagesh/eclipse-workspace/Practice/driver/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/web/scrolling_tests/frame_with_nested_scrolling_frame_out_of_view.html");
		Thread.sleep(2000);
		WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
		Thread.sleep(2000);
		new Actions(driver).scrollFromOrigin(scrollOrigin, 0, 200).perform();
		Thread.sleep(2000);
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		WebElement checkbox = driver.findElement(By.name("scroll_checkbox"));
		checkbox.click();
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	public void handleAlerts() throws InterruptedException {
		System.setProperty("webdriver.chrom.driver", "/home/nagesh/eclipse-workspace/Practice/driver/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://nxtgenaiacademy.com/alertandpopup/");
		Thread.sleep(2000);
		
		//Click the link to activate the alert
		driver.findElement(By.name("alertbox")).click();
		Thread.sleep(2000);
		//Wait for the alert to be displayed and store it in a variable
		//Alert alert = Wait.until(ExpectedConditions.alertIsPresent());
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
//		Alert alertW = wait.until(ExpectedConditions.alertIsPresent());
		
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		driver.findElement(By.name("confirmalertbox")).click();
		Thread.sleep(2000);
		String confirmalertbox = driver.switchTo().alert().getText();
		System.out.println(confirmalertbox);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		
		driver.findElement(By.name("promptalertbox1234")).click();
		Alert prompt = driver.switchTo().alert();
		System.out.println(prompt.getText());
		prompt.sendKeys("Yes");
		Thread.sleep(2000);
		prompt.accept();
//		String promptalertbox1234 = driver.switchTo().alert().getText();
//		driver.switchTo().alert().sendKeys("Yes");
		
		Thread.sleep(2000);				
		driver.quit();
		
		
	}
	
	
	public void multipleBrowserScanner() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter browser name");
		String browser = sc.nextLine();
		
		WebDriver driver = null;
		
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","/home/nagesh/eclipse-workspace/Practice/driver/geckodriver");
		    FirefoxOptions options = new FirefoxOptions();
		    driver = new FirefoxDriver(options);
		}
		
		else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/nagesh/eclipse-workspace/Practice/driver/chromedriver-linux64/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://devlogin.inuxu.net/AdgebraUI/logout.do");
			WebElement username= driver.findElement(By.id("login-username"));
			username.sendKeys("nagesh@inuxu.media");
			
			WebElement password = driver.findElement(By.id("login-password"));
			password.sendKeys("Mjollnir@12");
			
			WebElement loginbtn = driver.findElement(By.id("btn-signIn"));
			loginbtn.click();
			driver.findElement(By.id("LoginAsform")).click();
			Thread.sleep(2000);
			
		}
		else
		{
			System.out.println("Invalid browser");
		}
		
		Thread.sleep(1000);
		driver.close();
	}
	
	public void windowsOperation() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/nagesh/eclipse-workspace/Practice/driver/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://docs.aerospike.com/");
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Dimension d = new Dimension(1500,1500);
		driver.manage().window().setSize(d);
		Thread.sleep(2000);
		
		Point p = new Point(0,0);
		driver.manage().window().setPosition(p);
		Thread.sleep(2000);
		driver.quit();		
	}
	
	

}
