package challenger.nisum.java.nisum.model.abstracts;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class BaseModel {

    @Id
    public UUID uuid = UUID.randomUUID();

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    public LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "last_modified_at", updatable = false)
    @LastModifiedDate
    public LocalDateTime lastModifiedAt = LocalDateTime.now();

}
