package me.pharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Minhaz on 1/20/2020.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer_info")
public class CustomerInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int customerInfoId;
    private String name;
    private String address;
    private String contact;
    @Column(unique=true)
    private String userName;
    private String password;
    private Double totalAmount;
    private Double totalDue;
    private Double totalDuePaid;
    private Double totalUses;
    private Date createdAt;
    private boolean is_delete=false;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

}
