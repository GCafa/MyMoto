package it.polimi.mymoto.builder.implementation;

import it.polimi.mymoto.builder.definition.OrderBuilder;
import it.polimi.mymoto.model.Order;
import it.polimi.mymoto.model.OrderItem;
import it.polimi.mymoto.model.User;
import it.polimi.mymoto.state.definition.order.OrderState;
import it.polimi.mymoto.state.implementation.order.Shipping;

import java.time.LocalDateTime;
import java.util.List;

public class OrderBuilderImplementation implements OrderBuilder {
    private Long id;
    private LocalDateTime orderDate;
    private String status;
    private double total;
    private User customer;
    private List<OrderItem> orderItems;


    @Override
    public OrderBuilder id(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public OrderBuilder orderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    @Override
    public OrderBuilder total(double total) {
        this.total = total;
        return this;
    }

    @Override
    public OrderBuilder customer(User customer) {
        this.customer = customer;
        return this;
    }

    @Override
    public OrderBuilder orderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        return this;
    }

    @Override
    public Order build() {
        OrderState orderState = new Shipping();
        return new Order(id, orderDate, orderState.toString(), total, customer, orderItems, orderState);
    }


}
