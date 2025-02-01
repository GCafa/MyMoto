package it.polimi.mymoto.builder.definition;

import it.polimi.mymoto.model.Order;
import it.polimi.mymoto.model.Role;
import it.polimi.mymoto.model.User;

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
    User build();
}
