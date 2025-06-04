package test.java.unam.aragon.Carrosmvc.Controlador;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.java.unam.aragon.Carrosmvc.Modelo.Carro;
import test.java.unam.aragon.Carrosmvc.Servicios.CarroService;

@Controller
@RequestMapping("/Agencia/")
public class ControlPrincipal {
    @Autowired
    private CarroService carroService;


    @GetMapping()
    public String index() {
        return "index";
    }

    @GetMapping("/Carro/")
    public String Carro(Model model) {
        Carro carro = new Carro(1, "Toyota", "Corolla", 2022, "XLE", "Rojo Metalico", "https://carsline.com.mx/wp-content/uploads/2024/03/01-55.jpg");
        model.addAttribute("carro", carro);
        return "Carro";
    }

    @GetMapping("/Crear/")
    public String formCrear(Model model) {
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

    @GetMapping("/Carro/{id}")
    public String Carro(@PathVariable int id, Model model) {
        model.addAttribute("carro", carroService.getCarro(id));
        return "Carro";
    }

}
