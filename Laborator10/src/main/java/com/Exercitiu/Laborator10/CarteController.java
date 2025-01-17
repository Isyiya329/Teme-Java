package com.Exercitiu.Laborator10;

@Controller
@RequestMapping("/carti")
class CarteController {

    private final CarteRepository carteRepository;

    public CarteController(CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }

    @GetMapping
    public String listaCarti(Model model) {
        model.addAttribute("carti", carteRepository.findAll());
        return "carti";
    }

    @PostMapping("/adauga")
    public String adaugaCarte(@RequestParam String isbn, @RequestParam String titlu, @RequestParam String autor, Model model) {
        if (isbn.isEmpty() || titlu.isEmpty() || autor.isEmpty()) {
            model.addAttribute("mesaj", "Adaugarea nu se realizează dacă nu completaţi toate caracteristicile!");
        } else {
            Carte carte = new Carte();
            carte.setIsbn(isbn);
            carte.setTitlu(titlu);
            carte.setAutor(autor);
            carteRepository.save(carte);
            model.addAttribute("mesaj", "Adaugare realizata cu succes!");
        }
        model.addAttribute("carti", carteRepository.findAll());
        return "carti";
    }

    @PostMapping("/modifica")
    public String modificaCarte(@RequestParam String isbn, @RequestParam String titlu, @RequestParam String autor, Model model) {
        Carte carte = carteRepository.findById(isbn).orElse(null);
        if (carte == null) {
            model.addAttribute("mesaj", "Nu se gaseste nicio carte cu isbn-ul introdus.");
        } else {
            carte.setTitlu(titlu);
            carte.setAutor(autor);
            carteRepository.save(carte);
            model.addAttribute("mesaj", "Cartea cu ISBN-ul " + isbn + " a fost modificata!");
        }
        model.addAttribute("carti", carteRepository.findAll());
        return "carti";
    }

    @PostMapping("/sterge")
    public String stergeCarte(@RequestParam String isbn, Model model) {
        if (carteRepository.existsById(isbn)) {
            carteRepository.deleteById(isbn);
            model.addAttribute("mesaj", "Cartea cu ISBN-ul " + isbn + " a fost stearsa!");
        } else {
            model.addAttribute("mesaj", "Nu se gaseste nicio carte cu isbn-ul introdus.");
        }
        model.addAttribute("carti", carteRepository.findAll());
        return "carti";
    }

    @PostMapping("/filtreaza")
    public String filtreazaCarti(@RequestParam(required = false) String autor, Model model) {
        if (autor == null || autor.isEmpty()) {
            model.addAttribute("mesaj", "Toate cartile sunt afisate.");
            model.addAttribute("carti", carteRepository.findAll());
        } else {
            List<Carte> carti = carteRepository.findByAutor(autor);
            if (carti.isEmpty()) {
                model.addAttribute("mesaj", "Nu exista carti ale autorului " + autor + ".");
            } else {
                model.addAttribute("mesaj", "Cartile urmatoare apartin autorului " + autor + ".");
                model.addAttribute("carti", carti);
            }
        }
        return "carti";
    }
}