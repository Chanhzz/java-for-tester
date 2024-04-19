package com.java.project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MultiplicationTableRun {

	public static void main(String[] args) throws InterruptedException {

		WebElement userElement;
		WebElement passElement;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	      // Navigate to Url
		driver.get("https://www.facebook.com/");
	    userElement = driver.findElement(By.xpath("//input[@id='email']"));  
	    passElement = driver.findElement(By.xpath("//input[@id='pass']"));
	    
	    User[] listUser = new User[4];
		User user1 = new User("111", "abc123");
		User user2222 = new User("112", "abc123");
		User user3 = new User("113", "abc123");
		User user4 = new User("114", "abc123");
		listUser[0] = user1;
		listUser[1] = user2222;
		listUser[2] = user3;
		listUser[3] = user4;
		

	    for (int i = 0; i < listUser.length; i++) {
	    	driver.get("https://www.facebook.com/");
	    	userElement = driver.findElement(By.xpath("//input[@id='email']"));  
		    passElement = driver.findElement(By.xpath("//input[@id='pass']"));
	    	userElement.sendKeys(listUser[i].username);
			passElement.sendKeys(listUser[i].password);
	     	  
		WebElement button = driver.findElement(By.xpath("//button[contains(.,'Log in')]"));  
	    button.click();
	    Thread.sleep(1000);
	    WebElement message = driver.findElement(By.xpath("//div[@id='email_container']"));  												  
	    System.out.println(listUser[i].username);
	    System.out.println(message.getText());
	    System.out.println("----------");
		

	}

}}
