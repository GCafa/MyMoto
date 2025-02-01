package it.polimi.mymoto.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents the response of the login request.
 */
@Data
@AllArgsConstructor
public class LoginResponse {
    private String jwt;
}
