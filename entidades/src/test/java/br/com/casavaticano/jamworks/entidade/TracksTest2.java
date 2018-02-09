package br.com.casavaticano.jamworks.entidade;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.casavaticano.jamworks.pages.LoginPage;
import br.com.casavaticano.jamworks.suporte.Web;
import junit.framework.Assert;


public class TracksTest2 {

	private WebDriver navegador;

	@Before
	public void setUp() {
		 //navegador = Web.createBrowserStack();
		navegador = Web.createChrome();
		navegador.get("http://homologacao.casavaticano.com.br/dam");
	}
	
	@Test
	public void testFazerLoginNoTestTracks() {
		
		JavascriptExecutor executor = (JavascriptExecutor) navegador;
		//-------------------------------
		
		new LoginPage(navegador).fazerLogin("automacao", "jamworks");
		
		//Acessando a pasta Colecao da Homologacao
		WebElement PastaHomologacao = navegador.findElement(By.xpath("//div[@class='box-container-folder']//a[@href='http://homologacao.casavaticano.com.br/dam/1449459/1/40']//div[@class='thumb']"));
		PastaHomologacao.click();	
		WebElement PastaHomologacaoAgencia = navegador.findElement(By.xpath("//div[@class='box-container-folder']//a[@href='http://homologacao.casavaticano.com.br/dam/1449461/1/40']"));
		PastaHomologacaoAgencia.click();	
		WebElement PastaHomologacaoAgenciaColecao = navegador.findElement(By.xpath("//div[@class='box-container-folder']//a[@href='http://homologacao.casavaticano.com.br/dam/1449462/1/40']//div[@class='thumb']"));
		PastaHomologacaoAgenciaColecao.click();	
		
		//Menu novo

		WebElement ClicarNoMenuDoBotaoNovo = navegador.findElement(By.xpath("//a[@id='dam_index_upload_new']"));
		ClicarNoMenuDoBotaoNovo.click(); 		
		WebElement ClicarNoBotaoNovoDiretorio = navegador.findElement(By.xpath("//div[@class='dropdown-menu']//a[@id='dam_index_upload_dir']"));
		ClicarNoBotaoNovoDiretorio.click();
		WebElement InserirDescricaoDaPasta = navegador.findElement(By.xpath("//div[@class='input']//input[@id='diretorio_nome']"));
		InserirDescricaoDaPasta.sendKeys("1221 - Automacao");
		WebElement ClicarSubmitCriar = navegador.findElement(By.xpath("//form[@action='http://homologacao.casavaticano.com.br/dam/actions/new_directory/1449462']//div[@class='modal-footer']//button[@id='dam_action_new_dir_submit']"));
		ClicarSubmitCriar.click();
	
		//msg
		Assert.assertEquals(navegador.findElement(By.cssSelector("div.alert.alert-success")).getText(),
				"×" + "\n" + "Pasta criada com sucesso.");
			
		//Busca
		WebElement InserirDescricaoDaBusca = navegador.findElement(By.xpath("//input[@id='dam_navegation_index_search_input']"));
		InserirDescricaoDaBusca.sendKeys("1221");
		WebElement ClicarSubmitBuscar = navegador.findElement(By.xpath("//i[@id='dam_navegation_index_search']"));
		ClicarSubmitBuscar.click();

		//Renomear Pasta
		
		WebElement acaoRenomear = navegador.findElement(By.xpath("//a[@id='dam_acao_renomear_diretorio_1']"));
		executor.executeScript("arguments[0].click();", acaoRenomear);
		WebElement InserindoRenomeandoPasta = navegador.findElement(By.xpath("//div[@class='input']//input[@id='arquivo_nome']"));
		InserindoRenomeandoPasta.sendKeys("1221 - Renomeada"); 
		WebElement ClicarSubmitRenomearPasta = navegador.findElement(By.xpath("//div[@class='modal-footer']//button[@id='dam_action_rename_submit']"));
		ClicarSubmitRenomearPasta.click();
		
		Assert.assertEquals(navegador.findElement(By.cssSelector("div.alert.alert-success")).getText(),
				"×" + "\n" + "Pasta renomeada com sucesso.");
		
		//Busca
		WebElement InserirDescricaoDaBuscaDepoisDeRenomeado = navegador.findElement(By.xpath("//input[@id='dam_navegation_index_search_input']"));
		InserirDescricaoDaBuscaDepoisDeRenomeado.clear();
		InserirDescricaoDaBuscaDepoisDeRenomeado.sendKeys("1221");
		WebElement ClicarSubmitBuscarPastaRenomeada = navegador.findElement(By.xpath("//i[@id='dam_navegation_index_search']"));
		ClicarSubmitBuscarPastaRenomeada.click();
		
		//acao excluir
		WebElement acaoExcluir = navegador.findElement(By.xpath("//a[@id='dam_acao_remover_diretorio_1']"));
		executor.executeScript("arguments[0].click();", acaoExcluir);
		
		WebElement ClicarSubmitExcluir = navegador.findElement(By.xpath("//button[@id='dam_action_remove_submit']"));
		executor.executeScript("arguments[0].click();", ClicarSubmitExcluir);
		
		System.out.println("Pasta Excluida com Sucesso!");

				
	}


	@After
	public void tearDown() {
		navegador.quit();
	}

}
