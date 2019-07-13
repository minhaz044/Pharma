package me.pharmacy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="medicine_generic")
public class MedicineGeneric {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String generic;
	@OneToMany(mappedBy = "generic")
	private List<Medicine> medicines;
	private String chemical;
	private boolean delete=false;

}
