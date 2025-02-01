package it.polimi.mymoto.builder.definition;

import it.polimi.mymoto.model.Product;

public interface ProductBuilder {
    ProductBuilder id(Long id);
    ProductBuilder brand(String brand);
    ProductBuilder name(String name);
    ProductBuilder price(double price);
    ProductBuilder weight(double weight);
    ProductBuilder description(String description);
    ProductBuilder imagePath(String imagePath);
    Product build();
}
