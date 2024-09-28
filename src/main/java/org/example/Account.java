package org.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;


@Entity
@Table(name = "accounts")
public class Account extends PanacheEntity {
    public String accountNumber;
    public BigDecimal balance;
    public String status;
}
