package it.polimi.mymoto.service.definition;

import it.polimi.mymoto.dto.request.UserModifyRequest;
import it.polimi.mymoto.dto.request.UserPasswordChangeRequest;
import it.polimi.mymoto.dto.response.CustomResponse;
import it.polimi.mymoto.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    CustomResponse modify(UserModifyRequest request);

    CustomResponse changePassword(UserPasswordChangeRequest request);

    CustomResponse delete(Long userId);
}
