package it.polimi.mymoto.controller;

import it.polimi.mymoto.dto.request.UserModifyRequest;
import it.polimi.mymoto.dto.request.UserPasswordChangeRequest;
import it.polimi.mymoto.dto.response.CustomResponse;
import it.polimi.mymoto.dto.response.ProductResponse;
import it.polimi.mymoto.service.definition.UserService;
import it.polimi.mymoto.util.ApiPathUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(ApiPathUtil.REST_PATH + "/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/modify")
    public ResponseEntity<CustomResponse> modify(@Valid @RequestBody UserModifyRequest userModifyRequest) {
        CustomResponse response = userService.modify(userModifyRequest);

        return ResponseEntity
                .ok(response);
    }

    @PostMapping("/change-password")
    public ResponseEntity<CustomResponse> changePassword(@Valid @RequestBody UserPasswordChangeRequest userPasswordChangeRequest) {
        CustomResponse response = userService.changePassword(userPasswordChangeRequest);

        return ResponseEntity
                .ok(response);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<CustomResponse> delete(@PathVariable Long userId) {
        CustomResponse response = userService.delete(userId);

        return ResponseEntity
                .ok(response);
    }
}
