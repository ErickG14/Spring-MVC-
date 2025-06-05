package mx.unam.aragon.ico.te.pinturasMVC.Controlador;

import jakarta.persistence.EntityNotFoundException;
import mx.unam.aragon.ico.te.pinturasMVC.Modelo.Pintura;
import mx.unam.aragon.ico.te.pinturasMVC.Servicios.PinturaService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/galeria/")
public class ControlPrincipal {
    @Autowired
    private PinturaService pinturaService;


    @GetMapping()
    public String index() {
        return "index";
    }

    // Vista
    @GetMapping("/vista/")
    public String Vista(@RequestParam(required = false) Integer id, Model model) {
        if (id != null) {
            try {
                model.addAttribute("PinturaBuscada",pinturaService.getpintura(id) );
            } catch (EntityNotFoundException e) {
                model.addAttribute("error", "No se encontró una pintura con ID " + id);
            }
        }
        return "VerPintura";
    }

    @GetMapping("/buscarTodos")
    public String mostrarTodasLasPinturas(Model model) {
        List<Pintura> pinturas = pinturaService.getTodo();
        model.addAttribute("TodaslasPinturas", pinturas);
        return "VerPintura";
    }

    // Crear
    @GetMapping("/Crear/")
    public String pinturas(Model model) {
        model.addAttribute("pintura", new Pintura());
        return "formCrear";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Pintura pintura
    ) {
        LoggerFactory.getLogger(getClass()).info("Guardando pintura " + pintura);
        // mandarlo a BD (save)
        pinturaService.guardarCarro(pintura);
        return "redirect:/galeria/Crear/?exito";
    }

    // Actualizar
    @GetMapping("/modificar/")
    public String modificar(@RequestParam(name = "id", required = false) Integer id, Model model) {
        model.addAttribute("pinturass", pinturaService.getTodo());
        if (id != null) {
            model.addAttribute("pintura", pinturaService.getpintura(id));
        } else {
            model.addAttribute("pinturaa", null);
        }
        return "formActualizar";
    }


    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Pintura pintura) {
        LoggerFactory.getLogger(getClass()).info("Se actualizo la pintura 'id': " + pintura.getId());
        LoggerFactory.getLogger(getClass()).info("Info guardada: " + pintura);
        pinturaService.actualizarPintura(pintura);
        return "redirect:/galeria/modificar/?exito&id=" + pintura.getId();
    }

    // Borrar
    @GetMapping("/borrar/")
    public String borrar(Model model) {
        model.addAttribute("pinturass", pinturaService.getTodo());
        return "BorrarPintura";
    }
    @PostMapping("/delete")
    public String eliminar(@RequestParam Integer id) {
        boolean eliminado = pinturaService.eliminarPintura(id);
        if (eliminado) {
            return "redirect:/galeria/borrar/?eliminado=true";
        } else {
            return "redirect:/galeria/borrar/?error=notfound";
        }
    }
}
