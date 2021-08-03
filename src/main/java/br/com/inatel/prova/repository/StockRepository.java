package br.com.inatel.prova.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inatel.prova.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

	List<Stock> findAllByStockId(String stockId);

	Optional<Stock> findByStockId(String stockId);

}
