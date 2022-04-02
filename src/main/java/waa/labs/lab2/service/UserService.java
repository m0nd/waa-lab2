package waa.labs.lab2.service;

import waa.labs.lab2.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto user);

    void updateUser(long userId, UserDto post);

    void deleteUserById(long userId);

    List<UserDto> getAllUsers();

    UserDto getUserById(long userId);

}
