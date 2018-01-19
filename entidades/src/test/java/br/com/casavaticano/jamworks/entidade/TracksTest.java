package br.com.casavaticano.jamworks.entidade;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import br.com.casavaticano.jamworks.pages.LoginPage;
import br.com.casavaticano.jamworks.suporte.Web;

@RunWith(DataDrivenTestRunner.class)
//@DataLoader(filePaths = "testAdicionarUmProcessoNaPautaDoTracks.csv")
@DataLoader(filePaths = "TracksTest.csv")

public class TracksTest {
	
	private WebDriver navegador;
	@Before
	public void setUp() {
		   navegador = Web.createBrowserStack();
		 //navegador = Web.createChrome();
	}
	
	@Test
	public void testAddUmProcessoNaPautaDoTracks(
			@Param(name="login")String login,
			@Param(name="password")String password, 
			@Param(name="addInformacaoPeca")String addInformacaoPeca,
			@Param(name="titulo")String titulo,
			@Param(name="email")String email, 
			@Param(name="textoParaOProcesso")String textoParaOProcesso
			) {
		
		new LoginPage(navegador)
			.fazerLogin(login, password)
			.irParaFormDePeca()
			.addInformacaoNoFormularioDePeca(addInformacaoPeca) 
			.digiteTitulo(titulo)
			.digiteEmail(email)
			.selecioneUmRelacionamento()
			.digiteUmTextoParaAutomacao(textoParaOProcesso)
			.submeterFormulario();	
		
	}
	
	@After
	public void tearDown() {
		navegador.quit();
	}

}
