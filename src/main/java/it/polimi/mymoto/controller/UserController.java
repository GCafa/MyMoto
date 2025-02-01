package it.polimi.mymoto.controller;

import it.polimi.mymoto.service.definition.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

}
