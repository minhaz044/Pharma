package me.pharmacy.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sales")
public class SalesProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sales_id;
	private Integer customer_id;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Medicine product;
	private float comision;
	private Double quantity;
	private boolean is_delete=false;
	private Date createdAt;


	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

}