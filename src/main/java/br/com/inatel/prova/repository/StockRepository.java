package br.com.inatel.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inatel.prova.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
