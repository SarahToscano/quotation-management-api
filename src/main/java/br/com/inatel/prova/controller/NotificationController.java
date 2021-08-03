package br.com.inatel.prova.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.inatel.prova.service.externalAPI.ExternalApiService;

@Component
public class NotificationController {
	
	@Autowired
	private ExternalApiService api;
	
	@PostConstruct
	private void launcher() {
		api.createNotification();
	}

}

	
	