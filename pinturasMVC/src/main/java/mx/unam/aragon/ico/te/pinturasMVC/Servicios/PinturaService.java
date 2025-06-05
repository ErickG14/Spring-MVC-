package mx.unam.aragon.ico.te.pinturasMVC.Servicios;

import jakarta.persistence.EntityNotFoundException;
import mx.unam.aragon.ico.te.pinturasMVC.Modelo.Pintura;
import mx.unam.aragon.ico.te.pinturasMVC.Repositorio.PinturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PinturaService {
    @Autowired
    private PinturaRepository pinturaRepository;

    //Crear

    public boolean guardarCarro(Pintura pintura) {
        Pintura resultado = pinturaRepository.save(pintura);
        return resultado != null;
    }

    //Vista

    public Pintura getpintura(Integer id) {
        return pinturaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pintura con id: " + id + " no encontrado"));
    }

    public List<Pintura> getTodo() {
        return pinturaRepository.findAll();
    }

    //Actualizar
    public boolean actualizarPintura(Pintura pintura) {
        if (pinturaRepository.existsById(pintura.getId())) {
            pinturaRepository.save(pintura);
            return true;
        }
        return false;
    }

    // Borrar

    public boolean eliminarPintura(Integer id) {
        if (pinturaRepository.existsById(id)) {
            pinturaRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
