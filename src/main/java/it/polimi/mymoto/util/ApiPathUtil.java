package it.polimi.mymoto.util;

import it.polimi.mymoto.model.Role;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiPathUtil {
    public static final String BASE_PATH = "/api";
    public static final String REST_PATH = BASE_PATH + "/v1";

    public static String getGeneralRestPath(Role role) {
        return getRestPathByRole(role) + "/**";
    }

    public static String getRestPathByRole(Role role) {
        return REST_PATH + "/" + role.name().toLowerCase();
    }
}
