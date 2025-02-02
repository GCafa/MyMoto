package it.polimi.mymoto.builder.definition;

import it.polimi.mymoto.model.*;

import java.util.List;

public interface UserBuilder {
    UserBuilder id(Long id);
    UserBuilder firstName(String firstName);
    UserBuilder lastName(String lastName);
    UserBuilder username(String username);
    UserBuilder email(String email);
    UserBuilder password(String password);
    UserBuilder role(Role role);
    UserBuilder orders(List<Order> orders);
    UserBuilder products(List<Product> products);
    UserBuilder reviews(List<Review> reviews);
    User build();
}
