package it.polimi.mymoto.builder.definition;

import it.polimi.mymoto.model.Order;

public interface OrderBuilder {
    OrderBuilder id(Long id);
    OrderBuilder userId(Long userId);
    OrderBuilder productId(Long productId);
    OrderBuilder quantity(int quantity);
    OrderBuilder totalPrice(double totalPrice);
    Order build();
}
