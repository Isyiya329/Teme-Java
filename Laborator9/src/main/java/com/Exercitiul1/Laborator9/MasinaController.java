package com.Exercitiul1.Laborator9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/masini")
public class MasinaController {
    @Autowired
    private MasinaService service;

    @PostMapping("/add")
    public void addMasina(@RequestBody Masina masina) {
        service.addMasina(masina);
    }

    @DeleteMapping("/delete/{numarInmatriculare}")
    public void deleteMasina(@PathVariable String numarInmatriculare) {
        service.deleteMasina(numarInmatriculare);
    }

    @GetMapping("/{numarInmatriculare}")
    public Optional<Masina> getMasina(@PathVariable String numarInmatriculare) {
        return service.getMasina(numarInmatriculare);
    }

    @GetMapping("/all")
    public List<Masina> getAllMasini() {
        return service.getAllMasini();
    }

    @GetMapping("/marca/{marca}")
    public List<Masina> getMasiniByMarca(@PathVariable String marca) {
        return service.getMasiniByMarca(marca);
    }

    @GetMapping("/count-sub-100k")
    public int countMasiniKilometriSub100k() {
        return service.countMasiniKilometriSub100k();
    }

    @GetMapping("/noi")
    public List<Masina> getMasiniNoi() {
        return service.getMasiniNoi();
    }
}