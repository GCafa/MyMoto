package it.polimi.mymoto.builder.implementation;

import it.polimi.mymoto.builder.definition.OrderBuilder;
import it.polimi.mymoto.model.Order;

public class OrderBuilderImplementation implements OrderBuilder {
    private Long id;
    private Long userId;
    private Long productId;
    private int quantity;
    private double totalPrice;

    @Override
    public OrderBuilder id(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public OrderBuilder userId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public OrderBuilder productId(Long productId) {
        this.productId = productId;
        return this;
    }

    @Override
    public OrderBuilder quantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public OrderBuilder totalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    @Override
    public Order build() {
        return new Order(id, userId, productId, quantity, totalPrice);
    }
}
