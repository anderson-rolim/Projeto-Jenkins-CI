package br.com.casavaticano.jamworks.entidade;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AberturaDoJamworksTest {
	private WebDriver navegador;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/andersonrolim/drivers/chromedriver");
		navegador = new ChromeDriver();
	}
	
	
	@Test
	public void testAbriBrowser() {
		
	
		navegador.get("https://homologacao.casavaticano.com.br");	
		
		assertEquals(1, 1);
	}
	
	@After
	public void tearDown() {
		navegador.quit();
	}

}
