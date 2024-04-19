package testio.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReloadPage {
	public static void main(String[] args) {

		WebElement userNameElement;
		WebElement passWordElement;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://tester.test.io/";
		String xpathLinkedin = "/html/body/main/div[2]/div[2]/div/div[3]/div[2]/div/a";
		String UserName = "thanhhoa280499@gmail.com";
		String PassWord = "hoa2021998";
		String xpathLoginButton = "/html/body/div/main/div[2]/form/div[3]/button";
		String xpathUser = "//input[@id='username']";
		String xpathPass = "//input[@id='password']";
		String xpathCycle = "//a[contains(text(),'Learn more')]";
		String xpathCheckbox = "//form/div/div/div/div/div/div/label";
		String xpathAccept = "//button[@name='button']";

		driver.get(url);
		WebElement buttonLikedin = driver.findElement(By.xpath(xpathLinkedin));
		buttonLikedin.click();
		userNameElement = driver.findElement(By.xpath(xpathUser));
		passWordElement = driver.findElement(By.xpath(xpathPass));
		userNameElement.sendKeys(UserName);
		passWordElement.sendKeys(PassWord);
		WebElement buttonLogin = driver.findElement(By.xpath(xpathLoginButton));
		buttonLogin.click();

		while (true) {
			System.out.println("Refresh thanh cong");
			driver.get(url);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {

			}
			try {
				WebElement buttonLearnMore = driver.findElement(By.xpath(xpathCycle));

				if (buttonLearnMore != null) {
					buttonLearnMore.click();
					WebElement Checkbox = driver.findElement(By.xpath(xpathCheckbox));
					WebElement Accept = driver.findElement(By.xpath(xpathAccept));
					Checkbox.click();
					Accept.click();
				}
			} catch (Exception e) {

				continue;
			}

		}

	}
}
