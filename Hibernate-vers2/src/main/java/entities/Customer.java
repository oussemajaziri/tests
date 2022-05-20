package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="client")
public class Customer {
	
	@Id
	@Column(name="Nr_Id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(name="Nom_Client")
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	private Adress adress;
	@OneToMany (cascade = CascadeType.ALL)
	@JoinTable (name="Client_Facture")
	private List<Invoice> invoices;
	
	
	public Customer() {
	}
	
	public Customer(String name,Adress adress) {
		this.name = name;
		this.adress=adress;
	}

	
	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", adress=" + adress + ", invoices=" + invoices + "]";
	}
	
	

}
