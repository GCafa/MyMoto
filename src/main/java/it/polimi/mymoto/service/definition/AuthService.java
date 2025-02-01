package it.polimi.mymoto.service.definition;

import it.polimi.mymoto.dto.request.UserRegistrationRequest;

public interface AuthService {
    void registerUser(UserRegistrationRequest userRegistrationRequest);
}
