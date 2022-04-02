package waa.labs.lab2.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.labs.lab2.domain.User;
import waa.labs.lab2.domain.dto.UserDto;
import waa.labs.lab2.helper.ListMapper;
import waa.labs.lab2.repo.UserRepo;
import waa.labs.lab2.service.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    UserRepo userRepo;

    private final ModelMapper modelMapper;

    private final ListMapper<User, UserDto> listMapperUserToDto;

    @Autowired
    UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper, ListMapper<User, UserDto> listMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.listMapperUserToDto = listMapper;
    }

    @Override
    public void saveUser(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public void updateUser(long userId, UserDto userDto) {
        var userToUpdate = userRepo.findById(userId).orElse(null);

        if (userToUpdate != null) {
            userToUpdate.setName(userDto.getUserName());
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
}
