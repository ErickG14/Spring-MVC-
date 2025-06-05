package mx.unam.aragon.ico.te.museosmvc.repositorios;

import mx.unam.aragon.ico.te.museosmvc.modelos.Museo;
import org.springframework.data.jpa.repository.JpaRepository;

//Esta interfaz hereda de JPA Y maneja obj. de tipo museo, con esto se tiene acceso
// a todas a los operaciones DML para la tabla
public interface MuseoRepository extends JpaRepository<Museo, Integer> {

}
