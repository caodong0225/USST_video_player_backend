package top.caodong0225.videoplayer.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import top.caodong0225.videoplayer.entity.UserInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jyzxc
 * @since 2024-11-04
 */
public class JwtUtil {
    public static final String SECRET_KEY = "caodong0225";

    public static String createToken(UserInfo userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", userDetails.getId());
        claims.put("uuid", userDetails.getUuid());
        //claims.put("authorities", userDetails.getAuthorities().toString());
        return JWT.create()
                .withClaim("user", claims)
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public static boolean isTokenExpired(String token) {
        try {
            DecodedJWT decodedJwt = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
            Date expiration = decodedJwt.getExpiresAt();
            return expiration.before(new Date());
        } catch (Exception e) {
            // 如果验证过程出现异常，则认为Token无效或已过期
            return true;
        }
    }

}