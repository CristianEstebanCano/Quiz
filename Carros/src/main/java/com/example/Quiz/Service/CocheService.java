package com.example.Quiz.Service;

import com.example.Quiz.Repository.CocheRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import com.example.Quiz.Model.Coche;
@Service
public class CocheService {

    @Autowired
    private CocheRepository cocheRepository;

    public Coche guardarCoche(Coche coche) {
        return cocheRepository.save(coche);
    }

    public Coche actualizarCoche(String matricula, Coche coche) {
        return cocheRepository.findById(matricula)
                .map(existing -> {
                    existing.setMarca(coche.getMarca());
                    existing.setModelo(coche.getModelo());
                    existing.setCaballos(coche.getCaballos());
                    return cocheRepository.save(existing);
                }).orElseThrow(() -> new RuntimeException("Coche no encontrado"));
    }

    public void borrarCoche(String matricula) {
        cocheRepository.deleteById(matricula);
    }
}