package challenger.nisum.java.nisum.dto.security;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SecurityRequest {

    @NotBlank
    private String user;

    @NotBlank
    private String password;
}
