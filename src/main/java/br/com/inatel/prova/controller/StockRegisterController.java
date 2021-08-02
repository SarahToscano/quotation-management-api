package br.com.inatel.prova.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.inatel.prova.dto.StockRegisterDto;
import br.com.inatel.prova.form.StockRegisterForm;
import br.com.inatel.prova.model.StockRegister;
import br.com.inatel.prova.repository.StockRegisterRepository;

@RestController
@RequestMapping("/stock")
public class StockRegisterController {
	
	@Autowired
    private StockRegisterRepository registerRepository;
	
	@PostMapping
    @Transactional
    public ResponseEntity<StockRegisterDto> create(@RequestBody @Valid StockRegisterForm form, UriComponentsBuilder uriBuilder) {
    	StockRegister register = form.converter();
    	registerRepository.save(register);
    	
    	URI uri = uriBuilder.path("/register/{id}").buildAndExpand(register.getId()).toUri();
    	return ResponseEntity.created(uri).body(new StockRegisterDto(register));
    }

}

	
	

	
