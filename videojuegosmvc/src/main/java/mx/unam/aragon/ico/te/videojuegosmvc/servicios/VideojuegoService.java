package mx.unam.aragon.ico.te.videojuegosmvc.servicios;

import jakarta.persistence.EntityNotFoundException;
import mx.unam.aragon.ico.te.videojuegosmvc.modelos.Videojuego;
import mx.unam.aragon.ico.te.videojuegosmvc.repositorios.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideojuegoService {
    @Autowired
    private VideojuegoRepository videojuegoRepository;

    public boolean guardarVideojuego(Videojuego videojuego) {
        Videojuego reult = videojuegoRepository.save(videojuego);
        return reult != null;
    }

    public Videojuego getVideojuego(Integer id) {
        return videojuegoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Videojuego con ID " + id + " no encontrado"));
    }

    public List<Videojuego> getTodosLosVideojuegos() {
        return videojuegoRepository.findAll();
    }

    public boolean actualizarVideojuego(Videojuego videojuego) {
        if (videojuegoRepository.existsById(videojuego.getId())) {
            videojuegoRepository.save(videojuego);
            return true;
        }
        return false;
    }

    public boolean eliminarVideojuego(Integer id) {
        if (videojuegoRepository.existsById(id)) {
            videojuegoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
