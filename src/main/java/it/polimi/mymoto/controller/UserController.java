package it.polimi.mymoto.controller;

import it.polimi.mymoto.dto.request.ChangePasswordRequest;
import it.polimi.mymoto.service.definition.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PatchMapping
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
    ) {
        userService.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete/{userId}")
    public ResponseEntity<?> delete(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }


}
