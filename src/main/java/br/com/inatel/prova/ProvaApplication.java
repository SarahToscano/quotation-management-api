package br.com.inatel.prova;
import br.com.inatel.prova.service.externalAPI.ExternalApiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport 
@EnableCaching
public class ProvaApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ProvaApplication.class, args);
	}

}
