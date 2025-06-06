package mx.unam.aragon.ico.te.Planetas.del.sistema.solar.sericicios;


import jakarta.persistence.EntityNotFoundException;
import mx.unam.aragon.ico.te.Planetas.del.sistema.solar.modelos.Planeta;
import mx.unam.aragon.ico.te.Planetas.del.sistema.solar.repositorios.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository planetaRepository;

    public boolean guardarplaneta(Planeta planeta) {
        Planeta reult = planetaRepository.save(planeta);
        return reult != null;
    }

    public Planeta getplaneta(Integer id) {
        return planetaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Planeta con ID " + id + " no encontrado"));
    }

    public List<Planeta> getTodosLosplanetas() {
        return planetaRepository.findAll();
    }

    public boolean actualizarplaneta(Planeta planeta) {
        if (planetaRepository.existsById(planeta.getId())) {
            planetaRepository.save(planeta);
            return true;
        }
        return false;
    }

    public boolean eliminarplaneta(Integer id) {
        if (planetaRepository.existsById(id)) {
            planetaRepository.deleteById(id);
            return true;
        }
        return false;
    }




}


