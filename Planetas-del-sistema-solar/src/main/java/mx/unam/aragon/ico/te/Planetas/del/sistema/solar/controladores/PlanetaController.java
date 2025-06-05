package mx.unam.aragon.ico.te.Planetas.del.sistema.solar.controladores;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")

public class PlanetaController {

     @GetMapping("/index")
    public String index() {
         return "index";
     }


     @GetMapping("/ver")
    public String verplaneta(){
        return "VerPlaneta";
    }


}
