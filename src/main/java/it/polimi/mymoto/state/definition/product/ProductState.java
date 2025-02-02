package it.polimi.mymoto.state.definition.product;

import it.polimi.mymoto.model.Product;

public interface ProductState {
    void updateState(Product product);
}
