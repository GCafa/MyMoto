package it.polimi.mymoto.builder.implementation;

import it.polimi.mymoto.builder.definition.AddressBuilder;
import it.polimi.mymoto.model.Address;

public class AddressBuilderImplementation implements AddressBuilder {
    private Long id;
    private String street;
    private String city;
    private String zipCode;
    private String country;

    @Override
    public AddressBuilder id(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public AddressBuilder street(String street) {
        this.street = street;
        return this;
    }

    @Override
    public AddressBuilder city(String city) {
        this.city = city;
        return this;
    }

    @Override
    public AddressBuilder zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @Override
    public AddressBuilder country(String country) {
        this.country = country;
        return this;
    }

    @Override
    public Address build() {
        return new Address(id, street, city, zipCode, country);
    }
}
