package Problema2;

public class Chitara extends InstrumentMuzical
{
    enum TipChitara { ELECTRICA, ACUSTICA, CLASICA }
    private TipChitara tip_chitara;
    private int nr_corzi;

    public Chitara(String producator, double pret, TipChitara tip_chitara, int nr_corzi) {
        super(producator, pret);
        this.tip_chitara = tip_chitara;
        this.nr_corzi = nr_corzi;
    }

    public Chitara()
    {

    }

    public int getNrCorzi() { return nr_corzi; }
    public String getTip() { return "Chitara"; }
}
