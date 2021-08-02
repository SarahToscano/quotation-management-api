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
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;
	
	
	private String sctockId;
		
	@OneToMany(mappedBy = "stock", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @OnDelete(action = OnDeleteAction.CASCADE)
	private List<Quotes> quotes = new ArrayList<>();
	
	public Stock(String stockId) {
		this.sctockId = stockId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, quotes, sctockId);
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
				&& Objects.equals(sctockId, other.sctockId);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getSctockId() {
		return sctockId;
	}

	public void setSctockId(String sctockId) {
		this.sctockId = sctockId;
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
	
	
	
	
	
}


