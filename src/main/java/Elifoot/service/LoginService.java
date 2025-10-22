package Elifoot.service;

import Elifoot.domain.Scope;
import Elifoot.domain.User;
import Elifoot.repository.UserRepository;
import Elifoot.request.LoginRequest;
import Elifoot.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;

    public LoginResponse login(LoginRequest request) {
        // 1️⃣ Buscar usuário pelo e-mail
        Optional<User> optUser = userRepository.findByEmail(request.getEmail());

        // 2️⃣ Verificar se existe e se a senha está correta
        if (optUser.isEmpty() || !isPasswordCorrect(request.getPassword(), optUser.get().getPassword())) {
            throw new BadCredentialsException("Usuário ou senha incorretos!");
        }

        // 3️⃣ Pegar o usuário e seus scopes
        User usuario = optUser.get();
        List<String> scopes = usuario.getScopes().stream()
                .map(Scope::getName)
                .toList();

        // 4️⃣ Definir tempo de expiração do token (ex: 600 segundos = 10 min)
        long expiresIn = 600L;

        // 5️⃣ Montar as informações do token (Claims)
        JwtClaimsSet jwt = JwtClaimsSet.builder()
                .issuer("elifoot-api") // Emissor do token
                .subject(usuario.getName()) // Identificação do usuário
                .expiresAt(Instant.now().plusSeconds(expiresIn))
                .issuedAt(Instant.now())
                .claim("email", usuario.getEmail())
                .claim("scope", scopes) // lista de permissões do usuário
                .build();

        // 6️⃣ Gerar o token JWT usando o JwtEncoder
        String token = jwtEncoder.encode(JwtEncoderParameters.from(jwt)).getTokenValue();

        // 7️⃣ Retornar o token e o tempo de expiração
        return new LoginResponse(token, expiresIn);
    }

    private boolean isPasswordCorrect(String password, String savedPassword) {
        return passwordEncoder.matches(password, savedPassword);
    }
}

