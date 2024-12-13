package pe.edu.cibertec.t2_daw1_juarez.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.cibertec.t2_daw1_juarez.entities.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
