package com.Exercitiul2.Laborator9;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MasinaRepository extends JpaRepository<Masina, String> {
    List<Masina> findByMarca(String marca);

    @Query("SELECT COUNT(m) FROM Masina m WHERE m.numarKilometri < 100000")
    int countByKilometriLessThan100k();

    @Query("SELECT m FROM Masina m WHERE m.anFabricatie > :year")
    List<Masina> findMasiniNoi(int year);
}


