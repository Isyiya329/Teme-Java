package com.Exercitiu.Laborator10;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

interface CarteRepository extends JpaRepository<Carte, String> {
    List<Carte> findByAutor(String autor);
}
