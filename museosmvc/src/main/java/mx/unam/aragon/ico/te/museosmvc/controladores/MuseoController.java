package mx.unam.aragon.ico.te.museosmvc.controladores;


import mx.unam.aragon.ico.te.museosmvc.modelos.Museo;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/buscador")
public class MuseoController {
    @GetMapping("/museo")
    public String museo(Model model) {
        model.addAttribute("museo", new Museo(1,"Museo de Frida Kahlo", 1958,"Ciudad de México", "Arte",250,"http:algo"));
        return "formMuseo";
    }

    @PostMapping("/guardar") //bitacora del sistema //uso @RequestParam o si no @ModelAttribute->los nombres de los campos del formulariosean iguales a los atributos de la clase
    public String guardar(
            @ModelAttribute Museo museo
    ) {
        LoggerFactory.getLogger(getClass()).info("Guardando Museo " + museo);
        //mandarlo a DB (save) -JPA,ORM
        return "redirect:/buscador/museo?exito";
    }

}
