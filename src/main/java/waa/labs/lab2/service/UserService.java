package waa.labs.lab2.service;

import waa.labs.lab2.domain.dto.PostDto;
import waa.labs.lab2.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserById(long userId);

    void saveUser(UserDto user);

    void savePost(long userId, PostDto post);

    void updateUser(long userId, UserDto post);

    void deleteUserById(long userId);

    List<PostDto> getPostsByUser(long userId);

    List<UserDto> getUsersWithMultiplePosts();
}
