package mx.unam.aragon.ico.te.museosmvc.controladores;

import jakarta.persistence.EntityNotFoundException;
import mx.unam.aragon.ico.te.museosmvc.modelos.Museo;
import mx.unam.aragon.ico.te.museosmvc.servicios.MuseoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/buscador")
public class MuseoController {
    @Autowired
    private MuseoService museoService; //importo el servicio, para tener acceso a los métodos como "guardar"

    //CREATE
    @GetMapping("/museo")
    public String museos(Model model) {
        model.addAttribute("museo", new Museo(1,"Museo de Frida Kahlo", 1958,"Ciudad de México", "Arte",250,"http:algo"));
        return "formMuseo";
    }
    @PostMapping("/guardar") //bitacora del sistema //uso @RequestParam o si no @ModelAttribute->los nombres de los campos del formulariosean iguales a los atributos de la clase
    public String guardar(
            @ModelAttribute Museo museo
    ) {
        LoggerFactory.getLogger(getClass()).info("Guardando Museo " + museo);
        //mandarlo a DB (save) -JPA,ORM
        museoService.guardarMuseo(museo); //guardo al muso que estoy recuperando
        return "redirect:/buscador/museo?exito";
    }

    //READ
    @GetMapping("/buscar")
    public String museo(@RequestParam(required = false) Integer id, Model model) {
        if (id != null) {
            try {
                model.addAttribute("museoBuscado",museoService.getMuseo(id) );
            } catch (EntityNotFoundException e) {
                model.addAttribute("error", "No se encontró el museo con ID " + id);
            }
        }
        return "VerMuseo";
    }

    //UPDATE
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        LoggerFactory.getLogger(getClass()).info("Se edito el museo 'id': " + id);
        model.addAttribute("museo",museoService.getMuseo(id) );
        return "EditarMuseo";
    }
    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Museo museo) {
        LoggerFactory.getLogger(getClass()).info("Se actualizo el museo  'id': " + museo.getId());
        LoggerFactory.getLogger(getClass()).info("Info guardada: " + museo);
        museoService.actualizarMuseo(museo);
        return "redirect:/buscador/editar/" + museo.getId() + "?exito";
    }

    //DELETE
    @GetMapping("/eliminar")
    public String Formeliminar(Model model) {
        model.addAttribute("museos", museoService.getTodosLosMuseos());
        return "EliminarMuseo";
    }
    @PostMapping("/delete")
    public String eliminar(@RequestParam Integer id) {
        boolean eliminado = museoService.eliminarMuseo(id);
        if (eliminado) {
            return "redirect:/buscador/eliminar?eliminado=true";
        } else {
            return "redirect:/buscador/eliminar?error=notfound";
        }
    }
}
