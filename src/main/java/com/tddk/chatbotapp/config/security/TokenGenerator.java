package com.tddk.chatbotapp.config.security;

import com.tddk.chatbotapp.dto.res.TokenRes;
import com.tddk.chatbotapp.enums.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class TokenGenerator {
    private final JwtEncoder encoder;
    public TokenRes generateTokens(Authentication authentication) {
        Instant now = Instant.now();
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet accClaims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        JwtClaimsSet refClaims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.DAYS))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        var accParameters = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS512).build(), accClaims);
        var refParameters = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS512).build(), refClaims);
        String accToken = encoder.encode(accParameters).getTokenValue();
        String refToken = encoder.encode(refParameters).getTokenValue();
        return TokenRes.builder()
                .accessToken(accToken)
                .refreshToken(refToken)
                .tokenType(TokenType.Bearer)
                .accessTokenExpiry(now.getNano())
                .build();
    }
}
