package mx.unam.aragon.ico.te.museosmvc.controladores;

import jakarta.persistence.EntityNotFoundException;
import mx.unam.aragon.ico.te.museosmvc.modelos.Museo;
import mx.unam.aragon.ico.te.museosmvc.servicios.MuseoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/buscador")
public class MuseoController {
    @Autowired
    private MuseoService museoService; //importo el servicio, para tener acceso a los métodos como "guardar"

    //CREATE
    @GetMapping("/museo")
    public String museos(Model model) {
        model.addAttribute("museo", new Museo());
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
                model.addAttribute("error", "No se encontró un museo con ID " + id);
            }
        }
        return "VerMuseo";
    }

    @GetMapping("/buscarTodos")
    public String mostrarTodosLosMuseos(Model model) {
        List<Museo> museos = museoService.getTodosLosMuseos();
        model.addAttribute("todosLosMuseos", museos);
        return "VerMuseo";
    }

    //UPDATE
    @GetMapping("/editar")
    public String editar(@RequestParam(name = "id", required = false) Integer id, Model model) {
        model.addAttribute("museos", museoService.getTodosLosMuseos());
        if (id != null) {
            model.addAttribute("museo", museoService.getMuseo(id));
        } else {
            model.addAttribute("museo", null); // Oculta el formulario si no se selecciono el museo
        }
        return "EditarMuseo";
    }
    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Museo museo) {
        LoggerFactory.getLogger(getClass()).info("Se actualizo el museo  'id': " + museo.getId());
        LoggerFactory.getLogger(getClass()).info("Info guardada: " + museo);
        museoService.actualizarMuseo(museo);
        return "redirect:/buscador/editar?exito&id=" + museo.getId();
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
