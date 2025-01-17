package com.Exercitiul3.Laborator9;

@Entity
@Table(name = "masini")
public class Masina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numarInmatriculare;

    private String marca;
    private int anulFabricatiei;
    private String culoare;
    private int numarKilometri;
}