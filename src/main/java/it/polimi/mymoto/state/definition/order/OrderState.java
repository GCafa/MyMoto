package it.polimi.mymoto.state.definition.order;

import it.polimi.mymoto.model.Order;

public interface OrderState {
    void updateState(Order order);
}
