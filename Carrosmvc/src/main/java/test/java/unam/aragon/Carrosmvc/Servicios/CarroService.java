package test.java.unam.aragon.Carrosmvc.Servicios;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.java.unam.aragon.Carrosmvc.Modelo.Carro;
import test.java.unam.aragon.Carrosmvc.Repositorio.CarroRepository;

import java.util.List;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    //Crear

    public boolean guardarCarro(Carro carro) {
        Carro resultado = carroRepository.save(carro);
        return resultado != null;
    }

    //Vista

    public Carro getCarro(Integer id) {
        return carroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Carro con id: " + id + " no encontrado"));
    }

    public List<Carro> getTodo() {
        return carroRepository.findAll();
    }

    //Actualizar
    public boolean actualizarCarro(Carro carro) {
        if (carroRepository.existsById(carro.getId())) {
            carroRepository.save(carro);
            return true;
        }
        return false;
    }

    // Borrar

    public boolean eliminarCarro(Integer id) {
        if (carroRepository.existsById(id)) {
            carroRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
