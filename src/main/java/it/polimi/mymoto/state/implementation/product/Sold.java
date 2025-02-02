package it.polimi.mymoto.state.implementation.product;

import it.polimi.mymoto.model.Product;
import it.polimi.mymoto.state.definition.product.ProductState;

public class Sold implements ProductState {
    @Override
    public void updateState(Product product) {
        product.setState(this);
    }

    @Override
    public String toString() {
        return "Sold";
    }
}
