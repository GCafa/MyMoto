package it.polimi.mymoto.service.implementation;

import it.polimi.mymoto.dto.request.UserModifyRequest;
import it.polimi.mymoto.dto.request.UserPasswordChangeRequest;
import it.polimi.mymoto.dto.response.CustomResponse;
import it.polimi.mymoto.exception.custom.UserNotFoundException;
import it.polimi.mymoto.model.User;
import it.polimi.mymoto.repository.UserRepository;
import it.polimi.mymoto.service.definition.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public CustomResponse modify(@NonNull UserModifyRequest userModifyRequest) {
        Optional<User> user = userRepository.findById(userModifyRequest.getId());

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        if (!passwordEncoder.matches(userModifyRequest.getPassword(), user.get().getPassword())) {
            return new CustomResponse("The password inserted is not correct");
        }

        User modifiedUser = user.get();
        modifiedUser.setUsername(userModifyRequest.getUsername());
        modifiedUser.setEmail(userModifyRequest.getEmail());

        try {
            userRepository.save(modifiedUser);
        } catch (Exception e) {
            return new CustomResponse("Error modifying user");
        }

        return new CustomResponse("User modified successfully");
    }

    @Override
    public CustomResponse changePassword(@NonNull UserPasswordChangeRequest userPasswordChangeRequest) {
        Optional<User> user = userRepository.findById(userPasswordChangeRequest.getId());

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        if (!passwordEncoder.matches(userPasswordChangeRequest.getCurrentPassword(), user.get().getPassword())) {
            return new CustomResponse("The old password is not correct");
        }

        User modifiedUser = user.get();

        if (!userPasswordChangeRequest.getNewPassword().equals(userPasswordChangeRequest.getRepeatNewPassword())) {
            return new CustomResponse("The passwords do not match");
        }

        modifiedUser.setPassword(passwordEncoder.encode(userPasswordChangeRequest.getNewPassword()));

        try {
            userRepository.save(modifiedUser);
        } catch (Exception e) {
            return new CustomResponse("Error changing password");
        }

        return new CustomResponse("Password changed successfully");
    }

    @Override
    public CustomResponse delete(@NonNull Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        try {
            userRepository.delete(user.get());
        } catch (Exception e) {
            return new CustomResponse("Error deleting user");
        }

        return new CustomResponse("User deleted successfully");
    }
}
