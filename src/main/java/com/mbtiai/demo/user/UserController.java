package com.mbtiai.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public Long signup(@RequestBody UserSignUpRequestDto request){
        return userService.signUp(request);
    }

//    @PostMapping("/signUp")
//        public String signin(@RequestBody Map<String, String > user){
//        return userService.signin(user);
//    }
}
