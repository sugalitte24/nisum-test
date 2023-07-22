package challenger.nisum.java.nisum.dto.users;

import challenger.nisum.java.nisum.dto.BaseModelDto;
import challenger.nisum.java.nisum.dto.phones.PhonesDto;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto extends BaseModelDto {
    private String name;
    private String email;
    private String password;
    private Boolean isActive = true;
    private LocalDateTime lastLogin;
    private String token;
    private List<PhonesDto> phones;
}
