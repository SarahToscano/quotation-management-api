package br.com.inatel.prova.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.inatel.prova.model.StockRegister;

public class StockRegisterForm {

	@NotNull @NotEmpty
	private String id;
	
	@NotNull @NotEmpty
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StockRegister converter() {
		return new StockRegister(id, description);
	}
	
	
	
}
