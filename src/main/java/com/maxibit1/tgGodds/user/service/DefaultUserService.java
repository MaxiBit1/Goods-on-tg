package com.maxibit1.tgGodds.user.service;

import com.maxibit1.tgGodds.user.dto.UserDto;
import com.maxibit1.tgGodds.user.dto.UserDtoWithPassword;
import com.maxibit1.tgGodds.user.entity.User;
import com.maxibit1.tgGodds.user.exception.NotFoundUser;
import com.maxibit1.tgGodds.user.mapping.UserMapper;
import com.maxibit1.tgGodds.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public void addUser(UserDtoWithPassword userDtoWithPassword) {
        log.info("Add user with name {} and email {}", userDtoWithPassword.getName(), userDtoWithPassword.getEmail());
        userRepository.save(UserMapper.toUser(userDtoWithPassword));
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserAndCheck(id);
        log.info("User delete by id {}", id);
        userRepository.delete(user);
    }

    @Override
    public UserDto getCurrentUser(Long id) {
        User user = getUserAndCheck(id);
        log.info("Get user by id {}", id);
        return UserMapper.toDto(user);
    }

    @Override
    public List<UserDto> getUsersWithoutCurrentUser(Long id) {
        User user = getUserAndCheck(id);
        log.info("Get list users without user with id {}", id);
        return userRepository.findAll().stream()
                .filter(user1 -> !user1.getId().equals(user.getId()))
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    private User getUserAndCheck(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            log.error("User not found with id {}", id);
            throw new NotFoundUser(String.join(" ", "User not found with id", String.valueOf(id)));
        }
        return user.get();
    }
}
