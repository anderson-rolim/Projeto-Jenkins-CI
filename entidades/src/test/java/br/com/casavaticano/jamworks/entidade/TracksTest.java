package br.com.casavaticano.jamworks.entidade;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.casavaticano.jamworks.pages.LoginPage;
import br.com.casavaticano.jamworks.suporte.Web;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(DataDrivenTestRunner.class)
// @DataLoader(filePaths = "testAdicionarUmProcessoNaPautaDoTracks.csv")
// @DataLoader(filePaths = "TracksTest.csv")

public class TracksTest {

	private WebDriver navegador;

	@Before
	public void setUp() {
		 //navegador = Web.createBrowserStack();
		navegador = Web.createChrome();
	}

	@Test
	public void testFazerLoginNoTracks() {

		new LoginPage(navegador).fazerLogin("automacao", "jamworks");
		System.out.println("Estou logado");
	}

	@Test
	@SuppressWarnings("deprecation")
	public void testAddUmProcessoNaPautaDoTracks() {

		new LoginPage(navegador).fazerLogin("automacao", "jamworks").irParaFormDePeca()
				.addInformacaoNoFormularioDePeca("Automacao de Teste").submeterFormulario();

		Assert.assertEquals(navegador.findElement(By.cssSelector("div.alert.alert-success")).getText(),
				"×" + "\n" + "Processo iniciado com sucesso.");

	}

	@Test
	public void testBuscaNaPautaDoTracks() {

		new LoginPage(navegador).fazerLogin("automacao", "jamworks").fazerBuscaNaPautaDoTracks("Automacao de Teste");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testAddInformacaoAoProcessoPreenchidoNaPautaDoTracks() {

		new LoginPage(navegador).fazerLogin("automacao", "jamworks").fazerBuscaNaPautaDoTracks("Automacao de Teste")
				.clicarNaAtividadeParaEditarFormulario().digiteTitulo("Titulo de Automacao de Teste")
				.digiteEmail("anderson.rolim@casavaticano.com.br").selecioneUmRelacionamento()
				.digiteUmTextoParaAutomacao(
						"Comportamento de Automacao de Teste. Um texto para demonstrar que esta funcionando")
				.submeterFormulario();

		Assert.assertEquals(navegador.findElement(By.cssSelector("div.alert.alert-success")).getText(),
				"×" + "\n" + "Atividade salva com sucesso.");

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testAddInformacaoNoWidgetDePedidaDeVideoNoFormulario() {

		new LoginPage(navegador).fazerLogin("automacao", "jamworks").fazerBuscaNaPautaDoTracks("Automacao de Teste")
				.clicarNaAtividadeParaEditarFormulario().widgetPedidoMaterial("Globo").submeterFormulario();

		Assert.assertEquals(navegador.findElement(By.cssSelector("div.alert.alert-success")).getText(),
				"×" + "\n" + "Atividade salva com sucesso.");

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testAddInformacaoNoWidgetDePedidoDeMaterialNoFormulario() {

		new LoginPage(navegador).fazerLogin("automacao", "jamworks").fazerBuscaNaPautaDoTracks("Automacao de Teste")
				.clicarNaAtividadeParaEditarFormulario().widgetDeTabela("121244", "CoCa-Cola", "30 cm")
				.submeterFormulario();

		Assert.assertEquals(navegador.findElement(By.cssSelector("div.alert.alert-success")).getText(),
				"×" + "\n" + "Atividade salva com sucesso.");

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testAddInformacaoNoWidgetDeMaterialNoFormulario() {

		new LoginPage(navegador).fazerLogin("automacao", "jamworks").fazerBuscaNaPautaDoTracks("Automacao de Teste")
				.clicarNaAtividadeParaEditarFormulario().widgetMaterial("100", "Revista").submeterFormulario();

		Assert.assertEquals(navegador.findElement(By.cssSelector("div.alert.alert-success")).getText(),
				"×" + "\n" + "Atividade salva com sucesso.");

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testDuplicarProcessoNaPautaDoTracks() {

		new LoginPage(navegador).fazerLogin("automacao", "jamworks").fazerBuscaNaPautaDoTracks("Automacao de Teste")
				.duplicarProcesso().digiteTitulo("Titulo de Automacao de Teste")
				.digiteEmail("anderson.rolim@casavaticano.com.br").selecioneUmRelacionamento()
				.digiteUmTextoParaAutomacao("Processo Duplicado.").submeterFormulario();

		Assert.assertEquals(navegador.findElement(By.cssSelector("div.alert.alert-success")).getText(),
				"×" + "\n" + "Processo iniciado com sucesso.");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testRemoverUmProcessoDaPautaDoTracks() throws InterruptedException {

		new LoginPage(navegador).fazerLogin("automacao", "jamworks").fazerBuscaNaPautaDoTracks("Automacao de Teste")
				.removerProcessoNaPautaDoTracks();

		Assert.assertEquals(navegador.findElement(By.cssSelector("div.alert.alert-success")).getText(),
				"×" + "\n" + "Processo cancelado com sucesso.");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testRenomearUmaPecaDoProcessoDaPautaDoTracks() throws InterruptedException {

		new LoginPage(navegador).fazerLogin("automacao", "jamworks").fazerBuscaNaPautaDoTracks("Automacao de Teste")
				.renomearAPecaDoProcessoNaPautaDoTracks();

		Assert.assertEquals(navegador.findElement(By.cssSelector("div.alert.alert-success")).getText(),
				"×" + "\n" + "Peça renomeada para 'Automacao de Teste (Peca Renomeada)'");
	}

	@Test
	public void testComentarUmaPecaDoProcessoDaPautaDoTracks() {

		new LoginPage(navegador).fazerLogin("automacao", "jamworks").fazerBuscaNaPautaDoTracks("Automacao de Teste")
				.inserirComentarioNaPecaDoProcessoNaPautaDoTracks();
	}

	@Test
	public void testEditandoTituloDaPecaDaPautaDoTracks() {

		new LoginPage(navegador).fazerLogin("automacao", "jamworks").fazerBuscaNaPautaDoTracks("Automacao de Teste")
				.editandoTituloDoProcessoNaPautaDoTracks();

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testRemoverUmProcessoDaPautaDoTracksDuplicado() throws InterruptedException {

		new LoginPage(navegador).fazerLogin("automacao", "jamworks").fazerBuscaNaPautaDoTracks("Automacao de Teste")
				.removerProcessoNaPautaDoTracks();

		Assert.assertEquals(navegador.findElement(By.cssSelector("div.alert.alert-success")).getText(),
				"×" + "\n" + "Processo cancelado com sucesso.");
	}

	

	@Test
	public void testAddNoWidgetDeTabelaNoProcessoDaPautaDoTracks() {
		new LoginPage(navegador).fazerLogin("automacao", "jamworks").irParaFormDePeca()
				.addInformacaoNoFormularioDePeca("WidgetDeTabela - Formulario de Teste para Automacao de Teste")
				.digiteTitulo("Automacao de Teste").digiteEmail("anderson.rolim@casavaticano.com.br")
				.widgetDeTabela("1234", "Laranja UVA", "4 Miligrama").selecioneUmRelacionamento().submeterFormulario();

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testRemoverUmProcessoDaPautaDoTracksQueFoiRenomeado() throws InterruptedException {

		new LoginPage(navegador).fazerLogin("automacao", "jamworks").fazerBuscaNaPautaDoTracks("Automacao de Teste")
				.removerProcessoNaPautaDoTracks();

		Assert.assertEquals(navegador.findElement(By.cssSelector("div.alert.alert-success")).getText(),
				"×" + "\n" + "Processo cancelado com sucesso.");
	}

	

	//@Test
	public void testAddNoPedidoDeMaterialNoProcessoDaPautaDoTracks() {
		new LoginPage(navegador).fazerLogin("automacao", "jamworks").irParaFormDePeca()
				.addInformacaoNoFormularioDePeca("PedidoDeMaterial - Formulario de Teste para Automacao de Teste")
				.digiteTitulo("Automacao de Teste").digiteEmail("anderson.rolim@casavaticano.com.br")
				.digiteUmTextoParaAutomacao("Texto Qualquer para Automacao de Teste").widgetPedidoMaterial("Globo RS")
				.selecioneUmRelacionamento().submeterFormulario();
	}

	// @Test
		public void testAddUmProcessoPreenchidoNaPautaDoTracks(@Param(name = "login") String login,
				@Param(name = "password") String password, @Param(name = "addInformacaoPeca") String addInformacaoPeca,
				@Param(name = "titulo") String titulo, @Param(name = "email") String email,
				@Param(name = "textoParaOProcesso") String textoParaOProcesso) {

			new LoginPage(navegador).fazerLogin(login, password).irParaFormDePeca()
					.addInformacaoNoFormularioDePeca(addInformacaoPeca).digiteTitulo(titulo).digiteEmail(email)
					.selecioneUmRelacionamento().digiteUmTextoParaAutomacao(textoParaOProcesso).submeterFormulario();

		}
		
	
	//@Test
	public void testAddNoWidgetMaterialNoProcessoDaPautaDoTracks() {
		new LoginPage(navegador).fazerLogin("automacao", "jamworks").irParaFormDePeca()
				.addInformacaoNoFormularioDePeca("Formulario de Teste para Automacao de Teste")
				.digiteTitulo("Automacao de Teste").digiteEmail("anderson.rolim@casavaticano.com.br")
				.widgetMaterial("100", "Revista ROLIM").selecioneUmRelacionamento().submeterFormulario();

	}

	//Test
	public void testProcessoCompletoDaPautaDoTracks() throws InterruptedException {
		new LoginPage(navegador).fazerLogin("automacao", "jamworks")
		.irParaFormDePeca()
		.addInformacaoNoFormularioDePeca("Formulario de Teste para Automacao de Teste")
		.digiteTitulo("Automacao de Teste")
		.digiteEmail("anderson.rolim@casavaticano.com.br")
		.widgetMaterial("100", "Revista ROLIM")
		.selecioneUmRelacionamento()
		.submeterFormulario()
		.fazerBuscaNaPautaDoTracks("Formulario de Teste para Automacao de Teste")
		.renomearAPecaDoProcessoNaPautaDoTracks()
		.inserirComentarioNaPecaDoProcessoNaPautaDoTracks()
		.duplicarProcesso()
		.submeterFormulario()
		.removerProcessoNaPautaDoTracks();

	}
	
	@After
	public void tearDown() {
		navegador.quit();
	}

}
