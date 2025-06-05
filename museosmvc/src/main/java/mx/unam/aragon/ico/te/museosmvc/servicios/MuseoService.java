package mx.unam.aragon.ico.te.museosmvc.servicios;


import jakarta.persistence.EntityNotFoundException;
import mx.unam.aragon.ico.te.museosmvc.modelos.Museo;
import mx.unam.aragon.ico.te.museosmvc.repositorios.MuseoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Servicios esta capa realiza todas las operaciones de la lógica de negocios
@Service
public class MuseoService {
    @Autowired //Inyecto la dependencia
    private MuseoRepository museoRepository;

    //Create -> Guarda los nuevos museos y regresa el mensaje
    public boolean guardarMuseo(Museo museo) {
        Museo reult = museoRepository.save(museo);
        return reult != null;  //tambien me puede regresar el objeto creado, o el true false
    }

    //Read--> Se visualiza en una página nueva la info almacenada en la base de datos (busqueda por ID)
    public Museo getMuseo(Integer id) {
        return museoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Museo con ID " + id + " no encontrado"));
    }
    public List<Museo> getTodosLosMuseos() {
        return museoRepository.findAll();
    }

    //Update-> Mofifica los datos
    public boolean actualizarMuseo(Museo museo) {
        if (museoRepository.existsById(museo.getId())) {
            museoRepository.save(museo);
            return true;
        }
        return false;
    }

    //Delete -> Borra info de los museos por ID
    public boolean eliminarMuseo(Integer id) {
        if (museoRepository.existsById(id)) {
            museoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
