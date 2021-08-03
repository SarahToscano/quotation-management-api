package br.com.inatel.prova.service.externalAPI;


import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import br.com.inatel.prova.dto.StockDto;
import br.com.inatel.prova.dto.StockRegisterDto;
import br.com.inatel.prova.form.StockRegisterForm;

 
@Service("apiService")
public class ExternalApiService {
	
	private RestTemplate restTemplate;
	
	private static final String stock_manager_url = "http://localhost:8080";
	
	@Autowired
	public ExternalApiService () {
		this.restTemplate = new RestTemplate(); 
	}
	
	
	@Cacheable(value = "getStocksRegistered")
	public List<StockRegisterDto> getAllStocks() {
		String url = stock_manager_url + "/stock";	
		StockRegisterDto[] stocks = restTemplate.getForObject(url, StockRegisterDto[].class);		
		return Arrays.asList(stocks);
	}
	
	@Cacheable(value = "getStock")
	public StockRegisterDto getStockById(String stockId) {
		String url = stock_manager_url + "/stock/" + stockId;
		return restTemplate.getForObject(url, StockRegisterDto.class);
	}

	@CacheEvict (value = "getStocksRegistered", allEntries=true)
	public StockRegisterForm createNewStocks(StockRegisterForm form, UriComponentsBuilder uriBuilder) {
		String url = stock_manager_url + "/stock";	
		restTemplate.postForEntity(url, form, StockRegisterForm.class);
		return form;
	}


	public void createNotification() {
		String url = stock_manager_url + "/notification";	
		
		JSONObject json = new JSONObject();
		json.put("host", "localhost");
		json.put("port", "8081");
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(json.toString(), header);
		restTemplate.postForObject(url, entity, String.class);
		
		System.out.println("Registering the Local Host -------------------------- ");
	}

	

}


