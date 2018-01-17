package br.com.casavaticano.jamworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TracksPage extends BasePage {

	public TracksPage(WebDriver navegador) {
		super(navegador);
	
	}
	
	public TracksPage clicarNoBotaoNovoProcesso() {
		WebElement Novo = navegador.findElement(By.xpath("//div[@class=\"buttons btn-group\"]/a[@id=\"new-process-instance\"]"));
				   Novo.click();
		return this;
		
	}
	
	public FormPecaPage selecionarEClicarNoNovoProcesso() {
		try {
			Thread.sleep(1000);
			WebElement NovoProcesso = navegador.findElement(By.xpath("//ul[@class=\"new-process-menu\"]//li[@title=\"Fluxo Rolim\"]//a[@id=\"tracks_process_1\"]"));
			NovoProcesso.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new FormPecaPage(navegador);
		
	}
	
	public FormPecaPage irParaFormDePeca() {
		clicarNoBotaoNovoProcesso();
		selecionarEClicarNoNovoProcesso();
		return new FormPecaPage(navegador);
		
	}
}
