package com.xjh.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Map;

/**
 * JWT工具类
 * 作用：1. 生成令牌 (盖章)
 *       2. 解析令牌 (验章)
 * @author Ballauma
 */
public class JwtUtils {

    // 🔑 私钥 (Signature Key)
    // 这就是你的“银行金库密码”，绝对不能泄露给前端！
    // 只有拥有这个 Key，才能生成合法的 Token，或者校验 Token 是否被篡改。
    // 在真实项目中，这个 key 应该写在 application.yml 里，或者搞得超级复杂。
    private static String signKey = "TliasBallaumaSecretKey66666666666666666666666666666666666666";
    
    // ⏳ 过期时间
    // 这里设为 12小时 (12 * 60 * 60 * 1000 毫秒)
    // 意思是：用户登录一次，12小时内不用再登录。
    private static Long expire = 43200000L;

    /**
     * 生成 JWT 令牌
     * @param claims 载荷 (要存进令牌里的数据，比如 id, username)
     * @return String 生成的加密字符串
     */
    public static String generateJwt(Map<String, Object> claims){
        return Jwts.builder()
                // 1. 塞数据 (Payload)
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey) // 2. 盖章加密 (Signature)
                .setExpiration(new Date(System.currentTimeMillis() + expire)) // 3. 设有效期
                .compact(); // 4. 压缩成字符串
    }

    /**
     * 解析 JWT 令牌
     * @param jwt 前端传来的 Token 字符串
     * @return Claims 解析出来的数据 (如果解析失败或过期，会抛出异常)
     */
    public static Claims parseJWT(String jwt){
        return Jwts.parser()
                .setSigningKey(signKey) // 必须用同一把钥匙去验
                .parseClaimsJws(jwt)
                .getBody();
    }
}