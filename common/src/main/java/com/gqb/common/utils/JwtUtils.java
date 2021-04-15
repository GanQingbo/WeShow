package com.gqb.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author GanQingbo
 * @Classname JwtUtils
 * @Description Jwt工具类
 * @date 2021/4/14 9:23
 */
public class JwtUtils {
    //token过期时间
    public static final long EXPIRE=1000*60*60;
    //密钥
    public static final String SECRET="123456aaabbbccc";

    /**
     * 生成Token
     * @param id
     * @param nickname
     * @return
     */
    public static String getJwtToken(String id,String nickname){
        String token = Jwts.builder()
                .setHeaderParam("typ", "JWT")  //固定的头部信息
                .setHeaderParam("alg","HS256")
                .setSubject("user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE)) //过期时间
                .claim("id",id) //主体部分，存储用户信息
                .claim("nickname",nickname)
                .signWith(SignatureAlgorithm.HS256,SECRET) //签名hash
                .compact();
        return token;
    }

    /**
     * 判断Token是否存在、有效
     * @param token
     * @return
     */
    public static boolean checkToken(String token){
        if(StringUtils.isEmpty(token)) return false;
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在有效
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request){
        try{
            String token = request.getHeader("token");
            if(StringUtils.isEmpty(token)) return false;
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据Token返回当前用户id
     * @param request
     * @return
     */
    public static String getUserIdByToken(HttpServletRequest request){
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        return (String)body.get("id");
    }
}
