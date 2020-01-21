package me.pharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Minhaz on 1/21/2020.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="credits")
public class Credits {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "customerInfoId")
    private CustomerInfo customerInfoId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer_id;
    private Date createdAt;
    private boolean is_delete=false;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }
}
