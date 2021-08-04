package br.com.inatel.prova.acceptance.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.inatel.prova.acceptance.CucumberSpringConfig;
import br.com.inatel.prova.dto.StockRegisterDto;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.MediaType;


public class StockQuotesSteps extends CucumberSpringConfig {
	

	private JSONObject body;
	private JSONObject quotes;

	private StockRegisterDto regStock;
	private List<StockRegisterDto> regStocks;

	private ResultActions response;
	
	private String invalidStockId;
	
	@Before
	public void before() {
		this.body = new JSONObject();
		this.quotes = new JSONObject();
		this.regStocks = new ArrayList<>();
	}

	
	@Given("a valid stockId {string} and quotes with date {string} and value {string}")
	public void a_valid_stockId_and_quotes_with_date_and_value(String stockId, String date, String value) {
		
		this.regStock = new StockRegisterDto(stockId, "");
		regStocks.add(regStock);
		Mockito.when(stockService.getStockById(stockId)).thenReturn(regStock);
		quotes.put(date, value);
		body.put("stockId", stockId);
		body.put("quotes", quotes);
	}
	
	@Given("an invalid stockId {string} and quotes with date {string} and value {string}")
	public void an_invalid_stock_id_and_quotes_with_date_and_value(String stockId, String date, String value) throws Exception{
		this.invalidStockId=stockId;		
	}
	
	@Given("a valid stockId {string} and quotes with date {string}")
	public void a_valid_stock_id_and_quotes_with_date(String stockId, String date) {
		this.invalidStockId=stockId;	
		HashMap<String, String> quotes = new HashMap<String, String>();
		quotes.put(date, null);
		body.put("stockId", stockId);
		body.put("quotes", quotes);
		
	}
	
	@Given("a valid stockId {string} and quotes with value {string}")
	public void a_valid_stock_id_and_quotes_with_value(String stockId, String value) {
		this.invalidStockId=stockId;	
		HashMap<String, String> quotes = new HashMap<String, String>();
		quotes.put("", value);
		body.put("stockId", stockId);
		body.put("quotes", quotes);
	}
	
	@Given("just a valid stockId {string}")
	public void just_a_valid_stock_id(String stockId) {
		this.invalidStockId=stockId;	
		HashMap<String, String> quotes = new HashMap<String, String>();
		quotes.put("", null);
		body.put("stockId", stockId);
		body.put("quotes", quotes);
		
	}
	

	@When("access the \\/operation route")
	public void access_the_operation_route() throws Exception{
		response = mockMvc.perform(MockMvcRequestBuilders
				.post("/operation")
				.content(body.toString())
				.contentType(MediaType.APPLICATION_JSON));
	}
	
	@Then("the quote is created and the response status will be {int}")
	public void the_quote_is_created_and_the_response_status_will_be(Integer status) throws Exception {
	    response.andExpect(MockMvcResultMatchers.status().is(status));

	}
	
	@Then("the quote is not created and the response status will be {int}")
	public void the_quote_is_not_created_and_the_response_status_will_be(Integer status) throws Exception {
		response = mockMvc
				.perform(MockMvcRequestBuilders.get("/quote/" + invalidStockId).contentType(MediaType.APPLICATION_JSON));
	}
	
	
	


}
