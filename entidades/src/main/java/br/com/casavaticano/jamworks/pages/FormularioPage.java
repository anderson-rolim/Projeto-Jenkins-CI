package br.com.casavaticano.jamworks.pages;

//import org.junit.Rule;
//import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//import br.com.casavaticano.jamworks.suporte.Generator;
//import br.com.casavaticano.jamworks.suporte.Screenshot;

public class FormularioPage extends BasePage{
//	@Rule
//	public TestName test = new TestName();
	
	public FormularioPage(WebDriver navegador) {
		super(navegador);
		
	}

	public FormularioPage digiteTitulo(String Titulo) {	
		navegador.findElement(By.xpath("//*[@id=\"form_1_field_1037\"]")).sendKeys(Titulo);	
		return this;
	}
	
	public FormularioPage digiteEmail(String Email) {
		navegador.findElement(By.xpath("//*[@id=\"form_1_field_1036\"]")).sendKeys(Email);
		return this;
	}
	
	public FormularioPage selecioneUmRelacionamento() {
		WebElement Relacionamento = navegador.findElement(By.name("form_1[field_1038]"));
		new Select(Relacionamento).selectByValue("1345");
		return this;
	}
	
	public FormularioPage digiteUmTextoParaAutomacao(String TextoParaAutomacao) {
		navegador.findElement(By.xpath("//*[@id=\"form_1_field_1039\"]")).sendKeys(TextoParaAutomacao);		
		return this;
	}

	public FormularioPage addEANWidgetDeTabela(String EAN) {
		navegador.findElement(By.xpath("//*[@id=\"form_table_form_1_field_1041_row1_cel1]\"]")).sendKeys(EAN);		
		return this;
	}
	
	public FormularioPage addDescricaoWidgetDeTabela(String Descricao) {
		navegador.findElement(By.xpath("//*[@id=\"form_table_form_1_field_1041_row1_cel2]\"]")).sendKeys(Descricao);		
		return this;
	}
	
	public FormularioPage addTamanhoWidgetDeTabela(String Tamanho) {
		navegador.findElement(By.xpath("//*[@id=\"form_table_form_1_field_1041_row1_cel3]\"]")).sendKeys(Tamanho);		
		return this;
	}
	
	public FormularioPage widgetDeTabela(String EAN, String Descricao, String Tamanho) {		
		try {
			Thread.sleep(800);
			addEANWidgetDeTabela(EAN); 
			addDescricaoWidgetDeTabela(Descricao);
			addTamanhoWidgetDeTabela(Tamanho);
			
		//	String CaminhoDoScreenshot = "/Users/andersonrolim/drivers/screenshot/"+ Generator.dataHoraParaArquivo()+test.getMethodName()+".png";
		//	Screenshot.tirar(navegador,CaminhoDoScreenshot);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return this; 
		
	}
	
	public FormularioPage clicarNoBotaoAddMaterial() {
		JavascriptExecutor executor = (JavascriptExecutor) navegador;
		//WebElement widgetMaterial = navegador.findElement(By.xpath("//a[@id=\"form_table_material_vinc\"]"));
		WebElement widgetMaterial = navegador.findElement(By.xpath("//div[@class=\"item clearfix material\"]//div[@class=\"table-reservemidia ui-data table-widget\"]//div[@class=\"table-actions\"]//a[@id=\"form_table_material_vinc\"]"));
		executor.executeScript("arguments[0].click();", widgetMaterial);		
		return this;
		
	}
	
	public FormularioPage marcarCheckboxDoMaterial() {
		JavascriptExecutor executor = (JavascriptExecutor) navegador;
		WebElement widgetModalAddMaterial = navegador.findElement(By.id("material_checkbox_88"));
		executor.executeScript("arguments[0].click();", widgetModalAddMaterial);
		return this;
		
	}
	
	public FormularioPage preencherQTDDeMaterial(String QtdMaterial) {
		navegador.findElement(By.xpath("//input[@id='material_input_qty_88']")).sendKeys(QtdMaterial);    
		return this;
	}
	
	public FormularioPage preencherNomeDoMaterial(String NomeDoMaterial) {
		navegador.findElement(By.xpath("//input[@id='material_input_88']")).sendKeys(NomeDoMaterial);
		return this;
	}
	
	public FormularioPage clicarAddMaterial() {
		navegador.findElement(By.id("material_widget_submit")).click();
		return this;
	}
	
	public FormularioPage widgetMaterial(String QtdMaterial, String NomeDoMaterial) {
		try {
			Thread.sleep(1000);
			clicarNoBotaoAddMaterial();
			marcarCheckboxDoMaterial();
			preencherQTDDeMaterial(QtdMaterial);
			preencherNomeDoMaterial(NomeDoMaterial); 
			clicarAddMaterial();
			
	//		String CaminhoDoScreenshot = "/Users/andersonrolim/drivers/screenshot/"+ Generator.dataHoraParaArquivo()+test.getMethodName()+".png";
	//		Screenshot.tirar(navegador,CaminhoDoScreenshot);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return this;
		
	}
	
	public FormularioPage clicarNoBotaoAddPedidoMaterial() {
		WebElement pedidoMaterial = navegador.findElement(By.xpath("//div[@class=\"table-actions-pm actions-tab-large\"]//i[@class=\"icon-plus-sign\"]"));
		pedidoMaterial.click();
		return this;
	}
	
	public FormularioPage pesquisaVeiculosPedidoMaterial(String NomeDoPedidoDoMaterial) {
		navegador.findElement(By.id("pesquisa-veiculos-pedido-material")).clear();
		navegador.findElement(By.id("pesquisa-veiculos-pedido-material")).sendKeys(NomeDoPedidoDoMaterial);
		return this;
	}
	
	public FormularioPage clicarNoBotaoBuscaVeiculosPedidoMaterial() {
		try {
			Thread.sleep(1000);
			WebElement Buscar = navegador.findElement(By.xpath("//div[@class=\"span6\"]//a[@class=\"btn btn-info submitSearch\"]//i[@class=\"icon-search\"]"));
				       Buscar.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
			return this;
	}
	
	public FormularioPage inserirVeiculosPedidoMaterial() {
		navegador.findElement(By.xpath("//a[@class=\"inserirVeiculo\"]//i[@class=\"icon-plus\"]")).click();
		return this;
	}
	
	public FormularioPage addNaListaDeVeiculosPedidoMaterial() {		
		navegador.findElement(By.xpath("id(\"pedidoMaterial\")/div[2]/button[1]")).click();
		return this;
	}
	
	public FormularioPage widgetPedidoMaterial(String NomeDoPedidoDoMaterial) {
		clicarNoBotaoAddPedidoMaterial();
		pesquisaVeiculosPedidoMaterial(NomeDoPedidoDoMaterial); 
		clicarNoBotaoBuscaVeiculosPedidoMaterial();
		inserirVeiculosPedidoMaterial();
		addNaListaDeVeiculosPedidoMaterial();
		
	//	String CaminhoDoScreenshot = "/Users/andersonrolim/drivers/screenshot/"+ Generator.dataHoraParaArquivo()+test.getMethodName()+".png";
	//	Screenshot.tirar(navegador,CaminhoDoScreenshot);
		
		return this;
	}
			
	public FormularioPage preenchendoFormulario(String Titulo,String Email,String TextoParaAutomacao, String EAN, String Descricao, String Tamanho) {
		digiteTitulo(Titulo);
		digiteEmail(Email);
		selecioneUmRelacionamento();
		digiteUmTextoParaAutomacao(TextoParaAutomacao);
		
	//	String CaminhoDoScreenshot = "/Users/andersonrolim/drivers/screenshot/"+ Generator.dataHoraParaArquivo()+test.getMethodName()+".png";
	//	Screenshot.tirar(navegador,CaminhoDoScreenshot);
		
		return this;
		
	}
		
	public TracksPage submeterFormulario() {
		try {
			Thread.sleep(5000);
			navegador.findElement(By.xpath("//div[@class=\"form_row form-buttons\"]//div[@class=\"control-group\"]//button[@class=\"btn btn-base btn-big\"]")).click();	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new TracksPage(navegador);
	}
	

}

