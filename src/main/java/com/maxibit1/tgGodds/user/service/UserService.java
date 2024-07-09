package com.maxibit1.tgGodds.user.service;

import com.maxibit1.tgGodds.user.dto.UserDto;
import com.maxibit1.tgGodds.user.dto.UserDtoWithPassword;

import java.util.List;

public interface UserService {
    void addUser(UserDtoWithPassword userDtoWithPassword);

    void deleteUser(Long id);

    UserDto getCurrentUser(Long id);

    List<UserDto> getUsersWithoutCurrentUser(Long id);
}
