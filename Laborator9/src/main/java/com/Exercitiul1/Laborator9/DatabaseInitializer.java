package com.Exercitiul1.Laborator9;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseInitializer {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseInitializer(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void initializeDatabase() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS masini (" +
                "numarInmatriculare VARCHAR(15) PRIMARY KEY, " +
                "marca VARCHAR(50), " +
                "anFabricatie INT, " +
                "culoare VARCHAR(20), " +
                "numarKilometri INT");

        jdbcTemplate.execute("INSERT INTO masini (numarInmatriculare, marca, anFabricatie, culoare, numarKilometri) VALUES " +
                "('AB123CD', 'Toyota', 2019, 'Alb', 45000), " +
                "('BC234EF', 'Honda', 2020, 'Negru', 30000), " +
                "('CD345GH', 'Ford', 2018, 'Albastru', 70000), " +
                "('DE456IJ', 'BMW', 2021, 'Rosu', 25000), " +
                "('EF567KL', 'Audi', 2022, 'Verde', 15000)");
    }
}

