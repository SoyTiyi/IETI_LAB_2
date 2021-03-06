package eci.ieti.app.model;

import eci.ieti.app.dto.UserDto;

import java.util.Date;
import java.util.UUID;

public class User {
    String id;

    String name;

    String email;

    String lastName;

    Date createdAt;


    public User( UserDto userDto )
    {
        id = UUID.randomUUID().toString();
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        createdAt = new Date();
    }

    public User(String id, String name, String email,String lastName, Date createdAt){
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.createdAt = createdAt;
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public String getEmail() { return email; }

    public String getLastName() { return lastName; }

    public Date getCreatedAt() { return  createdAt; }

    public void update( UserDto userDto )
    {
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
    }
}
