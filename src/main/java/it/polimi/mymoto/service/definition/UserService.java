package it.polimi.mymoto.service.definition;

import it.polimi.mymoto.dto.request.ChangePasswordRequest;
import it.polimi.mymoto.model.User;

import java.security.Principal;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserByUsernameOrEmail(String username, String email);

    void changePassword(ChangePasswordRequest request, Principal connectedUser);

    void delete(Long userId);
}
