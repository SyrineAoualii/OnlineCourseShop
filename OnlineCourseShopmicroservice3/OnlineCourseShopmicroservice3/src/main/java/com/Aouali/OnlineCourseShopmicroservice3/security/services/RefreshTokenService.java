package com.Aouali.OnlineCourseShopmicroservice3.security.services;

import com.Aouali.OnlineCourseShopmicroservice3.exception.TokenRefreshException;
import com.Aouali.OnlineCourseShopmicroservice3.model.RefreshToken;
import com.Aouali.OnlineCourseShopmicroservice3.repository.RefreshTokenRepository;
import com.Aouali.OnlineCourseShopmicroservice3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {
  @Value("${syrine.app.jwtRefreshExpirationMs}")
  private Long refreshTokenDurationMs;

  @Autowired
  private RefreshTokenRepository refreshTokenRepository;

  @Autowired
  private UserRepository userRepository;

  public Optional<RefreshToken> findByToken(String token) {
    return refreshTokenRepository.findByToken(token);
  }
  private String generateNewToken() {
    return UUID.randomUUID().toString();
  }

  // Méthode pour créer ou mettre à jour un RefreshToken
  @Transactional
  public RefreshToken createOrUpdateRefreshToken(Long userId) {
    Optional<RefreshToken> refreshTokenOptional = refreshTokenRepository.findByUser(userRepository.findById(userId).orElseThrow(
            () -> new UsernameNotFoundException("User Not Found with id: " + userId)));

    RefreshToken refreshToken = refreshTokenOptional
            .map(token -> {
              // Si un jeton existe, mettre à jour
              token.setToken(generateNewToken()); // Générer un nouveau jeton
              token.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs)); // Définir une nouvelle date d'expiration
              return token;
            })
            .orElseGet(() -> {
              // Si aucun jeton n'existe, créer un nouveau jeton d'actualisation
              RefreshToken newToken = new RefreshToken();
              newToken.setUser(userRepository.findById(userId).orElseThrow(
                      () -> new UsernameNotFoundException("User Not Found with id: " + userId)));
              newToken.setToken(generateNewToken());
              newToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
              return newToken;
            });

    // Sauvegarder le jeton d'actualisation dans la base de données
    return refreshTokenRepository.save(refreshToken);
  }


/*  public RefreshToken createRefreshToken(Long userId) {
    RefreshToken refreshToken = new RefreshToken();

    refreshToken.setUser(userRepository.findById(userId).get());
    refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
    refreshToken.setToken(UUID.randomUUID().toString());

    refreshToken = refreshTokenRepository.save(refreshToken);
    return refreshToken;
  }*/

  public RefreshToken verifyExpiration(RefreshToken token) {
    if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
      refreshTokenRepository.delete(token);
      throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
    }

    return token;
  }

  @Transactional
  public int deleteByUserId(Long userId) {
    return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
  }
}
