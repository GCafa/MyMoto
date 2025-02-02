package it.polimi.mymoto.controller;

import it.polimi.mymoto.dto.request.UserLoginRequest;
import it.polimi.mymoto.dto.request.UserRegistrationRequest;
import it.polimi.mymoto.dto.response.CustomResponse;
import it.polimi.mymoto.dto.response.LoginResponse;
import it.polimi.mymoto.service.definition.AuthService;
import it.polimi.mymoto.util.ApiPathUtil;
import jakarta.validation.Valid;
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
    public ResponseEntity<CustomResponse> register(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {
        final CustomResponse response = authenticationService.registerUser(userRegistrationRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@Valid @RequestBody UserLoginRequest userLoginRequest) {
        final LoginResponse response = authenticationService.authenticateUser(userLoginRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
