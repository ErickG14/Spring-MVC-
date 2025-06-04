package test.java.unam.aragon.Carrosmvc.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.java.unam.aragon.Carrosmvc.Modelo.Carro;
import test.java.unam.aragon.Carrosmvc.Repositorio.CarroRepository;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public boolean guardarCarro(Carro carro) {
        Carro resultado = carroRepository.save(carro);
        return resultado != null;
    }

    public Carro getCarro(Integer id) {
        return carroRepository.getById(id);
    }

}
