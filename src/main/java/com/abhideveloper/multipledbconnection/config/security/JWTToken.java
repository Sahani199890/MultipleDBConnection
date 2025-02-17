package com.abhideveloper.multipledbconnection.config.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.abhideveloper.multipledbconnection.entity.mysql.UserEntity;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Configuration
public class JWTToken {

    private static final String SECRET_KEY="jIQ77P02vBRUpVl9QCFWTzwv4tqBrkD/AxxTXQZcWy60YwFzU5XO/8fPwtmCKMEK";

    public String extractAdminId(String token) {
        return extractClaim(token, Claims::getSubject );
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    public String generateToken(String email) {
        return generateToken(new HashMap<>(),email);
    }


    public String generateToken(Map<String,Object> extraClaims,
                                String email) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(email)
                .setIssuer("Abhishek Sahani Developer")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 *60 *60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    public boolean isTokenValid(String token, UserEntity userDetails) {
        final String email=extractAdminId(token);
        String validData=userDetails.getEmail();
        return (email.equals(validData)) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
        return extractExpiration(token).before(currentDate);
    }

    private java.sql.Date extractExpiration(String token) {
        return new java.sql.Date(extractClaim(token, Claims::getExpiration).getTime());
    }


    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    private Key getSignInKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}