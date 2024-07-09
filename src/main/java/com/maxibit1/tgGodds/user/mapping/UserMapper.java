package com.maxibit1.tgGodds.user.mapping;

import com.maxibit1.tgGodds.user.dto.UserDto;
import com.maxibit1.tgGodds.user.dto.UserDtoWithPassword;
import com.maxibit1.tgGodds.user.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static UserDto toDto(User user) {
        return UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static User toUser(UserDtoWithPassword userDto) {
        return User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}
