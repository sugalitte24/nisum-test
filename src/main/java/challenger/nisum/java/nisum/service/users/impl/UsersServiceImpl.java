package challenger.nisum.java.nisum.service.users.impl;


import challenger.nisum.java.nisum.dto.security.SecurityRequest;
import challenger.nisum.java.nisum.dto.users.UserMapper;
import challenger.nisum.java.nisum.dto.users.UsersDto;
import challenger.nisum.java.nisum.dto.users.UsersRequest;
import challenger.nisum.java.nisum.exceptions.EmailAlreadyExist;
import challenger.nisum.java.nisum.repository.UsersRepository;
import challenger.nisum.java.nisum.service.security.SecurityService;
import challenger.nisum.java.nisum.service.users.UsersService;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SecurityService securityService;


    @Override
    @Transactional
    public UsersDto create( UsersRequest usersRequest ) {
        if (validateEmail(usersRequest.getEmail())) {
            throw new EmailAlreadyExist("Email ya existe.");
        }
        usersRequest.setPassword(encodePassword(usersRequest.getPassword()));
        var userSaved = userMapper.toDtoFromModel(usersRepository.save(userMapper.toModelFromRequest(usersRequest)));
        var token = generateToken(usersRequest);
        userSaved.setToken(token);
        return userSaved;
    }

    public Boolean validateEmail( String email ) {
        return usersRepository.existsByEmail(email);
    }

    public String encodePassword( String password ) {
        return Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));

    }

    public String generateToken( UsersRequest usersRequest ) {
        SecurityRequest securityRequest = new SecurityRequest(usersRequest.getEmail(), usersRequest.getPassword());
        var token = securityService.getJWTToken(securityRequest);
        return token.getToken();
    }

}
