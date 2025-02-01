package it.polimi.mymoto.service.definition;

import it.polimi.mymoto.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserByUsernameOrEmail(String username, String email);
}
