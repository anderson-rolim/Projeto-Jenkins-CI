package br.com.casavaticano.jamworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class FormPecaPage extends BasePage{

	public FormPecaPage(WebDriver navegador) {
		super(navegador);
	}
	
	public FormPecaPage digitarTituloDaPeca(String NomeDaPeca) {
		navegador.findElement(By.xpath("//*[@id=\"form_2_field_1\"]")).sendKeys(NomeDaPeca);
		return this;
		
	}

	public FormPecaPage selecionarAgenciaDaPeca() {
		
		WebElement campoAgencia = navegador.findElement(By.name("form_2[field_3]"));
		new Select(campoAgencia).selectByValue("196");		
		return this;
	
	}

	
	public FormPecaPage selecionarAnuncianteDaPeca() {
		
		WebElement campoAnunciante = navegador.findElement(By.name("form_2[field_4]"));
		new Select(campoAnunciante).selectByValue("8883");
		return this;
		
	}
	
	
	public FormPecaPage selecionarProdutoDaPeca() {		
		
		WebElement campoProduto = navegador.findElement(By.name("form_2[field_5]"));
		new Select(campoProduto).selectByValue("24890");
		return this;
		
	}

	public FormularioPage clicarNoBotaoCriarPeca() {
		
		navegador.findElement(By.id("tracker_form_peca_save")).click();
		return new FormularioPage(navegador);
		
	}
	
	public FormularioPage addInformacaoNoFormularioDePeca(String NomeDaPeca) {
		
		digitarTituloDaPeca(NomeDaPeca);
		selecionarAgenciaDaPeca();
		selecionarAnuncianteDaPeca();
		selecionarProdutoDaPeca();
		clicarNoBotaoCriarPeca();
		return new FormularioPage(navegador);
		
	}
	
	

}
