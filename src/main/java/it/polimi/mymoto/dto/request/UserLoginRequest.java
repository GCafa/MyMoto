package it.polimi.mymoto.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginRequest {
    @NotBlank(message = "Username is mandatory")
    private String username;
//    private String email;
    @NotBlank(message = "Password is mandatory")
    private String password;
}
