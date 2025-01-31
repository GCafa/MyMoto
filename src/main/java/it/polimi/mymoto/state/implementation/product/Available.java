package it.polimi.mymoto.state.implementation.product;

import it.polimi.mymoto.state.definition.product.ProductContext;
import it.polimi.mymoto.state.definition.product.ProductState;

public class Available implements ProductState {
    @Override
    public void updateState(ProductContext context) {
        context.setState(new Sold());
    }
}
