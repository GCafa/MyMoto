package it.polimi.mymoto.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserModifyRequest {
        @NotBlank(message = "Id is mandatory")
        private Long id;

        @NotBlank(message = "Username is mandatory")
        private String username;

        @NotBlank(message = "Email is mandatory")
        private String email;

        @NotBlank(message = "Password is mandatory")
        private String password;
}
