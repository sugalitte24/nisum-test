package challenger.nisum.java.nisum.model;

import challenger.nisum.java.nisum.model.abstracts.BaseModel;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users extends BaseModel {
    private String name;
    private String email;
    private String password;
    private Boolean isActive = true;
    private LocalDateTime lastLogin = LocalDateTime.now();


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Phones> phones;
}
