package mx.unam.aragon.ico.te.Planetas.del.sistema.solar.controladores;


import jakarta.persistence.EntityNotFoundException;
import mx.unam.aragon.ico.te.Planetas.del.sistema.solar.modelos.Planeta;
import mx.unam.aragon.ico.te.Planetas.del.sistema.solar.sericicios.PlanetaService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/sistemasolar")
public class PlanetaController {
    @Autowired
    private PlanetaService planetaService;

    //CREATE
    @GetMapping("/planeta")
    public String planetas(Model model) {
        model.addAttribute("planeta", new Planeta());
        return "formPlaneta";
    }
    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Planeta planeta
    ) {
        LoggerFactory.getLogger(getClass()).info("Guardando Planeta " + planeta);
        //mandarlo a DB (save) -JPA,ORM
        planetaService.guardarplaneta(planeta); //guardo al muso que estoy recuperando
        return "redirect:/sistemasolar/planeta?exito";
    }

    //READ
    @GetMapping("/buscar")
    public String planeta(@RequestParam(required = false) Integer id, Model model) {
        if (id != null) {
            try {
                model.addAttribute("planetabuscado",planetaService.getplaneta(id) );
            } catch (EntityNotFoundException e) {
                model.addAttribute("error", "No se encontró un planeta con ID " + id);
            }
        }
        return "VerPlaneta";
    }

    @GetMapping("/buscarTodos")
    public String mostrarTodosLosPlanetas(Model model) {
        List<Planeta> planetas = planetaService.getTodosLosplanetas();
        model.addAttribute("todosLosPlanetas", planetas);
        return "VerPlaneta";
    }

    //UPDATE
    @GetMapping("/editar")
    public String editar(@RequestParam(name = "id", required = false) Integer id, Model model) {
        model.addAttribute("planetas", planetaService.getTodosLosplanetas()); // lista de planetas

        if (id != null) {
            model.addAttribute("planeta", planetaService.getplaneta(id)); // planeta individual
        } else {
            model.addAttribute("planeta", null); // ocultar formulario si no hay selección
        }

        return "EditarPlaneta";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Planeta planeta) {
        LoggerFactory.getLogger(getClass()).info("Se actualizo el planeta  'id': " + planeta.getId());
        LoggerFactory.getLogger(getClass()).info("Info guardada: " + planeta);
        planetaService.actualizarplaneta(planeta);
        return "redirect:/sistemasolar/editar?exito&id=" + planeta.getId();
    }




    //DELETE
    @GetMapping("/eliminar")
    public String Formeliminar(Model model) {
        model.addAttribute("planeta", planetaService.getTodosLosplanetas());
        return "EliminarPlaneta";
    }
    @PostMapping("/delete")
    public String eliminar(@RequestParam Integer id) {
        boolean eliminado = planetaService.eliminarplaneta(id);
        if (eliminado) {
            return "redirect:/sistemasolar/eliminar?eliminado=true";
        } else {
            return "redirect:/sistemasolar/eliminar?error=notfound";
        }
    }
}