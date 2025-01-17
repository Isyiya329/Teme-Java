package com.Exercitiu.Laborator11;

import com.example.demo.model.Eveniment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EvenimentRepository extends JpaRepository<Eveniment, Long> {
    List<Eveniment> findByLocatie(String locatie);
    List<Eveniment> findByData(LocalDate data);
}

