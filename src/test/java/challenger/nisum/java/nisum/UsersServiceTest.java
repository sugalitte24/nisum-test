package challenger.nisum.java.nisum;

import challenger.nisum.java.nisum.dto.phones.PhonesDto;
import challenger.nisum.java.nisum.dto.security.TokenDto;
import challenger.nisum.java.nisum.dto.users.UserMapper;
import challenger.nisum.java.nisum.dto.users.UsersDto;
import challenger.nisum.java.nisum.dto.users.UsersRequest;
import challenger.nisum.java.nisum.exceptions.EmailAlreadyExist;
import challenger.nisum.java.nisum.model.Phones;
import challenger.nisum.java.nisum.model.Users;
import challenger.nisum.java.nisum.repository.UsersRepository;
import challenger.nisum.java.nisum.service.security.impl.SecurityServiceImpl;
import challenger.nisum.java.nisum.service.users.impl.UsersServiceImpl;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UsersServiceTest {

    @InjectMocks
    UsersServiceImpl usersService;

    @Mock
    UsersRepository usersRepository;

    @Mock
    UserMapper userMapper;

    @Mock
    SecurityServiceImpl securityService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createUser() {
        var phonesRequest = List.of(new PhonesDto(123L, 2222L, 4444L));
        var phonesRequestEntity = List.of(new Phones(123L, 2222L, 4444L));
        var request = new UsersRequest("name", "test@test.com", "password.123", phonesRequest, true);
        var requestDto = new UsersDto("name", "test@test.com", "password.123", true, LocalDateTime.now(), "dd4s74s74s5", phonesRequest);
        var responseEntity = new Users("name", "test@test.com", "password.123", true, LocalDateTime.now(), phonesRequestEntity);
        var tokenDto = new TokenDto("token1123", new Date(), new Date(), "bearer");
        Mockito.when(usersRepository.existsByEmail(request.getEmail())).thenReturn(false);
        Mockito.when(userMapper.toDtoFromModel(responseEntity)).thenReturn(requestDto);
        Mockito.when(userMapper.toModelFromRequest(request)).thenReturn(responseEntity);
        Mockito.when(usersRepository.save(responseEntity)).thenReturn(responseEntity);
        Mockito.when(securityService.getJWTToken(any())).thenReturn(tokenDto);

        this.usersService.create(request);
    }

    @Test
    public void createUserEmailExist() {
        var phonesRequest = List.of(new PhonesDto(123L, 2222L, 4444L));
        var request = new UsersRequest("name", "test@test.com", "password.123", phonesRequest, true);
        Mockito.when(usersRepository.existsByEmail(request.getEmail())).thenReturn(true);

        Assertions.assertThrows(EmailAlreadyExist.class, () -> this.usersService.create(request), "mail ya existe.");

    }
}
