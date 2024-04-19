package com.java.project1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.excelant.ExcelAntEvaluateCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args) {
		WebElement userElement;
		WebElement passElement;
		WebElement message;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://practicetestautomation.com/practice-test-login/";
		String xpathUser = "//*[@id=\"username\"]";
		String xpathPass = "//*[@id=\"password\"]";
		String xpathLogin = "//*[@id=\"submit\"]";
		String xpathError = "//*[@id=\"error\"]";
		String pathData = "D:\\Phanmem\\Eclipse\\Workspace\\beginner\\Project1\\Filedata\\dataLogin.xlsx";
		String sheetData = "Sheet1";
		File fileD = new File(pathData);
		FileInputStream fileData;
		try {
			fileData = new FileInputStream(fileD);
			XSSFWorkbook workbook = new XSSFWorkbook(fileData);
			Sheet sheet = workbook.getSheet(sheetData);
			int rowNum = sheet.getLastRowNum();

			for (int i = 1; i <= rowNum; i++) {
				
				Row rowData = sheet.getRow(i);
				Cell cellUser = rowData.getCell(1);
				Cell cellPass = rowData.getCell(2);
				Cell cellSTT = rowData.getCell(0);
				int STT = (int)cellSTT.getNumericCellValue();
				String valueUser = cellUser.getStringCellValue();
				String valuePass = cellPass.getStringCellValue();
				driver.get(url);
				userElement = driver.findElement(By.xpath(xpathUser));
				passElement = driver.findElement(By.xpath(xpathPass));
				message = driver.findElement(By.xpath(xpathError));
				userElement.sendKeys(valueUser);
				Thread.sleep(1000);
				passElement.sendKeys(valuePass);
				Thread.sleep(1000);
				WebElement buttonLogin = driver.findElement(By.xpath(xpathLogin));
				buttonLogin.click();
				Thread.sleep(1000);
				try {
					if (message.getText().contains("invalid")) {
						System.out.println(STT);
						System.out.println(message.getText());
						System.out.println("----------");
						rowData.createCell(4);
						rowData.getCell(4).setCellValue(message.getText());
						rowData.createCell(3);
						rowData.getCell(3).setCellValue("F");
					}

				} catch (Exception e) {
					System.out.println(STT);
					System.out.println("Login Sucess");
					System.out.println("----------");
					rowData.createCell(4);
					rowData.createCell(3);
					rowData.getCell(3).setCellValue("P");
				}
			}
			FileOutputStream file = new FileOutputStream(fileD);
			workbook.write(file);
			file.close();
			driver.close();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
