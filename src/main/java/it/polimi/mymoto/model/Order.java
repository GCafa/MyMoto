package it.polimi.mymoto.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime orderDate;

    private String status;

    private double total;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Product> products;
}
