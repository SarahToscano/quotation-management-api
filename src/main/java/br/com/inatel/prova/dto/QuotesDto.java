package br.com.inatel.prova.dto;

import java.time.LocalDate;

import br.com.inatel.prova.model.Quotes;

public class QuotesDto {
	
	private LocalDate date;
	private String value;
	
	public QuotesDto() {
		
	}
	
	public QuotesDto (Quotes quotes) {
		this.date = quotes.getDate();
		this.value = quotes.getValue();
	}
	
	public LocalDate getDate() {
		return date;
	}
	public String getValue() {
		return value;
	}
	
	
	
	

}
