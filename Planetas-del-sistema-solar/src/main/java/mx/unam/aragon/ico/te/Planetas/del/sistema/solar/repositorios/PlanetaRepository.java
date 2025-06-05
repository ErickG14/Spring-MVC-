package mx.unam.aragon.ico.te.Planetas.del.sistema.solar.repositorios;

import mx.unam.aragon.ico.te.Planetas.del.sistema.solar.modelos.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlanetaRepository extends JpaRepository<Planeta, Integer> {

}