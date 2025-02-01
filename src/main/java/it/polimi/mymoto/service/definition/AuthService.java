package it.polimi.mymoto.service.definition;

import it.polimi.mymoto.dto.request.UserLoginRequest;
import it.polimi.mymoto.dto.request.UserRegistrationRequest;
import it.polimi.mymoto.dto.response.LoginResponse;

public interface AuthService {
    void registerUser(UserRegistrationRequest userRegistrationRequest);
    LoginResponse authenticateUser(UserLoginRequest userLoginRequest);
}
