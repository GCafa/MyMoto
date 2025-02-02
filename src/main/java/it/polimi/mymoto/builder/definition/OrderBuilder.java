package it.polimi.mymoto.builder.definition;

import it.polimi.mymoto.model.Order;
import it.polimi.mymoto.model.OrderItem;
import it.polimi.mymoto.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderBuilder {
    OrderBuilder id(Long id);
    OrderBuilder orderDate(LocalDateTime orderDate);
    OrderBuilder total(double total);
    OrderBuilder customer(User customer);
    OrderBuilder orderItems(List<OrderItem> orderItems);
    Order build();
}
