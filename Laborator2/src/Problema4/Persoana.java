package Problema4;

import java.time.LocalDate;

public class Persoana
{
    private String nume;
    private String cnp;
    
    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public String getCnp() {
        return cnp;
    }

    public int getVarsta() {
        int anulNasterii = Integer.parseInt(cnp.substring(1, 3));
        int lunaNasterii = Integer.parseInt(cnp.substring(3, 5));
        int ziuaNasterii = Integer.parseInt(cnp.substring(5, 7));

        int secol = (cnp.charAt(0) == '1' || cnp.charAt(0) == '2') ? 1900 : 2000;
        anulNasterii += secol;

        LocalDate dataCurenta = LocalDate.now();
        int anulCurent = dataCurenta.getYear();
        int lunaCurenta = dataCurenta.getMonthValue();
        int ziuaCurenta = dataCurenta.getDayOfMonth();

        int varsta = anulCurent - anulNasterii;

        if (lunaCurenta < lunaNasterii || (lunaCurenta == lunaNasterii && ziuaCurenta < ziuaNasterii)) {
            varsta--;
        }

        return varsta;
    }

}
