package it.polimi.mymoto.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiPathUtil {
    public static final String BASE_PATH = "/api";
    public static final String REST_PATH = BASE_PATH + "/v1";
    public static final String CUSTOMER_PATH = REST_PATH + "/customer";
    public static final String SELLER_PATH = REST_PATH + "/seller";
    public static final String ADMIN_PATH = REST_PATH + "/admin";
}
