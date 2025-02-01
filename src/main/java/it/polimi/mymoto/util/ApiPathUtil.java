package it.polimi.mymoto.util;

import it.polimi.mymoto.model.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiPathUtil {
    public static String getGeneralRestPath(Role role) {
        return getRoleRestPath(role) + "/**";
    }

    public static String getRoleRestPath(Role role) {
        return REST_PATH + "/" + role.name().toLowerCase();
    }
}
