package it.polimi.mymoto.model;

import it.polimi.mymoto.state.definition.order.OrderState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
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


    /**
     * The state of the order.
     * <p>
     *     @transient to avoid serialization of the state, meaning that the state will not be saved in the database.
     *     This is because the state is a runtime object that is not meant to be saved in the database.
     *     The state is used to manage the order's lifecycle.
 *     </p>
     */
    private transient OrderState orderState;
}
