package br.com.kentec.comida.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataFormatadas {
	
	public static String dataAtual() {
		LocalDateTime agora = LocalDateTime.now();
	    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataFormatada = formatterData.format(agora);
		return dataFormatada;
	}
	
	public static LocalDateTime dataAtual2() {
		LocalDateTime agora = LocalDateTime.now();
	    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataFormatada = formatterData.format(agora);
        LocalDateTime localDateTime6 = LocalDateTime.parse(dataFormatada, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return localDateTime6;
	}
	
	
}
