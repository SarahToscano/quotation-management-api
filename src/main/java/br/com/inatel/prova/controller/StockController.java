package br.com.inatel.prova.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.inatel.prova.dto.StockDto;
import br.com.inatel.prova.dto.StockRegisterDto;
import br.com.inatel.prova.form.StockForm;
import br.com.inatel.prova.model.Quotes;
import br.com.inatel.prova.model.Stock;
import br.com.inatel.prova.model.StockRegister;
import br.com.inatel.prova.repository.QuotesRepository;
import br.com.inatel.prova.repository.StockRepository;
import br.com.inatel.prova.service.externalAPI.ExternalApiService;
import br.com.inatel.prova.dto.StockDto;

@RestController
@RequestMapping("/operation")
public class StockController {
	
	@Autowired
    private StockRepository stockRepository;
	
	@Autowired
    private QuotesRepository quotesRepository;
	
	@Autowired 
	private ExternalApiService api;

	@PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid StockForm form, UriComponentsBuilder uriBuilder) {
    	if(api.getStockById(form.getStockId()) != null) {
    		Stock stock = form.converter();
        	stockRepository.save(stock);
        	URI uri = uriBuilder.path("/stock/{id}").buildAndExpand(stock.getId()).toUri();
        	return ResponseEntity.created(uri).body(new StockDto(stock));
    	}
    	else {
			return ResponseEntity.status(404).body("StockId not found on database");
    	}	 
    }
	
	@GetMapping("{stockId}")
	public ResponseEntity<?> list(@PathVariable String stockId) {
		List<Stock> optional = stockRepository.findAllByStockId(stockId);

		if (optional.isEmpty()) {
			return ResponseEntity.status(404).body("StockId not found on database");

		}
		else {
			return ResponseEntity.ok(StockDto.converter(optional));
		}	
		
	}
	
	@GetMapping
	public ResponseEntity<List<StockDto>> listAll() {
		List<Stock> optional = stockRepository.findAll();
		System.out.println();
		if(optional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(StockDto.converter(optional));
		}
	}
	
}


	
	
	