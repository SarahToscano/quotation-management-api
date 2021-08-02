package br.com.inatel.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.inatel.prova.model.Quotes;

public interface QuotesRepository extends JpaRepository<Quotes, Long>{

}
