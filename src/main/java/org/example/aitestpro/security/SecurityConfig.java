package org.example.aitestpro.security;

import org.example.aitestpro.security.jwt.JwtTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import java.util.List;

//框架的相关配置
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //身份验证管理器
    @Resource
    CustomUserDetailService customUserDetailService;
    @Resource
    JwtTokenFilter jwtTokenFilter;

    //重写导入 AuthenticationManager ，给后面Controller类引用
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailService);
        auth.authenticationProvider(daoAuthenticationProvider());

    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(customUserDetailService);
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);//UserNotFoundExceptions
        return daoAuthenticationProvider;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf().disable()
                .exceptionHandling()
                .and()
                .authorizeRequests()
//                .anyRequest().permitAll(); // 所有的请求通过
                .antMatchers(HttpMethod.GET,
                        List.of(
                                        ApiPath.GetApi.values()).stream().map(postApi -> postApi.getPath()
                                )
                                .toArray(String[]::new)
                ).permitAll()
                .antMatchers(HttpMethod.POST,
                        List.of(ApiPath.PostAPi.values()
                        ).stream().map(postAPi -> postAPi.getPath()).toArray(String[]::new)
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterAt(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
