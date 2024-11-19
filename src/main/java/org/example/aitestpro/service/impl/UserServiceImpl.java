package org.example.aitestpro.service.impl;

import org.example.aitestpro.converter.UserConverter;
import org.example.aitestpro.dao.UserMapper;
import org.example.aitestpro.dto.UserDTO;
import org.example.aitestpro.entity.User;
import org.example.aitestpro.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    UserConverter userConverter;

    @Override
    public UserDTO findByName(String uname) {
        User user = new User();
        user.setUsername(uname);
        User findByNameUser  = userMapper.selectOne(user);
        UserDTO userDTO = userConverter.toUserDTO(findByNameUser);

        return userDTO;
    }

    @Override
    public boolean insert(UserDTO userDto) {
        User user1 = new User();
        user1.setUsername(userDto.getUsername());
        User findByUname = userMapper.selectOne(user1);
        User user2 = new User();
        user2.setEmail(userDto.getEmail());
        User findEmail = userMapper.selectOne(user2);
        if (findByUname != null||findEmail != null) {
            System.out.println("数据库已经存在该用户");
            return false;
        }else{
            User user = userConverter.toUser(userDto);
            user.setStatus(1);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            int i = userMapper.insert(user);
            return true;
        }
    }
}
