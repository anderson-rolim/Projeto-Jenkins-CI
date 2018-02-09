package br.com.casavaticano.jamworks.suporte;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.casavaticano.jamworks.pages.LoginPage;
import br.com.casavaticano.jamworks.pages.TracksPage;
import br.com.casavaticano.jamworks.suporte.Web;

public class Web {
	  public static final String USERNAME = "rolim1";
	  public static final String AUTOMATE_KEY = "6NLzMNh281PqFk2q8geg";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


	private static WebDriver navegador;
	
	private static boolean isLoogedIn = false;
	
	public static WebDriver createChrome() {
			System.setProperty("webdriver.chrome.driver","/Users/andersonrolim/drivers/chromedriver");
			navegador = new ChromeDriver();
			navegador.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			navegador.get("http://homologacao.casavaticano.com.br/login");

		return navegador;
	
	}
	
	
	public static WebDriver createBrowserStack() {
		
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "62.0");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "10");
	    caps.setCapability("resolution", "1024x768");
	    
	    WebDriver navegador = null;
	    
	    try {
	    	navegador = new RemoteWebDriver(new java.net.URL(URL), caps);
			navegador.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			navegador.get("http://homologacao.casavaticano.com.br/login");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Houveram problema na conexao "+e);
		}

		return navegador;
	}
	
	public static boolean isLogedIn()
	{
		return Web.isLoogedIn;
	}

	public static TracksPage login() {
		LoginPage page = new LoginPage(navegador);
		
		TracksPage other = page.fazerLogin("automacao", "jamworks");

		Web.isLoogedIn = true;
		
		return other;
	}

}
