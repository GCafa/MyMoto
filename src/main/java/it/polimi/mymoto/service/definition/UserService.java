package it.polimi.mymoto.service.definition;

import it.polimi.mymoto.dto.request.UserModifyRequest;
import it.polimi.mymoto.dto.request.UserPasswordChangeRequest;
import it.polimi.mymoto.dto.response.CustomResponse;
import it.polimi.mymoto.model.User;
import lombok.NonNull;

import java.util.List;

public interface UserService {
    CustomResponse modify(@NonNull UserModifyRequest request);

    CustomResponse changePassword(@NonNull UserPasswordChangeRequest request);

    CustomResponse delete(@NonNull Long userId);
}
