package com.Exercitiul3.Laborator9;

@Service
public class MasinaService {
    private final MasinaRepository masinaRepository;

    public MasinaService(MasinaRepository masinaRepository) {
        this.masinaRepository = masinaRepository;
    }

    public Masina adaugaMasina(Masina masina) {
        return masinaRepository.save(masina);
    }

    public void stergeMasina(String numarInmatriculare) {
        masinaRepository.deleteByNumarInmatriculare(numarInmatriculare);
    }

    public Masina cautaMasina(String numarInmatriculare) {
        return masinaRepository.findByNumarInmatriculare(numarInmatriculare)
                .orElseThrow(() -> new RuntimeException("Masina nu a fost gasita."));
    }

    public List<Masina> listaMasini() {
        return masinaRepository.findAll();
    }

    public long numarMasiniCuMarca(String marca) {
        return masinaRepository.countByMarca(marca);
    }

    public long numarMasiniSub100kKm() {
        return masinaRepository.countByNumarKilometriLessThan(100000);
    }

    public List<Masina> masiniMaiNoiDe5Ani() {
        int anCurent = LocalDate.now().getYear();
        return masinaRepository.findByAnulFabricatieiGreaterThanEqual(anCurent - 5);
    }
}
