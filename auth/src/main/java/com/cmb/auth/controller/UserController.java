package com.cmb.auth.controller;

import com.cmb.auth.pojo.form.UserRegisterForm;
import com.cmb.auth.pojo.vo.UserRegisterVo;
import com.cmb.auth.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterVo> register(@RequestBody UserRegisterForm form, HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(userService.register(form, request, response));
    }
}
