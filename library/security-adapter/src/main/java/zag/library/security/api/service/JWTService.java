package zag.library.security.api.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTService {
    String generateToken(String username, Map<String, Object> claims);

    String extractUserName(String token);

    Object extractClaim(String token, String key);

    Boolean validateToken(String token, UserDetails userDetails);

}
