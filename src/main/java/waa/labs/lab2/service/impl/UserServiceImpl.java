package waa.labs.lab2.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.labs.lab2.domain.Post;
import waa.labs.lab2.domain.User;
import waa.labs.lab2.domain.dto.PostDto;
import waa.labs.lab2.domain.dto.UserDto;
import waa.labs.lab2.helper.ListMapper;
import waa.labs.lab2.repo.UserRepo;
import waa.labs.lab2.service.UserService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    UserRepo userRepo;

    private final ModelMapper modelMapper;

    private final ListMapper<User, UserDto> listMapperUserToDto;
    private final ListMapper<Post, PostDto> listMapperPostToDto;

    @Autowired
    UserServiceImpl(
            UserRepo userRepo,
            ModelMapper modelMapper,
            ListMapper<User, UserDto> userListMapper,
            ListMapper<Post, PostDto> postListMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.listMapperUserToDto = userListMapper;
        this.listMapperPostToDto = postListMapper;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User newUser = new User();
        newUser.setName(userDto.getName());
        userRepo.save(newUser);
    }

    @Override
    public void savePost(long userId, PostDto postDto) {
        User desiredUser = userRepo.findById(userId).orElse(null);
        if (desiredUser != null) {
            Post newPost = new Post();
            newPost.setContent(postDto.getContent());
            newPost.setTitle(postDto.getTitle());
            desiredUser.addToPosts(newPost);
        }
    }

    @Override
    public void updateUser(long userId, UserDto userDto) {
        var userToUpdate = userRepo.findById(userId).orElse(null);

        if (userToUpdate != null) {
            userToUpdate.setName(userDto.getName());
            userRepo.save(userToUpdate);
        }
    }

    @Override
    public void deleteUserById(long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return (List<UserDto>) listMapperUserToDto.mapList(userRepo.findAll(), new UserDto());
    }

    @Override
    public UserDto getUserById(long userId) {
        return modelMapper.map(userRepo.findById(userId).orElse(null), UserDto.class) ;
    }

    @Override
    public List<PostDto> getPostsByUser(long userId) {
        var user = userRepo.findById(userId).orElse(null);
        if (user == null)
            return new ArrayList<>();
        return (List<PostDto>) listMapperPostToDto.mapList(user.getPosts(), new PostDto());
    }

    @Override
    public List<UserDto> getUsersWithMultiplePosts() {
        return (List<UserDto>) listMapperUserToDto.mapList(userRepo.findHavingMultiplePosts(), new UserDto());
    }
}
