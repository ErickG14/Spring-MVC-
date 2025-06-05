package mx.unam.aragon.ico.te.pf.peliculasmvc.repositorios;

import mx.unam.aragon.ico.te.pf.peliculasmvc.modelos.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
}
