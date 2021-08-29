package eci.ieti.app.service;

import eci.ieti.app.dto.UserDto;
import eci.ieti.app.model.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User findById(String id);

    List<User> all();

    boolean deleteById(String id);

    User update(UserDto userDto, String id);
}
