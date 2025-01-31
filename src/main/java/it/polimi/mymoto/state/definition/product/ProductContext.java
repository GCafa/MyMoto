package it.polimi.mymoto.state.definition.product;

import it.polimi.mymoto.state.implementation.product.Available;

public class ProductContext {
    private ProductState state;

    public ProductContext() {
        this.state = new Available();
    }

    public void updateState() {
        state.updateState(this);
    }

    public void setState(ProductState state) {
        this.state = state;
    }
}
