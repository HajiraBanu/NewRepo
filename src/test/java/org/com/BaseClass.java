package org.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	static Select s;

	public static void launch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);

	}

	public void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public void getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

	}

	public static WebElement locators(String locatorName, String value) {
		if (locatorName.equals("id")) {
			WebElement element = driver.findElement(By.id(value));
			return element;

		} else if (locatorName.equals("name")) {
			WebElement element = driver.findElement(By.name(value));
			return element;
		} else {
			WebElement element = driver.findElement(By.xpath(value));
			return element;
		}

	}

	public static void insertvalues(WebElement element, String value) {
		element.sendKeys(value);

	}
	
	public static void btnClick(WebElement element) {
		element.click();

	}

	public static void getAttribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		System.out.println(attribute);

	}

	public static void navigateTo(String value) {
		driver.navigate().to(value);
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static void actions(WebElement element, WebElement src, WebElement dest) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

		act.dragAndDrop(src, dest).perform();

		act.contextClick(element).perform();

		act.doubleClick(element).perform();

	}

	public static void robot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void alert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();

	}

	public static void insertValuesJavaScript(String value1, String value2) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript(value1, value2);

	}

	public static void Screenshot(String path) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);

	}

	public static void selectByValue(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);

	}

	public static void selectByIndex(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);

	}

	public static void selectByVisibleText(WebElement element, String value) {
		s = new Select(element);
		s.selectByVisibleText(value);

	}

	public static void windowHandling(String value) {
		driver.switchTo().window(value);

	}

	public static void wait(int millis) throws InterruptedException {
		Thread.sleep(millis);

	}

	public static String excelRead(String path, String sheet, int row, int cell) throws IOException {
		File f = new File(path);
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		int cellType = c.getCellType();
		if (cellType == 1) {
			String string = c.getStringCellValue();
			return string;
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat s1 = new SimpleDateFormat("dd/MM/YYYY");
			String format = s1.format(dateCellValue);
			//System.out.println(format);
			return format;
		} else {
			double numericCellValue = c.getNumericCellValue();
			long l = (long) numericCellValue;
			String valueOf = String.valueOf(l);
			return valueOf;
		}

	}
	
	public static void excelWrite(String path, String sheetName, int rowNo, int cellNo, String cellValue) throws IOException {
		File file = new File(path);
		FileOutputStream outputStream = new FileOutputStream(file);
		Workbook w = new XSSFWorkbook();
		Sheet sheet = w.createSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(cellValue);
		w.write(outputStream);
		outputStream.close();
		System.out.println("done");
		

	}
	
	public static String ordernum(String loc) {
		WebElement order = driver.findElement(By.id(loc));
		String ordernum = order.getAttribute("value");
		System.out.println(ordernum);
		return ordernum;
	}

}
