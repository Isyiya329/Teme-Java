package com.Exercitiul3.Laborator9;

@RestController
@RequestMapping("/masini")
public class MasinaController {
    private final MasinaService masinaService;

    public MasinaController(MasinaService masinaService) {
        this.masinaService = masinaService;
    }

    @PostMapping
    public Masina adaugaMasina(@RequestBody Masina masina) {
        return masinaService.adaugaMasina(masina);
    }

    @DeleteMapping("/{numarInmatriculare}")
    public void stergeMasina(@PathVariable String numarInmatriculare) {
        masinaService.stergeMasina(numarInmatriculare);
    }

    @GetMapping("/{numarInmatriculare}")
    public Masina cautaMasina(@PathVariable String numarInmatriculare) {
        return masinaService.cautaMasina(numarInmatriculare);
    }

    @GetMapping
    public List<Masina> listaMasini() {
        return masinaService.listaMasini();
    }
}
