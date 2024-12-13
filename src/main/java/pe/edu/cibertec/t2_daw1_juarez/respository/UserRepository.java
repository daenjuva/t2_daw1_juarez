package pe.edu.cibertec.t2_daw1_juarez.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.t2_daw1_juarez.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // buscar por nombre

    // findByAtributo => select * from where name = ?
    Optional<User> findByName(String name);
}