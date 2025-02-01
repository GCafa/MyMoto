package it.polimi.mymoto.controller;

import it.polimi.mymoto.dto.request.UserRegistrationRequest;
import it.polimi.mymoto.dto.response.CustomResponse;
import it.polimi.mymoto.service.definition.AuthService;
import it.polimi.mymoto.util.ApiPathUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPathUtil.REST_PATH + "/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<CustomResponse> register(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        authenticationService.registerUser(userRegistrationRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new CustomResponse("Registration completed!"));
    }
}
