package br.com.inatel.prova.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.persistence.ManyToOne;
import br.com.inatel.prova.model.Quotes;
import br.com.inatel.prova.model.Stock;

public class StockDto {
	
	private UUID id;
	private String sctockId;
	private Map<LocalDate, String> quotes;
	
	public StockDto (Stock stock) {
		this.id = stock.getId();
		this.sctockId = stock.getSctockId();
		this.quotes = new HashMap<LocalDate,String> ();
		
		for (Quotes i : stock.getQuotes()) {
			quotes.put(i.getDate(), i.getValue());
		}
	}

	public UUID getId() {
		return id;
	}

	public String getSctockId() {
		return sctockId;
	}

	public Map<LocalDate, String> getQuotes() {
		return quotes;
	}
	
	

}
