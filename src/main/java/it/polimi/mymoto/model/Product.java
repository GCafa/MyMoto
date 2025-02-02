package it.polimi.mymoto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.polimi.mymoto.state.definition.product.ProductState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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

    /**
     * The state of the order.
     * <p>
     *     @transient to avoid serialization of the state, meaning that the state will not be saved in the database.
     *     This is because the state is a runtime object that is not meant to be saved in the database.
     *     The state is used to manage the product's lifecycle.
 *     </p>
     */
    private transient ProductState state;

    @ManyToOne
    private User seller;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
