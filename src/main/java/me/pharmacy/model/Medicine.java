package me.pharmacy.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="medicine")
public class Medicine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int medicine_id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "company_id") 
	private MedicineCompany company;
	@ManyToOne
	@JoinColumn(name = "generic_id")
	private MedicineGeneric generic;
	@ManyToOne
	@JoinColumn(name = "type_id")
	private MedicineType type;
	@OneToMany(mappedBy = "product")
	private List<Sales> sales;
	private String description;
	private float dosage;
	private float priceIP;
	private boolean is_delete=false;

}