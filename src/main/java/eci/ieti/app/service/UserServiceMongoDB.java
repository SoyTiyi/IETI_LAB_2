package eci.ieti.app.service;

import eci.ieti.app.dto.UserDto;
import eci.ieti.app.model.User;
import eci.ieti.app.repository.UserDocument;
import eci.ieti.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceMongoDB implements UserService{

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user)
    {
        UserDocument userDocument =  new UserDocument(user.getId(), user.getName(), user.getEmail(), user.getLastName(), user.getCreatedAt());
        userRepository.save(userDocument);
        return user;
    }

    @Override
    public User findById(String id)
    {
        return null;
    }

    @Override
    public List<User> all()
    {
        return null;
    }

    @Override
    public boolean deleteById(String id)
    {
        return false;
    }

    @Override
    public User update(UserDto userDto, String id)
    {
        return null;
    }
}
