package mx.unam.aragon.ico.te.videojuegosmvc.repositorios;

import mx.unam.aragon.ico.te.videojuegosmvc.modelos.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {
}
