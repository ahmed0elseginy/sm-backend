package zag.library.security.core.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import zag.library.security.api.service.JWTService;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JWTServiceImpl implements JWTService {
    private final SecretKey secretKey;
    private final Long EXPIRATION_TIME = 24L * 3600 * 1000;

    @Override
    public String generateToken(String username, Map<String, Object> claims) {
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder().claims().add(claims)
                .subject(username)
                .issuedAt(new Date(currentTimeMillis))
                .expiration(new Date(currentTimeMillis + EXPIRATION_TIME))
                .and().signWith(secretKey).compact();
    }

    @Override
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public Object extractClaim(String token, String key) {
        final Claims claims = extractAllClaims(token);
        return claims.get(key);
    }

    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
