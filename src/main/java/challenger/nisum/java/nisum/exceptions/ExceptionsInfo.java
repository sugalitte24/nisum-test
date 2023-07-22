package challenger.nisum.java.nisum.exceptions;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionsInfo {

    private int statusCode;
    private String message;
}
