package test.java.unam.aragon.Carrosmvc.Controlador;


import jakarta.persistence.EntityNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.java.unam.aragon.Carrosmvc.Modelo.Carro;
import test.java.unam.aragon.Carrosmvc.Servicios.CarroService;

import java.util.List;

@Controller
@RequestMapping("/Agencia/")
public class ControlPrincipal {
    @Autowired
    private CarroService carroService;


    @GetMapping()
    public String index() {
        return "index";
    }

    // Vista - modificar
    @GetMapping("/vista/")
    public String Vista(@RequestParam(required = false) Integer id, Model model) {
        if (id != null) {
            try {
                model.addAttribute("CarroBuscado",carroService.getCarro(id) );
            } catch (EntityNotFoundException e) {
                model.addAttribute("error", "No se encontró un Carro con ID " + id);
            }
        }
        return "VerCarro";
    }

    @GetMapping("/buscarTodos")
    public String mostrarTodosLosMuseos(Model model) {
        List<Carro> carros = carroService.getTodo();
        model.addAttribute("TodolosCarros", carros);
        return "VerCarro";
    }

    // Crear
    @GetMapping("/Crear/")
    public String carros(Model model) {
        model.addAttribute("carro", new Carro());
        return "formCrear";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Carro carro
    ) {
        LoggerFactory.getLogger(getClass()).info("Guardando Carro " + carro);
        // mandarlo a BD (save)
        carroService.guardarCarro(carro);
        return "redirect:/Agencia/Crear/?exito";
    }

    // Actualizar
    @GetMapping("/modificar")
    public String modificar(@RequestParam(name = "id", required = false) Integer id, Model model) {
        model.addAttribute("carro", carroService.getTodo());
        if (id != null) {
            model.addAttribute("carro", carroService.getCarro(id));
        } else {
            model.addAttribute("carro", null); // Oculta el formulario si no se selecciono el museo
        }
        return "formActualizar";
    }


    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Carro carro) {
        LoggerFactory.getLogger(getClass()).info("Se actualizo el museo  'id': " + carro.getId());
        LoggerFactory.getLogger(getClass()).info("Info guardada: " + carro);
        carroService.actualizarCarro(carro);
        return "redirect:/Agencia/modificar?exito&id=" + carro.getId();
    }

    // Borrar
    @GetMapping("/borrar")
    public String borrar(Model model) {
        model.addAttribute("carros", carroService.getTodo());
        return "borrar";
    }
    @PostMapping("/delete")
    public String eliminar(@RequestParam Integer id) {
        boolean eliminado = carroService.eliminarCarro(id);
        if (eliminado) {
            return "redirect:/Agencia/borrar?eliminado=true";
        } else {
            return "redirect:/Agencia/borrar?error=notfound";
        }
    }
}


