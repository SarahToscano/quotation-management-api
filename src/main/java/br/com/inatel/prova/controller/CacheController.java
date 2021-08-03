package br.com.inatel.prova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.inatel.prova.service.externalAPI.ExternalApiService;

@RestController
@RequestMapping("/stockcache")
public class CacheController {
	
	@CacheEvict(value = "getStocksRegistered", allEntries = true)
	@DeleteMapping
	public void cleanCache() {
		System.out.println("Invalidating the cache ------------------");
	}

}
