package challenger.nisum.java.nisum.service.security.impl;


import challenger.nisum.java.nisum.dto.security.SecurityRequest;
import challenger.nisum.java.nisum.dto.security.TokenDto;
import challenger.nisum.java.nisum.model.Users;
import challenger.nisum.java.nisum.repository.UsersRepository;
import challenger.nisum.java.nisum.service.security.SecurityService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Value("${security.jwt.secret}")
    private String SECRET;
    @Autowired
    private UsersRepository usersRepository;


    public Optional<Users> getUser( String email, String password ) {
        return usersRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public TokenDto getJWTToken( SecurityRequest request ) {

        final Instant now = Instant.now();
        TokenDto tokenDto = new TokenDto();
        var userFind = getUser(request.getUser(), request.getPassword());

        if (userFind.isPresent()) {

            String token = Jwts
                    .builder()
                    .setId("nisumJWT")
                    .setSubject(request.getUser())
                    .claim("authorities",
                            "ROLE_USER")
                    .setIssuedAt(Date.from(now))
                    .setExpiration(Date.from(now.plus(1, ChronoUnit.DAYS)))
                    .signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();

            tokenDto.setToken("Bearer " + token);
            tokenDto.setStartDate(Date.from(now));
            tokenDto.setExpirationDate(Date.from(now.plus(1, ChronoUnit.DAYS)));
            tokenDto.setTypeToken("Bearer");
            return tokenDto;
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
}
