package br.com.inatel.prova.acceptance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import br.com.inatel.prova.ProvaApplication;
import br.com.inatel.prova.service.externalAPI.ExternalApiService;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = ProvaApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CucumberSpringConfig {

	@Autowired
	protected MockMvc mockMvc;

	@MockBean
	@Autowired
	protected ExternalApiService stockService;
}


