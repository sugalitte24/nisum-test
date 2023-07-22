package challenger.nisum.java.nisum.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailAlreadyExist extends RuntimeException {
    private String message;

    public EmailAlreadyExist( String msg ) {
        super(msg);
        this.message = msg;
    }
}
