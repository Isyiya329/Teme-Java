package com.Exercitiu.Laborator11;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/evenimente")
public class EvenimenteController {

    private final EvenimentRepository repository;

    public EvenimenteController(EvenimentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Eveniment> getAllEvents() {
        return repository.findAll();
    }

    @GetMapping("/locatie/{locatie}")
    public List<Eveniment> getByLocatie(@PathVariable String locatie) {
        return repository.findByLocatie(locatie);
    }

    @PostMapping
    public Eveniment addEvent(@RequestBody Eveniment eveniment) {
        return repository.save(eveniment);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

