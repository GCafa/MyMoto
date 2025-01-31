package it.polimi.mymoto.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Role {
    CUSTOMER(Collections.emptySet()),
    SELLER(
            Set.of(
                    Permission.SELLER_READ,
                    Permission.SELLER_UPDATE,
                    Permission.SELLER_CREATE,
                    Permission.SELLER_DELETE
            )
    ),
    ADMIN(
            Stream.concat(
                    SELLER.permissions.stream(),
                    Set.of(
                            Permission.ADMIN_READ,
                            Permission.ADMIN_UPDATE,
                            Permission.ADMIN_CREATE,
                            Permission.ADMIN_DELETE
                    ).stream()
            ).collect(Collectors.toSet())
    );

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        return permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getValue()))
                .toList();
    }
}
