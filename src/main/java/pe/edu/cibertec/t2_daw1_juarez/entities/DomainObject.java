package pe.edu.cibertec.t2_daw1_juarez.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass // jpa
public abstract class DomainObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    // @CreationTimestamp <= hibernate
    @CreatedDate
    LocalDateTime fechaCreacion;
    // @UpdateTimestamp
    @LastModifiedDate
    LocalDateTime fechaActualizacion;

}
