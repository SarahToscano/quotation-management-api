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

public class StockSteps extends CucumberSpringConfig{
	
	private JSONObject body;
	private ResultActions response;
	private String invalidStockId;
	
	@Before
	public void before() {
		this.body = new JSONObject();
	}

	
	@Given("a stockId {string} and its description {string}")
	public void a_stock_id_and_its_description(String id, String description) {
		body.put("id", id);
		body.put("description", description);
	}
	@When("access the \\/stock route")
	public void access_the_stock_route() throws Exception {
		response = mockMvc.perform(MockMvcRequestBuilders
				.post("/stock")
				.content(body.toString())
				.contentType(MediaType.APPLICATION_JSON));
	}
	@Then("the stock is created and the response status will be {int}")
	public void the_stock_is_created_and_the_response_status_will_be_status(Integer status) throws Exception{
		response.andExpect(MockMvcResultMatchers.status().is(status));
	}

}
