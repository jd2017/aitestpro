package org.example.aitestpro.security;

import org.example.aitestpro.dto.UserDTO;
import org.example.aitestpro.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Resource
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO findUser = userService.findByName(username);
        System.out.println("user:"+findUser);
        if (findUser == null) {
            throw new UsernameNotFoundException("未查找到该用户："+"username not found");
        }
        Collection<? extends GrantedAuthority> authorities= new ArrayList<>();
        //String username, String password, boolean enabled, boolean accountNonExpired,
        //			boolean credentialsNonExpired, boolean accountNonLocked,
        //			Collection<? extends GrantedAuthority> authorities) {
        //        这个User 为框架中的类
        UserDetails userDetails = new User(username,
                "{bcrypt}" +findUser.getPassword(),
                true,
                true,
                true,
                true,
                authorities
        );
        return userDetails;
    }
}
