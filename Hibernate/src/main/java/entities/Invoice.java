package entities;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	@ElementCollection
	private Map<Product,Integer> productQuantity;
	private float total;

	public Invoice() {
		this.date=LocalDate.now();
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

	
	public Map<Product, Integer> getProductQuantity() {
		return productQuantity;
	}

	
	public void setProductQuantity(Map<Product, Integer> productQuantity) {
		this.productQuantity = productQuantity;
		productQuantity.forEach(((product,integer) -> this.total+=product.getUnitPrice()*integer));
	}

	
	public float getTotal() {
		return total;
	}

	
	public void setTotal(float total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "\n\nInvoice [id=" + id + ", date=" + date + ", \nproductQuantity=" + productQuantity + ", \ntotal=" + total + "]";
	}




}
