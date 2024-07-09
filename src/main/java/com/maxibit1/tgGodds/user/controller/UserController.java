package com.maxibit1.tgGodds.user.controller;

import com.maxibit1.tgGodds.user.dto.UserDto;
import com.maxibit1.tgGodds.user.dto.UserDtoWithPassword;
import com.maxibit1.tgGodds.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserDtoWithPassword userDtoWithPassword) {
        userService.addUser(userDtoWithPassword);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getCurrentUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getCurrentUser(id), HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<UserDto>> getUsersList(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUsersWithoutCurrentUser(id), HttpStatus.OK);
    }


}
