package org.example.aitestpro.controller;

import org.example.aitestpro.dto.AuthRegisterDTO;
import org.example.aitestpro.dto.AuthRequestDTO;
import org.example.aitestpro.dto.AuthResponseDTO;
import org.example.aitestpro.dto.UserDTO;
import org.example.aitestpro.security.jwt.JWTUtils;
import org.example.aitestpro.service.UserService;
import org.example.aitestpro.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.example.aitestpro.util.ResultCode.PWDWRONG;
import static org.example.aitestpro.util.ResultCode.UNREGISTER;

@RestController
public class AuthUserController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Resource
    JWTUtils jwtUtils;

    @PostMapping("/auth/login")
   public R login(@RequestBody AuthRequestDTO authRequestDTO) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword())
            );
            User user = (User)authenticate.getPrincipal();
            UserDTO userDTO = userService.findByName(user.getUsername());

            String accessToken = jwtUtils.generateAccessToken(userDTO);
            System.out.println("accesstoken--------------"+accessToken);
            AuthResponseDTO authResponseDTO = new AuthResponseDTO(userDTO.getUsername(),accessToken);

            return R.ok().data(authResponseDTO).message("登录成功");

        }catch (BadCredentialsException e){
            return R.error().code(PWDWRONG).message("用户密码错误");
        }
        catch (UsernameNotFoundException e){
            return R.error().code(UNREGISTER).message("用户未注册");
        }
    }
    @PostMapping("/auth/register")
    public R register (@RequestBody AuthRegisterDTO authRegisterDTO){
        System.out.println("注册接口："+authRegisterDTO);
        //密码的加密
        //1,创建解析器
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String pwdEncode = bCryptPasswordEncoder.encode(authRegisterDTO.getPassword());
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(authRegisterDTO.getUsername());
        userDTO.setPassword(pwdEncode);
        userDTO.setEmail(authRegisterDTO.getEmail());
        return userService.insert(userDTO)? R.ok().message("注册成功") : R.error().message("用户注册失败");

    }
}
