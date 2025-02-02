package it.polimi.mymoto.state.implementation.order;

import it.polimi.mymoto.model.Order;
import it.polimi.mymoto.model.Product;
import it.polimi.mymoto.state.definition.order.OrderState;
import it.polimi.mymoto.state.definition.product.ProductState;

public class Delivered implements OrderState {
    @Override
    public void updateState(Order order) {
        order.setState(this);
    }

                            @Override
    public String toString() {
        return Delivered.class.getSimpleName();
    }
}
