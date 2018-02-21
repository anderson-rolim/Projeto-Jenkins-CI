package br.com.casavaticano.jamworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TracksPage extends BasePage {

	public TracksPage(WebDriver navegador) {
		super(navegador);

	}

	public TracksPage clicarNoBotaoNovoProcesso() {
		WebElement Novo = navegador
				.findElement(By.xpath("//div[@class=\"buttons btn-group\"]/a[@id=\"new-process-instance\"]"));
		Novo.click();
		return this;

	}

	public TracksPage fazerBuscaNaPautaDoTracks(String nome_da_busca) {
		WebElement Busca = navegador.findElement(By.id("admin_user_serach_input"));
		Busca.clear();
		Busca.findElement(By.id("admin_user_serach_input"));
		Busca.sendKeys(nome_da_busca);
		Busca.findElement(By.xpath("//div[@class=\"search\"]//button[@id=\"admin_user_serach-btn\"]"));
		Busca.click();

		return this;
	}

	public TracksPage removerProcessoNaPautaDoTracks() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) navegador;

		WebElement remover = navegador.findElement(By.cssSelector("i.icon-remove"));
		executor.executeScript("arguments[0].click();", remover);

		remover = navegador.findElement(By.xpath("//div[@class=\"modal-body\"]//*[@id=\"comentario_texto\"]"));
		remover.sendKeys("Exclusao do formulario duplicado");
		remover = navegador.findElement(By.xpath("//button[@id=\"tracker_ations_cancel_process_save\"]"));
		Thread.sleep(1000);
		remover.click();

		return this;
	}

	public TracksPage renomearAPecaDoProcessoNaPautaDoTracks() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) navegador;

		WebElement renomear = navegador.findElement(By.xpath("//a[@id=\"tracker_list_action_rename_peca_1\"]"));
		executor.executeScript("arguments[0].click();", renomear);

		renomear = navegador.findElement(By.xpath("//input[@id=\"peca_name\"]"));
		renomear.sendKeys("Automacao de Teste (Peca Renomeada)");
		renomear = navegador.findElement(By.xpath("//button[@id=\"tracker_action_rename_submit\"]"));
		Thread.sleep(1000);
		renomear.click();

		return this;
	}

	public TracksPage inserirComentarioNaPecaDoProcessoNaPautaDoTracks() {
		JavascriptExecutor executor = (JavascriptExecutor) navegador;

		WebElement comentario = navegador.findElement(By.xpath("//a[@id=\"tracker_list_action_comment_1\"]"));
		executor.executeScript("arguments[0].click();", comentario);

		comentario = navegador
				.findElement(By.xpath("//div[@class=\"modal-body\"]//textarea[@id=\"comentario_texto\"]"));
		comentario.sendKeys("Isso e apenas um teste de Automacao");
		comentario = navegador.findElement(By.xpath("//button[@id=\"tracker_actions_comment_save\"]"));
		comentario.click();

		return this;
	}

	public TracksPage editandoTituloDoProcessoNaPautaDoTracks() {
		JavascriptExecutor executor = (JavascriptExecutor) navegador;

		WebElement editandoTituloProcesso = navegador.findElement(By.xpath("//a[@id=\"tracker_list_edit_process_1\"]"));
		executor.executeScript("arguments[0].click();", editandoTituloProcesso);

		editandoTituloProcesso = navegador
				.findElement(By.xpath("//div[@class=\"input\"]//input[@id=\"processo_title\"]"));
		editandoTituloProcesso.sendKeys("Editando Titulo do Processo de Teste de Automacao");
		editandoTituloProcesso = navegador.findElement(By.xpath("//button[@id=\"tracker_actions_edit_process\"]"));
		editandoTituloProcesso.click();

		return this;
	}

/*
	public DAMPage acessandoPastaColecaoNoModuloDAM() {

		//Acessando a pasta Colecao da Homologacao
		//Acessando a pasta Colecao da Homologacao
		WebElement PastaHomologacao = navegador.findElement(By.xpath("//div[@class='box-container-folder']//a[@href='http://homologacao.casavaticano.com.br/dam/1449459/1/40']//div[@class='thumb']"));
		PastaHomologacao.click();	
		WebElement PastaHomologacaoAgencia = navegador.findElement(By.xpath("//div[@class='box-container-folder']//a[@href='http://homologacao.casavaticano.com.br/dam/1449461/1/40']"));
		PastaHomologacaoAgencia.click();	
		WebElement PastaHomologacaoAgenciaColecao = navegador.findElement(By.xpath("//div[@class='box-container-folder']//a[@href='http://homologacao.casavaticano.com.br/dam/1449462/1/40']//div[@class='thumb']"));
		PastaHomologacaoAgenciaColecao.click();				
		
		return new DAMPage(navegador);

	}
	
*/	
	public FormularioPage clicarNaAtividadeParaEditarFormulario() {

		WebElement EdicaoForm = navegador.findElement(By.xpath("//*[@id=\"tracker_list_activity_1\"]"));
		EdicaoForm.click();

		return new FormularioPage(navegador);

	}

	public FormPecaPage selecionarEClicarNoNovoProcesso() {
		try {
			Thread.sleep(1000);
			WebElement NovoProcesso = navegador.findElement(By.xpath(
					"//ul[@class=\"new-process-menu\"]//li[@title=\"Fluxo Rolim\"]//a[@id=\"tracks_process_1\"]"));
			NovoProcesso.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return new FormPecaPage(navegador);

	}

	public FormularioPage duplicarProcesso() {
		try {

			Thread.sleep(500);

			JavascriptExecutor executor = (JavascriptExecutor) navegador;
			WebElement AcaoDuplicar = navegador.findElement(By.cssSelector("i.icon-duply"));
			AcaoDuplicar.click();
			AcaoDuplicar = navegador.findElement(By.xpath("//*[@id=\"tracks_duplicate_process_code_piece_save\"]"));
			executor.executeScript("arguments[0].click();", AcaoDuplicar);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return new FormularioPage(navegador);

	}

	public FormPecaPage irParaFormDePeca() {
		clicarNoBotaoNovoProcesso();
		selecionarEClicarNoNovoProcesso();
		return new FormPecaPage(navegador);

	}
}
