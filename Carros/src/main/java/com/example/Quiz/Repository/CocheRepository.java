package com.example.Quiz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Quiz.Model.Coche;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche, String> {
}