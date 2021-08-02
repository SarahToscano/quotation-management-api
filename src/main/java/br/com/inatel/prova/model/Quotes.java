package br.com.inatel.prova.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity

public class Quotes {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date;
	private String value;
	
	@ManyToOne
	 private Stock stock;
	
	public Quotes (Stock stock, String value, LocalDate date) {
		this.value = value;
		this.date = date;
		this.stock = stock;
	}
	public Quotes() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id, stock, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quotes other = (Quotes) obj;
		return Objects.equals(date, other.date) && Objects.equals(id, other.id) && Objects.equals(stock, other.stock)
				&& Objects.equals(value, other.value);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	
	
}
