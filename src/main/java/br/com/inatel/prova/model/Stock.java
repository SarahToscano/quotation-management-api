package br.com.inatel.prova.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private UUID uuid;
	
	
	private String stockId;
		
	@OneToMany(mappedBy = "stock", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @OnDelete(action = OnDeleteAction.CASCADE)
	private List<Quotes> quotes = new ArrayList<>();
	
	public Stock(String stockId) {
		this.stockId = stockId;
	}
	
	public Stock() {
		this.uuid = uuid.randomUUID();
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, quotes, stockId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(id, other.id) && Objects.equals(quotes, other.quotes)
				&& Objects.equals(stockId, other.stockId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSctockId() {
		return stockId;
	}

	public void setSctockId(String stockId) {
		this.stockId = stockId;
	}

	public List<Quotes> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quotes> quotes) {
		this.quotes = quotes;
	}
	
	public void addQuotes(Quotes quote) {
        quotes.add(quote);
    }

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	
	
	
	
	
	
	
}


