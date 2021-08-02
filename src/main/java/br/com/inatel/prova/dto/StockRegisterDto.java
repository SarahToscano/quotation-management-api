package br.com.inatel.prova.dto;

import br.com.inatel.prova.model.StockRegister;

public class StockRegisterDto {
	
	private String id;
	private String description;
	
	public StockRegisterDto(StockRegister stockRegister) {
		this.id = stockRegister.getId();
		this.description = stockRegister.getDescription();
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	

}
