package challenger.nisum.java.nisum.dto.phones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhonesDto {
    private Long number;
    private Long cityCode;
    private Long countryCode;
}
