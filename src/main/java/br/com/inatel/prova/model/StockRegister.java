package br.com.inatel.prova.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockRegister {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_number;

	private String id;
	private String description;
	

	
	@Override
	public int hashCode() {
		return Objects.hash(description, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockRegister other = (StockRegister) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public StockRegister(String id, String description) {
		this.id = id;
		this.description = description;
	}
	
	
	
	
}
