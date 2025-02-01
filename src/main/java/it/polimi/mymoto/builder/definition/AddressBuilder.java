package it.polimi.mymoto.builder.definition;

import it.polimi.mymoto.model.Address;

public interface AddressBuilder {
    AddressBuilder id(Long id);
    AddressBuilder street(String street);
    AddressBuilder city(String city);
    AddressBuilder zipCode(String zipCode);
    AddressBuilder country(String country);
    Address build();
}
