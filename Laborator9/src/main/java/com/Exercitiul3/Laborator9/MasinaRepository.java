package com.Exercitiul3.Laborator9;

public interface MasinaRepository extends JpaRepository<Masina, Long> {
    Optional<Masina> findByNumarInmatriculare(String numarInmatriculare);
    long countByMarca(String marca);
    long countByNumarKilometriLessThan(int kilometri);
    List<Masina> findByAnulFabricatieiGreaterThanEqual(int an);
}
