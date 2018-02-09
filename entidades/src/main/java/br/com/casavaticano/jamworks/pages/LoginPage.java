package br.com.casavaticano.jamworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.casavaticano.jamworks.pages.BasePage;
import br.com.casavaticano.jamworks.pages.LoginPage;
import br.com.casavaticano.jamworks.pages.TracksPage;

public class LoginPage extends BasePage{

	
	public LoginPage(WebDriver navegador) {
		super(navegador);
		
	}

	public LoginPage digitarLogin(String login){
		navegador.findElement(By.id("username")).sendKeys(login);
		return this;
	}
	
	public LoginPage digitarSenha(String password) {
		navegador.findElement(By.id("password")).sendKeys(password);
		return this;
	}
	
	public TracksPage clicarEntrar() {
		navegador.findElement(By.id("_submit")).submit();
		return new TracksPage(navegador);
		
	}
	
	public TracksPage fazerLogin(String login, String password) {
		
		digitarLogin(login);
		digitarSenha(password);
		clicarEntrar();

		return new TracksPage(navegador);
		
		
	}

}