package me.pharmacy.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customer_id;
	@OneToMany(mappedBy = "customer_id")
	private List<SalesProduct> sales;
	private String customerName;
	private String customerContactNo;
	private double totalPrice;
	private double payment;
	private double comision;
	private double cashBackAmount;
	private Date createdAt;
	@ManyToOne
	@JoinColumn(name = "salesBy")
	private Person salesBy;
	private boolean is_delete=false;
			
	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}
	

}
