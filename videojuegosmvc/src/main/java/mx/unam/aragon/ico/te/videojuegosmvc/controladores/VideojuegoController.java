package mx.unam.aragon.ico.te.videojuegosmvc.controladores;

import jakarta.persistence.EntityNotFoundException;
import mx.unam.aragon.ico.te.videojuegosmvc.servicios.VideojuegoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import mx.unam.aragon.ico.te.videojuegosmvc.modelos.Videojuego;


@Controller
@RequestMapping("/buscador")
public class VideojuegoController {
    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping("/videojuego")
    public String videojuegos(Model model) {
        model.addAttribute("videojuego", new Videojuego());
        return "FormVideojuego";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Videojuego videojuego) {
        LoggerFactory.getLogger(getClass()).info("Guardando Videojuego " + videojuego);
        videojuegoService.guardarVideojuego(videojuego);
        return "redirect:/buscador/videojuego?exito";
    }

    @GetMapping("/buscar")
    public String videojuego(@RequestParam(required = false) Integer id, Model model) {
        if (id != null) {
            try {
                model.addAttribute("videojuegoBuscado",videojuegoService.getVideojuego(id) );
            } catch (EntityNotFoundException e) {
                model.addAttribute("error", "No se encontró un videojuego con ID " + id);
            }
        }
        return "VerVideojuego";
    }

    @GetMapping("/buscarTodos")
    public String mostrarTodosLosVideojuegos(Model model) {
        List<Videojuego> videojuegos = videojuegoService.getTodosLosVideojuegos();
        model.addAttribute("todosLosVideojuegos", videojuegos);
        return "VerVideojuego";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam(name = "id", required = false) Integer id, Model model) {
        model.addAttribute("videojuegos", videojuegoService.getTodosLosVideojuegos());
        if (id != null) {
            model.addAttribute("videojuego", videojuegoService.getVideojuego(id));
        } else {
            model.addAttribute("videojuego", null);
        }
        return "EditarVideojuego";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Videojuego videojuego) {
        LoggerFactory.getLogger(getClass()).info("Se actualizo el videojuego  'id': " + videojuego.getId());
        LoggerFactory.getLogger(getClass()).info("Info guardada: " + videojuego);
        videojuegoService.actualizarVideojuego(videojuego);
        return "redirect:/buscador/editar?exito&id=" + videojuego.getId();
    }



    @GetMapping("/eliminar")
    public String Formeliminar(Model model) {
        model.addAttribute("videojuegos", videojuegoService.getTodosLosVideojuegos());
        return "EliminarVideojuego";
    }
    @PostMapping("/delete")
    public String eliminar(@RequestParam Integer id) {
        boolean eliminado = videojuegoService.eliminarVideojuego(id);
        if (eliminado) {
            return "redirect:/buscador/eliminar?eliminado=true";
        } else {
            return "redirect:/buscador/eliminar?error=notfound";
        }
    }
}

