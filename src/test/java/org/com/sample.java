package org.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sample extends BaseClass {

	public static void main(String[] args) {
		
		launch("https://www.facebook.com/");
		Pom p = new Pom();
		WebElement username = p.getUsername();
		insertvalues(username, "Haji");
		p.navigateRefresh();
		insertvalues(username, "Haji");
		WebElement password = p.getPassword();
		insertvalues(password, "love");
		WebElement login = p.getLogin();
		login.click();
		
	}
}
