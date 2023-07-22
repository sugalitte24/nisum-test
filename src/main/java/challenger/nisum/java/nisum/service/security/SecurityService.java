package challenger.nisum.java.nisum.service.security;


import challenger.nisum.java.nisum.dto.security.SecurityRequest;
import challenger.nisum.java.nisum.dto.security.TokenDto;

public interface SecurityService {

    TokenDto getJWTToken( SecurityRequest request);
}
