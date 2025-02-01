package it.polimi.mymoto.builder.implementation;

import it.polimi.mymoto.builder.definition.UserBuilder;
import it.polimi.mymoto.model.Address;
import it.polimi.mymoto.model.Order;
import it.polimi.mymoto.model.Role;
import it.polimi.mymoto.model.User;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class UserBuilderImplementation implements UserBuilder {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Role role;
    private List<Address> addresses;
    private List<Order> orders;

    @Override
    public UserBuilder id(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public UserBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public UserBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public UserBuilder username(String username) {
        this.username = username;
        return this;
    }

    @Override
    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public UserBuilder role(Role role) {
        this.role = role;
        return this;
    }

    @Override
    public UserBuilder addresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    @Override
    public UserBuilder orders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

    @Override
    public User build() {
        return new User(id, firstName, lastName, username, email, password, role, addresses, orders);
    }
}
