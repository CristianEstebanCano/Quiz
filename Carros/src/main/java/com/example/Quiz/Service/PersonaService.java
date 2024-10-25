package com.example.Quiz.Service;


import com.example.Quiz.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import com.example.Quiz.Model.Persona;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona actualizarPersona(Long id, Persona persona) {
        return personaRepository.findById(id)
                .map(existing -> {
                    existing.setNombre(persona.getNombre());
                    existing.setApellido1(persona.getApellido1());
                    existing.setApellido2(persona.getApellido2());
                    existing.setDni(persona.getDni());
                    return personaRepository.save(existing);
                }).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    public void borrarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}
