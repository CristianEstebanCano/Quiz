package com.example.Quiz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Quiz.Model.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
