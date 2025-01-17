package com.Exercitiul2.Laborator9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class MasinaService {
    @Autowired
    private MasinaRepository repository;

    public void addMasina(Masina masina) {
        repository.save(masina);
    }

    public void deleteMasina(String numarInmatriculare) {
        repository.deleteById(numarInmatriculare);
    }

    public Optional<Masina> getMasina(String numarInmatriculare) {
        return repository.findById(numarInmatriculare);
    }

    public List<Masina> getAllMasini() {
        return repository.findAll();
    }

    public List<Masina> getMasiniByMarca(String marca) {
        return repository.findByMarca(marca);
    }

    public int countMasiniKilometriSub100k() {
        return repository.countByKilometriLessThan100k();
    }

    public List<Masina> getMasiniNoi() {
        int yearThreshold = Year.now().getValue() - 5;
        return repository.findMasiniNoi(yearThreshold);
    }
}

