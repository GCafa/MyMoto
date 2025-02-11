package it.polimi.mymoto.builder.definition;

import it.polimi.mymoto.model.Product;
import it.polimi.mymoto.model.Review;
import it.polimi.mymoto.model.User;

import java.util.List;

public interface ProductBuilder {
    ProductBuilder id(Long id);
    ProductBuilder brand(String brand);
    ProductBuilder name(String name);
    ProductBuilder price(double price);
    ProductBuilder weight(double weight);
    ProductBuilder description(String description);
    ProductBuilder imagePath(String imagePath);
    ProductBuilder seller(User seller);
    ProductBuilder reviews(List<Review> reviews);
    Product build();
}
