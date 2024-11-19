package org.example.aitestpro.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClaims;
import org.apache.logging.log4j.Logger;
import org.example.aitestpro.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.lang.invoke.MethodHandles.lookup;
import static org.apache.logging.log4j.LogManager.getLogger;

//jwt生成token工具类
@Component
public class JWTUtils {
    static final Logger logger = getLogger(lookup().lookupClass());
    private static final String BASE_SECRET_STRING = "asdfghjkl";

    private static final String TOKEN_ISSUER = "aitestpro";
    private static final Long EXPIRE_DURATION = TimeUnit.HOURS.toMillis(2);//2个小时
    public String generateAccessToken(UserDTO userDto) {
        final Claims claims = new DefaultClaims();
        claims.put("uname", userDto.getUsername());
        claims.put("email", userDto.getEmail());
        claims.put("good", "ij7c8384" + userDto.getPassword() + "0dffds343d");
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer(TOKEN_ISSUER)
                .setSubject(userDto.getId() + ","+ userDto.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))//签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))//token过期时间
                .signWith(SignatureAlgorithm.HS256, BASE_SECRET_STRING)
                .compact();
    }
    //解析token 是否正确
    public boolean validateAccessToken(String accessToken){
        try {
            Jwts.parser()
                    .setSigningKey(BASE_SECRET_STRING)
                    .parseClaimsJws(accessToken)
                    .getBody();
            return true;
        }catch (ExpiredJwtException e){
            logger.error("JWT解析异常：",e);

        }catch (IllegalArgumentException e){
            logger.error("token为空：",e);

        }catch (MalformedJwtException e){
            logger.error("JWT令牌无效：",e);

        }catch (UnsupportedJwtException e){
            logger.error("不支持JWT令牌：",e);

        }catch (SignatureException e){
            logger.error("签名无效：",e);

        }
        return false;
    }
    public String getSubject(String accessToken){
        return Jwts.parser()
                .setSigningKey(BASE_SECRET_STRING)
                .parseClaimsJws(accessToken)
                .getBody().getSubject();
    }
}
