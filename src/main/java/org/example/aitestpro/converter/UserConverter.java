package org.example.aitestpro.converter;

import org.example.aitestpro.dto.UserDTO;
import org.example.aitestpro.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserConverter {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "username", source = "username"),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "status", source = "status"),
    })
    public User toUser(UserDTO userDTO);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "username", source = "username"),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "status", source = "status"),
    })
    public UserDTO toUserDTO(User user);
}
