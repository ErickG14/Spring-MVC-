package mx.unam.aragon.ico.te.pf.peliculasmvc.servicios;

import jakarta.persistence.EntityNotFoundException;
import mx.unam.aragon.ico.te.pf.peliculasmvc.modelos.Pelicula;
import mx.unam.aragon.ico.te.pf.peliculasmvc.repositorios.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    public boolean guardarPelicula(Pelicula pelicula) {
        Pelicula reult = peliculaRepository.save(pelicula);
        return reult != null;
    }

    public Pelicula getPelicula(Integer id) {
        return peliculaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pelicula con ID " + id + " no encontrada"));
    }

    public List<Pelicula> getTodosLasPeliculas() {
        return peliculaRepository.findAll();
    }

    public boolean actualizarPelicula(Pelicula pelicula) {
        if (peliculaRepository.existsById(pelicula.getId())) {
            peliculaRepository.save(pelicula);
            return true;
        }
        return false;
    }

    public boolean eliminarPelicula(Integer id) {
        if (peliculaRepository.existsById(id)) {
            peliculaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
