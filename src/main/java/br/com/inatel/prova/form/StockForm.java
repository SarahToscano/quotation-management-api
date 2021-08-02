package br.com.inatel.prova.form;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.inatel.prova.model.Quotes;
import br.com.inatel.prova.model.Stock;

public class StockForm {
	
	@NotNull @NotEmpty
	private String stockId;
	
	@NotNull @NotEmpty
	private Map<LocalDate, String> quotes;


	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public Map<LocalDate, String> getQuotes() {
		return quotes;
	}

	public void setQuotes(Map<LocalDate, String> quotes) {
		this.quotes = quotes;
	}

	public Stock converter() {
		Stock stock = new Stock(stockId);
		quotes.forEach((date, value)-> stock.addQuotes(new Quotes(stock, value, date)));
		return stock;
	}
	

}
