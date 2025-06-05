package mx.unam.aragon.ico.te.pf.peliculasmvc.controladores;

import jakarta.persistence.EntityNotFoundException;
import mx.unam.aragon.ico.te.pf.peliculasmvc.modelos.Pelicula;
import mx.unam.aragon.ico.te.pf.peliculasmvc.servicios.PeliculaService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/buscador")
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/pelicula")
    public String peliculas(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "FormPelicula";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Pelicula pelicula) {
        LoggerFactory.getLogger(getClass()).info("Guardando Pelicula " + pelicula);
        peliculaService.guardarPelicula(pelicula);
        return "redirect:/buscador/pelicula?exito";
    }

    @GetMapping("/buscar")
    public String pelicula(@RequestParam(required = false) Integer id, Model model) {
        if (id != null) {
            try {
                model.addAttribute("peliculaBuscado",peliculaService.getPelicula(id) );
            } catch (EntityNotFoundException e) {
                model.addAttribute("error", "No se encontró una pelicula con ID " + id);
            }
        }
        return "VerPeliculas";
    }

    @GetMapping("/buscarTodos")
    public String mostrarTodasLasPeliculas(Model model) {
        List<Pelicula> peliculas = peliculaService.getTodasLasPeliculas();
        model.addAttribute("todasLasPeliculas", peliculas);
        return "VerPeliculas";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam(name = "id", required = false) Integer id, Model model) {
        model.addAttribute("peliculas", peliculaService.getTodasLasPeliculas());
        if (id != null) {
            model.addAttribute("pelicula", peliculaService.getPelicula(id));
        } else {
            model.addAttribute("pelicula", null);
        }
        return "EditarPelicula";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Pelicula pelicula) {
        LoggerFactory.getLogger(getClass()).info("Se actualizo la pelicula  'id': " + pelicula.getId());
        LoggerFactory.getLogger(getClass()).info("Info guardada: " + pelicula);
            peliculaService.actualizarPelicula(pelicula);
        return "redirect:/buscador/editar?exito&id=" + pelicula.getId();
    }

    @GetMapping("/eliminar")
    public String Formeliminar(Model model) {
        model.addAttribute("peliculas", peliculaService.getTodasLasPeliculas());
        return "EliminarPelicula";
    }
    @PostMapping("/delete")
    public String eliminar(@RequestParam Integer id) {
        boolean eliminado = peliculaService.eliminarPelicula(id);
        if (eliminado) {
            return "redirect:/buscador/eliminar?eliminado=true";
        } else {
            return "redirect:/buscador/eliminar?error=notfound";
        }
    }
}
