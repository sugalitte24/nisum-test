package challenger.nisum.java.nisum.controller;


import challenger.nisum.java.nisum.dto.users.UsersDto;
import challenger.nisum.java.nisum.dto.users.UsersRequest;
import challenger.nisum.java.nisum.service.users.UsersService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/nisum/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/create")
    public ResponseEntity<UsersDto> createUser( @RequestBody @Valid UsersRequest usersRequest ) {
        return new ResponseEntity<>(usersService.create(usersRequest), HttpStatus.CREATED);
    }


}
