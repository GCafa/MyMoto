package it.polimi.mymoto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;

    @ManyToMany
    private List<CartItem> cartItems;

    private Double totalPrice;
}
