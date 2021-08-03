package br.com.inatel.prova.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.inatel.prova.dto.StockDto;
import br.com.inatel.prova.dto.StockRegisterDto;
import br.com.inatel.prova.form.StockRegisterForm;
import br.com.inatel.prova.model.Stock;
import br.com.inatel.prova.model.StockRegister;
import br.com.inatel.prova.repository.StockRegisterRepository;
import br.com.inatel.prova.service.externalAPI.ExternalApiService;

@RestController
@RequestMapping("/stock")
public class ExternalApiController {
	
	@Autowired
    private StockRegisterRepository registerRepository;
	
	@Autowired
	private ExternalApiService api;
	
	@PostMapping
    @Transactional
	@CacheEvict (value = "getStocksRegistered", allEntries=true)
	public HttpEntity<StockRegisterForm> CreateStocksNoRegistered(@RequestBody @Valid StockRegisterForm form, UriComponentsBuilder uriBuilder){
		StockRegisterForm stocks = api.createNewStocks(form, uriBuilder);		
		return ResponseEntity.ok().body(stocks);
	}
	
	
	@GetMapping
	@Cacheable(value = "getStocksRegistered")
	public HttpEntity<List<StockRegisterDto>> ListAllStocksRegistered(){
		List<StockRegisterDto> stocks = api.getAllStocks();		
		return ResponseEntity.ok().body(stocks);
	}
	
	@GetMapping("{stockId}")
	@Cacheable(value = "getStocksRegistered")
	public ResponseEntity<StockRegisterDto> ListStocksById(@PathVariable String stockId){
		StockRegisterDto stocks = api.getStockById(stockId);		
		return ResponseEntity.ok().body(stocks);
	}
	
}

	
	

	
