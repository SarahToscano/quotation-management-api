package br.com.inatel.prova.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.ManyToOne;
import br.com.inatel.prova.model.Quotes;
import br.com.inatel.prova.model.Stock;

public class StockDto {
	
	private Long id;
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

	public StockDto(List<Stock> stock) {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}

	public String getSctockId() {
		return sctockId;
	}

	public Map<LocalDate, String> getQuotes() {
		return quotes;
	}

	public static List<StockDto> converter(List<Stock> optional) {
		return optional.stream().map(StockDto::new).collect(Collectors.toList());
		
	}

	
	
	
	

}
