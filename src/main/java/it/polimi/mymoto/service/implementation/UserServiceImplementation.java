package it.polimi.mymoto.service.implementation;

import it.polimi.mymoto.dto.request.UserModifyRequest;
import it.polimi.mymoto.dto.request.UserPasswordChangeRequest;
import it.polimi.mymoto.dto.response.CustomResponse;
import it.polimi.mymoto.exception.custom.DataValidationException;
import it.polimi.mymoto.exception.custom.EntityModifyException;
import it.polimi.mymoto.exception.custom.EntityNotFoundException;
import it.polimi.mymoto.model.User;
import it.polimi.mymoto.repository.UserRepository;
import it.polimi.mymoto.service.definition.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public CustomResponse modify(@NonNull UserModifyRequest userModifyRequest) {
        Optional<User> user = userRepository.findById(userModifyRequest.getId());

        if (user.isEmpty()) {
            throw new EntityNotFoundException(User.class);
        }

        if (!passwordEncoder.matches(userModifyRequest.getPassword(), user.get().getPassword())) {
            throw new DataValidationException("The password inserted is not correct");
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
            throw new EntityNotFoundException(User.class);
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
            throw new EntityModifyException(User.class);
        }

        return new CustomResponse("Password changed successfully");
    }

    @Override
    public CustomResponse delete(@NonNull Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            throw new EntityNotFoundException(User.class);
        }

        try {
            userRepository.delete(user.get());
        } catch (Exception e) {
            throw new EntityNotFoundException(User.class);
        }

        return new CustomResponse("User deleted successfully");
    }

    @Override
    public User getCurrentUser() {
        return userRepository.findByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName()
        ).orElseThrow(() -> new EntityNotFoundException(User.class));
    }
}
