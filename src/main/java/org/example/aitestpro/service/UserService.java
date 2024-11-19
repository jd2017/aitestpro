package org.example.aitestpro.service;

import org.example.aitestpro.dto.UserDTO;

public interface UserService {
    UserDTO findByName(String uname);
    boolean insert(UserDTO userDto);
}
