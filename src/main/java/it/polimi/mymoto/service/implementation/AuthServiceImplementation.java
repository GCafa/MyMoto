package it.polimi.mymoto.service.implementation;

import it.polimi.mymoto.builder.implementation.UserBuilderImplementation;
import it.polimi.mymoto.dto.request.UserRegistrationRequest;
import it.polimi.mymoto.exception.UserRegistrationException;
import it.polimi.mymoto.model.Role;
import it.polimi.mymoto.model.User;
import it.polimi.mymoto.repository.UserRepository;
import it.polimi.mymoto.security.JwtService;
import it.polimi.mymoto.service.definition.AuthService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public void registerUser(@NonNull UserRegistrationRequest userRegistrationRequest) {
        if(userRepository.findByUsernameOrEmail(userRegistrationRequest.getUsername(), userRegistrationRequest.getEmail()).isPresent()) {
            throw new UserRegistrationException("Username or email already in use");
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
            throw new UserRegistrationException();
        }
    }
}
