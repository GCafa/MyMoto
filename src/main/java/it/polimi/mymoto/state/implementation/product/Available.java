package it.polimi.mymoto.state.implementation.product;

import it.polimi.mymoto.model.Product;
import it.polimi.mymoto.state.definition.product.ProductState;

public class Available implements ProductState {
    @Override
    public void updateState(Product product) {
        product.setState(this);
    }

    @Override
    public String toString() {
        return Available.class.getSimpleName();
    }
}
