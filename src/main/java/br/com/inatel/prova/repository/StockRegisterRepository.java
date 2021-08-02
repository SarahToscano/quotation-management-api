package br.com.inatel.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.inatel.prova.model.StockRegister;

public interface StockRegisterRepository extends JpaRepository<StockRegister, Long> {

}
