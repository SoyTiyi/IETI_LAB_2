package eci.ieti.app.service;

import eci.ieti.app.dto.UserDto;
import eci.ieti.app.model.User;
import eci.ieti.app.repository.UserDocument;
import eci.ieti.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<UserDocument> optionalUserDocument = userRepository.findById(id);
        UserDocument userDocument = optionalUserDocument.get();
        User user = new User(userDocument.getId(), userDocument.getName(), userDocument.getEmail(), userDocument.getLastName(), userDocument.getCreatedAt());
        return user;

    }

    @Override
    public List<User> all()
    {
        List<UserDocument> listUserDocument = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        for(UserDocument userDocument: listUserDocument){
            User tempUser = new User(userDocument.getId(), userDocument.getName(), userDocument.getEmail(),userDocument.getLastName(), userDocument.getCreatedAt());
            userList.add(tempUser);
        }
        return userList;
    }

    @Override
    public boolean deleteById(String id)
    {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User update(UserDto userDto, String id)
    {
        UserDocument userDocument = userRepository.findById(id).get();
        userRepository.deleteById(id);
        userDocument.setName(userDto.getName());
        userDocument.setEmail(userDto.getEmail());
        userDocument.setLastName(userDto.getLastName());
        //System.out.println(userDocument.getLastName());
        userRepository.save(userDocument);
        return new User(userDocument.getId(),userDocument.getName(),userDocument.getEmail(),userDocument.getLastName(),userDocument.getCreatedAt());
    }
}
