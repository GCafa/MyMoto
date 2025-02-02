package it.polimi.mymoto.service.implementation;

import it.polimi.mymoto.builder.implementation.UserBuilderImplementation;
import it.polimi.mymoto.dto.request.UserLoginRequest;
import it.polimi.mymoto.dto.request.UserRegistrationRequest;
import it.polimi.mymoto.dto.response.CustomResponse;
import it.polimi.mymoto.dto.response.LoginResponse;
import it.polimi.mymoto.exception.custom.EntityRegistrationException;
import it.polimi.mymoto.exception.custom.EntityNotFoundException;
import it.polimi.mymoto.model.Role;
import it.polimi.mymoto.model.User;
import it.polimi.mymoto.repository.UserRepository;
import it.polimi.mymoto.security.JwtService;
import it.polimi.mymoto.service.definition.AuthService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public CustomResponse registerUser(@NonNull UserRegistrationRequest userRegistrationRequest) {
        if(userRepository.findByUsernameOrEmail(userRegistrationRequest.getUsername(), userRegistrationRequest.getEmail()).isPresent()) {
            throw new EntityRegistrationException("Username or email already in use");
        }

        userRepository.save(
            new UserBuilderImplementation()
                .firstName(userRegistrationRequest.getFirstname())
                .lastName(userRegistrationRequest.getLastname())
                .username(userRegistrationRequest.getUsername())
                .email(userRegistrationRequest.getEmail())
                .password(passwordEncoder.encode(userRegistrationRequest.getPassword()))
                .role(Role.CUSTOMER)
                .build());

        Optional<User> registeredUser = userRepository.findByUsername(userRegistrationRequest.getUsername());

        if(registeredUser.isEmpty()) {
            throw new EntityRegistrationException(User.class);
        }

        return new CustomResponse("User registered successfully");
    }

    @Override
    public LoginResponse authenticateUser(@NonNull UserLoginRequest userLoginRequest) {
        Optional<User> user = userRepository.findByUsername(userLoginRequest.getUsername())
            .or(() -> userRepository.findByEmail(userLoginRequest.getUsername()));

        if(user.isEmpty()) {
            throw new EntityNotFoundException(User.class);
        }

        if(!passwordEncoder.matches(userLoginRequest.getPassword(), user.get().getPassword())) {
            throw new EntityRegistrationException("Invalid password");
        }

        String token = jwtService.generateToken(user.get());

        return new LoginResponse(token);
    }
}
