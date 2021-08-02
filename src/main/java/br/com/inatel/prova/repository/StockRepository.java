package br.com.inatel.prova.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inatel.prova.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

	Optional<Stock> findByStockId(String stockId);

}
