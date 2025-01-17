package com.Exercitiul1.Laborator9;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MasinaRepository extends CrudRepository<Masina, String> {
    @Query("SELECT * FROM masini WHERE marca = :marca")
    List<Masina> findByMarca(String marca);

    @Query("SELECT COUNT(*) FROM masini WHERE numarKilometri < 100000")
    int countByKilometriLessThan100k();

    @Query("SELECT * FROM masini WHERE anFabricatie > YEAR(CURDATE()) - 5")
    List<Masina> findMasiniNoi();
}

