package mx.unam.aragon.ico.te.museosmvc.repositorios;

import mx.unam.aragon.ico.te.museosmvc.modelos.Museo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuseoRepository extends JpaRepository<Museo, Integer> {
    
}
