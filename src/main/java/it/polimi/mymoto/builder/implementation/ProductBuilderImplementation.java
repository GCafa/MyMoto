package it.polimi.mymoto.builder.implementation;

import it.polimi.mymoto.builder.definition.ProductBuilder;
import it.polimi.mymoto.model.Product;
import it.polimi.mymoto.state.definition.product.ProductState;
import it.polimi.mymoto.state.implementation.product.Available;

public class ProductBuilderImplementation implements ProductBuilder {
    private Long id;
    private String brand;
    private String name;
    private double price;
    private double weight;
    private String description;
    private String imagePath;

    @Override
    public ProductBuilder id(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public ProductBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public ProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public ProductBuilder price(double price) {
        this.price = price;
        return this;
    }

    @Override
    public ProductBuilder weight(double weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public ProductBuilder description(String description) {
        this.description = description;
        return this;
    }

    @Override
    public ProductBuilder imagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    @Override
    public Product build() {
        ProductState state = new Available();
        return new Product(id, brand, name, price, weight, description, state.toString(), imagePath, state);
    }
}
