package br.com.casavaticano.jamworks.suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
	public static String dataHoraParaArquivo() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		//20171205110700
		return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
		
		
		
	}
	
	
	
	
}
