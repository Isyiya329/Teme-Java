package Problema2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp
{
    private static final String FILE_NAME = "instrumente.json";
    private static Set<InstrumentMuzical> instrumente = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Meniu:");
            System.out.println("1. Adauga instrumente");
            System.out.println("2. Salveaza in fisier");
            System.out.println("3. Incarca din fisier");
            System.out.println("4. Afiseaza instrumente");
            System.out.println("5. Filtreaza chitari");
            System.out.println("6. Filtreaza seturi de tobe");
            System.out.println("7. Sterge instrumente scumpe");
            System.out.println("0. Iesire");

            int optiune = scanner.nextInt();
            switch (optiune) {
                case 1: adaugaInstrumente(); break;
                case 2: salveazaInFisier(); break;
                case 3: incarcaDinFisier(); break;
                case 4: afiseazaInstrumente(); break;
                case 5: filtreazaChitari(); break;
                case 6: filtreazaSeturiTobe(); break;
                case 7: stergeInstrumenteScumpe(); break;
                case 0: System.exit(0);
                default: System.out.println("Optiune invalida!");
            }
        }
    }

    private static void adaugaInstrumente() {
        instrumente.add(new Chitara("Gibson", 2500, Chitara.TipChitara.ELECTRICA, 6));
        instrumente.add(new Chitara("Yamaha", 1800, Chitara.TipChitara.ACUSTICA, 6));
        instrumente.add(new Chitara("Fender", 3200, Chitara.TipChitara.CLASICA, 12));
        instrumente.add(new SetTobe("Roland", 5000, SetTobe.TipTobe.ELECTRONICE, 5, 3));
        instrumente.add(new SetTobe("Pearl", 3500, SetTobe.TipTobe.ACUSTICE, 4, 2));
        System.out.println("Instrumente adaugate!");
    }

    private static void salveazaInFisier() {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
        try {
            mapper.writeValue(new File(FILE_NAME), instrumente);
            System.out.println("Date salvate in fisier!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void incarcaDinFisier() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            instrumente = mapper.readValue(new File(FILE_NAME), mapper.getTypeFactory().constructCollectionType(HashSet.class, InstrumentMuzical.class));
            System.out.println("Date incarcate din fisier!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void afiseazaInstrumente() {
        instrumente.forEach(i -> System.out.println(i.getProducator() + " - " + i.getTip() + " - " + i.getPret()));
    }

    private static void filtreazaChitari() {
        instrumente.stream().filter(i -> i instanceof Chitara).forEach(i -> System.out.println(i.getProducator()));
    }

    private static void filtreazaSeturiTobe() {
        instrumente.stream().filter(i -> i.getClass() == SetTobe.class).forEach(i -> System.out.println(i.getProducator()));
    }

    private static void stergeInstrumenteScumpe() {
        instrumente.removeIf(i -> i.getPret() > 3000);
        System.out.println("Instrumente scumpe sterse!");
    }
}
