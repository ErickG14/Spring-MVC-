package mx.unam.aragon.ico.te.museosmvc.servicios;


import mx.unam.aragon.ico.te.museosmvc.modelos.Museo;
import mx.unam.aragon.ico.te.museosmvc.repositorios.MuseoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return museoRepository.getById(id);
    }

    //Update-> Mofifica los datos


    //Delete -> Borra info de los museos por ID

}
