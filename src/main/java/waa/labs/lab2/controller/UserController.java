package waa.labs.lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import waa.labs.lab2.domain.dto.PostDto;
import waa.labs.lab2.domain.dto.UserDto;
import waa.labs.lab2.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers(@RequestParam(name = "has-multiple-posts", required = false) boolean hasMultiplePosts) {
        return hasMultiplePosts ? userService.getUsersWithMultiplePosts() : userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") long userId) {
        return userService.getUserById(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveUser(@RequestBody UserDto newUserDto) {

        userService.saveUser(newUserDto);
    }

    @PutMapping("/{userId}")
    public void updateUser(@RequestParam long userId, @RequestBody UserDto userDto) {
        userService.updateUser(userId, userDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long userId) {
        userService.deleteUserById(userId);
    }

    @GetMapping("/{userId}/posts")
    public List<PostDto> getPostsByUser(@PathVariable long userId) {
        return userService.getPostsByUser(userId);
    }

    @PostMapping("/{userId}/posts")
    public void addPostByUser(@PathVariable long userId, @RequestBody PostDto postDto) {
        userService.savePost(userId, postDto);
    }
}
