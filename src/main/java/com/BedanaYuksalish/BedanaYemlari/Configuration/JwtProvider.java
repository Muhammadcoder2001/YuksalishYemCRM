package com.BedanaYuksalish.BedanaYemlari.Configuration;

import com.BedanaYuksalish.BedanaYemlari.DTO.JwtDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

    private static final String secretKey = "sALOMDUUNYOYEDINGKUMENIJWTBILANhzgxfvsjdhfvsdjhfdbijkhabjhmbasjhdjhsejhdncbjhxbcdjshcbsdjhcbjhsdbcjhsdcjhsbueyjsbkjhdefwevfyuhbuyevhjadbshljchadjbvc";

    private static final Long tokenLiveTime = 8640000000L;

    @Autowired
    private UserDetailsService userDetailsService;


    public static String encode(String username, String role) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", role);

        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenLiveTime))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public static JwtDTO decode(String token) {
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        String username = claims.getSubject();
        String role = (String) claims.get("role");
        return new JwtDTO(username, role);
    }

    private static Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

//    public String createToken(String username, Authentication authentication) {
//        String roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(","));
//
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("username", username);
//        claims.put("roles", roles);
//        Date now = new Date();
//        Date exp = new Date(now.getTime()+ validity);
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(username)
//                .setIssuedAt(now)
//                .setExpiration(exp)
//                .signWith(getSignInKey())
//                .compact();
//    }

//    public boolean validateToken(String token) {
//        try {
//            Claims claims= Jwts
//                    .parserBuilder()
//                    .setSigningKey(getSignInKey())
//                    .build()
//                    .parseClaimsJws(token)
//                    .getBody();
//            if (claims.getExpiration().before(new Date())) {
//                return false;
//            }
//        }catch (JwtException e){
//            e.printStackTrace();
//        }
//        return true;
//    }

//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(extractUserName(token));
//        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//    }

//    private String getUsername(String token){
//        return Jwts.parser()
//                .verifyWith(getKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload()
//                .getSubject();
//
//    }
//    public String extractUserName(String token) {
//        // extract the username from jwt token
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimResolver.apply(claims);
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.
//                parserBuilder()
//                .setSigningKey(getSignInKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }

//    private SecretKey getKey(){
//        byte[] encodedKey = Base64.getEncoder().encode(secret.getBytes());
//        return Keys.hmacShaKeyFor(encodedKey);
//    }

}
