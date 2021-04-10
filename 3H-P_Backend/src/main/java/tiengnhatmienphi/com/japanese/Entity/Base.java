package tiengnhatmienphi.com.japanese.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private Date updatedAt;
}
