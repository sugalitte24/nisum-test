package challenger.nisum.java.nisum.model;

import challenger.nisum.java.nisum.model.abstracts.BaseModel;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="phones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Phones extends BaseModel {

    private Long number;
    private Long cityCode;
    private Long countryCode;
}
