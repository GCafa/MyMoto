package it.polimi.mymoto.model;

import it.polimi.mymoto.state.definition.product.ProductState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;

    private String imagePath;

    private transient ProductState state;

    @ManyToOne
    private User seller;
}
