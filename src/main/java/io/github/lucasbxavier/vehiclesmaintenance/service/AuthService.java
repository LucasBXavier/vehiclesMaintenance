package io.github.lucasbxavier.vehiclesmaintenance.service;

import io.github.lucasbxavier.vehiclesmaintenance.dto.LoginRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private AuthenticationManager authenticationManager;

    public void authenticate(LoginRequestDTO dto){
        var authToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
        authenticationManager.authenticate(authToken);
    }
}
