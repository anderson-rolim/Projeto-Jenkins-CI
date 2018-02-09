package br.com.casavaticano.jamworks.suporte;

 import java.io.File;
import java.io.IOException;

//import java.io.File;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static void tirar(WebDriver navegador, String arquivo) {
		File screenshort =  ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);	
		try{
			FileUtils.copyFile(screenshort, new File(arquivo));
		}catch(Exception e){
			System.out.println("Houveram problemas ao copiar o arquivo para a pasta"+ e.getMessage());
		}
		
	}

}
