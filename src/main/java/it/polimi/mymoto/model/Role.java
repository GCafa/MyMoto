package it.polimi.mymoto.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    CUSTOMER,
    SELLER,
    ADMIN;
}
